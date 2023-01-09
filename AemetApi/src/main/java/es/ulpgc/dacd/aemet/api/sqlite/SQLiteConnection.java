package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLiteConnection implements MySQLite {
    private Connection conn;

    public List<Weather> getWeathers(String tablename) throws SQLException {
        String dbPath = "C:/Users/aural/Desktop/GCID 2º/DACD/AemetApiDatalake/datamart/datamart.db";
        conn = connect(dbPath);
        List <Weather> weathers = read(tablename);
        conn.close();
        return weathers;
    }

    private Connection connect(String dbPath) {
        conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
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
