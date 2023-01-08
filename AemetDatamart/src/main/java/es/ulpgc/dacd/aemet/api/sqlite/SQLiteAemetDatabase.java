package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static java.sql.DriverManager.getConnection;

public class SQLiteAemetDatabase implements AemetSQLite{
    public static final String PATH_DATAMART = "C:/Users/rauul/Desktop/GCID 2º/DACD/AemetApiDatalake/datamart/datamart.db";
    private Connection conn;
    public void init() throws SQLException {
        String dbPath = PATH_DATAMART;
        conn = connect(dbPath);
        Statement statement = conn.createStatement();
        deleteTable(statement, "maxtemperatures");
        deleteTable(statement, "mintemperatures");
        createTable(statement);
    }

    private Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void deleteTable(Statement statement, String tablename) throws SQLException {
        String sql = "DROP TABLE " + tablename;
        statement.executeUpdate(sql);
    }

    public void insertMaxWeather(Weather weather) throws SQLException {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            conn = connect(PATH_DATAMART);
            statement.execute(Translate.insertmaxWeather(weather));
        } finally {
            conn.close();
        }
    }

    public void insertMinWeather(Weather weather) throws  SQLException{
        Statement statement = conn.createStatement();
        conn = connect(PATH_DATAMART);
        statement.execute(Translate.insertminWeather(weather));
    }





    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS maxTemperatures (" +
                "place TEXT," +
                "station TEXT," +
                "date TEXT," +
                "time TEXT," +
                "temperature REAL" +
                ");");

        statement.execute("CREATE TABLE IF NOT EXISTS minTemperatures (" +
                "place TEXT," +
                "station TEXT," +
                "date TEXT," +
                "time TEXT," +
                "temperature REAL" +
                ");");

    }
}