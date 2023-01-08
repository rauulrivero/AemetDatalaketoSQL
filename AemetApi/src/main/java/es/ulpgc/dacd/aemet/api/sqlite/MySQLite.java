package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.SQLException;
import java.util.List;

public interface MySQLite {
    List<Weather> getWeathers(String tablename) throws SQLException;
}
