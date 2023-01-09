package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Sq lite connection.
 */
public class SQLiteConnection implements MySQLite {
    private Connection conn;
    /**
     * The constant PATH_DATAMART.
     */
    public static final String PATH_DATAMART = "datamart/datamart.db";

    public List<Weather> getWeathers(String tableName) throws SQLException {
        conn = connect();
        return read(tableName);
    }

    private Connection connect() {
        conn = null;
        try {
            String url = "jdbc:sqlite:" + PATH_DATAMART;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private List<Weather> read(String tablename) throws SQLException {
        List<Weather> weathers = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + tablename);
            while (rs.next()) {
                Weather weather = new Weather(LocalDate.parse(rs.getString("date")), rs.getString("time"),
                        rs.getString("station"), rs.getString("place"), rs.getDouble("temperature"));
                weathers.add(weather);
            }
        } finally {
            conn.close();
        }
        return weathers;
    }
}
