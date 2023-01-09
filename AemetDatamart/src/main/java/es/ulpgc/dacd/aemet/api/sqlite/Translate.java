package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

public class Translate {
    private Translate() {
    }

    private static final String INSERT_MAXWEATHER =
            "INSERT INTO maxTemperatures(date, station, place, time, temperature) VALUES('%s', '%s', '%s', '%s', '%f');";

    private static final String INSERT_MINWEATHER =
            "INSERT INTO minTemperatures(date, station, place, time, temperature) VALUES('%s', '%s', '%s', '%s', '%f');";


    public static String insertMaxWeather(Weather weather){
        return String.format(INSERT_MAXWEATHER,
                weather.date,
                weather.station,
                weather.place,
                weather.time,
                weather.temperature);
    }

    public static String insertMinWeather(Weather weather){
        return String.format(INSERT_MINWEATHER,
                weather.date,
                weather.station,
                weather.place,
                weather.time,
                weather.temperature);
    }

}
