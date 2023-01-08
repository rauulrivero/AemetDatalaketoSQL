package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.time.LocalDate;
import java.util.Date;

public class Translate {
    private Translate() {
    }

    private static final String INSERT_MAXWEATHER =
            "INSERT INTO maxtemperatures(date, station, place, time, temperature) VALUES('%s', '%s', '%s', '%s', '%f');";

    private static final String INSERT_MINWEATHER =
            "INSERT INTO mintemperatures(date, station, place, time, temperature) VALUES('%s', '%s', '%s', '%s', '%f');";


    public static String insertmaxWeather(Weather weather){
        return String.format(INSERT_MAXWEATHER,
                weather.date,
                weather.station,
                weather.place,
                weather.time,
                weather.temperature);
    }

    public static String insertminWeather(Weather weather){
        return String.format(INSERT_MINWEATHER,
                weather.date,
                weather.station,
                weather.place,
                weather.time,
                weather.temperature);
    }

}
