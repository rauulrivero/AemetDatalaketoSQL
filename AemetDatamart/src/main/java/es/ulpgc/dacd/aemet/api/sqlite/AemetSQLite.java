package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.SQLException;

public interface AemetSQLite {

    void init() throws SQLException;

    void insertMaxWeather(Weather weather) throws SQLException;

    void insertMinWeather(Weather weather) throws SQLException;
}
