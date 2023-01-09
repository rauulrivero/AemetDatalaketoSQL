package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface My sq lite.
 */
public interface MySQLite {
    /**
     * Gets weathers.
     *
     * @param tablename the tablename
     * @return the weathers
     * @throws SQLException the sql exception
     */
    List<Weather> getWeathers(String tablename) throws SQLException;
}
