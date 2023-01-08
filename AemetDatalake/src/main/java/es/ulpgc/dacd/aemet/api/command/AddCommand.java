package es.ulpgc.dacd.aemet.api.command;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class AddCommand {


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
