package es.ulpgc.dacd.aemet.api.command;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * The type Command.
 */
public class Command {

    private Command() {
    }

    /**
     * Max temperature sensors list.
     *
     * @param weathers the weathers
     * @return the list
     */
    public static List<Weather> maxTemperatureSensors(List<Weather> weathers) {
        Map<String, Weather> results = new HashMap<>();

        for (Weather weather : weathers) {
            Weather result = results.get(String.valueOf(weather.getDate()));
            if (result == null || weather.getTemperature() > result.getTemperature())
                results.put(String.valueOf(weather.getDate()), weather);
        }
        return new ArrayList<>(results.values());
    }


    /**
     * Min temperature sensors list.
     *
     * @param weathers the weathers
     * @return the list
     */
    public static List<Weather> minTemperatureSensors(List<Weather> weathers) {
        Map<String, Weather> results = new HashMap<>();

        for (Weather weather : weathers) {
            Weather result = results.get(String.valueOf(weather.getDate()));
            if (result == null || weather.getTemperature() < result.getTemperature())
                results.put(String.valueOf(weather.getDate()), weather);
        }
        return new ArrayList<>(results.values());
    }

    /**
     * Add list.
     *
     * @param jsonArray the json array
     * @return the list
     */
    public static List<Weather> add(JsonArray jsonArray) throws ParseException {
        List<Weather> datos = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

            String place = jsonObject.get("place").getAsString();
            Date date = new SimpleDateFormat("MMM d, yyyy, h:mm:ss a", Locale.ENGLISH)
                    .parse(jsonObject.get("date").getAsString());
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String time = new SimpleDateFormat("HH:mm:ss").format(date);
            System.out.println(time);
            double temperature = jsonObject.get("temperature").getAsDouble();
            String station = jsonObject.get("station").getAsString();

            datos.add(new Weather(localDate, time, station, place, temperature));
        }
        return datos;
    }
}
