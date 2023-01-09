package es.ulpgc.dacd.aemet.api.command;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Weather result = results.get(weather.getDate());
            if (result == null || weather.getTemperature() > result.getTemperature()) {
                results.put(weather.getDate(), weather);
            }
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
            Weather result = results.get(weather.getDate());
            if (result == null || weather.getTemperature() < result.getTemperature()) {
                results.put(weather.getDate(), weather);
            }
        }
        return new ArrayList<>(results.values());
    }

    /**
     * Add list.
     *
     * @param jsonArray the json array
     * @return the list
     */
    public static List<Weather> add(JsonArray jsonArray) {
        List<Weather> datos = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

            String place = jsonObject.get("place").getAsString();
            String date = jsonObject.get("date").getAsString();
            String time = jsonObject.get("time").getAsString();
            double temperature = jsonObject.get("temperature").getAsDouble();
            String station = jsonObject.get("station").getAsString();

            datos.add(new Weather(date, time, station, place, temperature));
        }
        return datos;
    }
}
