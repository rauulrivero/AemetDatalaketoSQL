package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

/**
 * The type Translate.
 */
public class Translate {
    private Translate() {
    }

    private static final String INSERT_MAXWEATHER =
            "INSERT INTO maxTemperatures(date, station, place, time, temperature) VALUES('%s', '%s', '%s', '%s', '%f');";

    private static final String INSERT_MINWEATHER =
            "INSERT INTO minTemperatures(date, station, place, time, temperature) VALUES('%s', '%s', '%s', '%s', '%f');";


    /**
     * Insert max weather string.
     *
     * @param weather the weather
     * @return the string
     */
    public static String insertMaxWeather(Weather weather){
        return String.format(INSERT_MAXWEATHER,
                weather.date,
                weather.station,
                weather.place,
                weather.time,
                weather.temperature);
    }

    /**
     * Insert min weather string.
     *
     * @param weather the weather
     * @return the string
     */
    public static String insertMinWeather(Weather weather){
        return String.format(INSERT_MINWEATHER,
                weather.date,
                weather.station,
                weather.place,
                weather.time,
                weather.temperature);
    }

}
