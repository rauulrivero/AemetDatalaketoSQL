package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.SQLException;

/**
 * The interface Aemet sq lite.
 */
public interface AemetSQLite {

    /**
     * Init.
     *
     * @throws SQLException the sql exception
     */
    void init() throws SQLException;

    /**
     * Insert max weather.
     *
     * @param weather the weather
     * @throws SQLException the sql exception
     */
    void insertMaxWeather(Weather weather) throws SQLException;

    /**
     * Insert min weather.
     *
     * @param weather the weather
     * @throws SQLException the sql exception
     */
    void insertMinWeather(Weather weather) throws SQLException;
}
