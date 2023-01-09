package es.ulpgc.dacd.aemet.api.sqlite;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

/**
 * The type Sqlite aemet database.
 */
public class SQLiteAemetDatabase implements AemetSQLite{
    /**
     * The constant PATH_DATAMART.
     */
    public static final String PATH_DATAMART = "datamart/datamart.db";
    private Connection conn;
    public void init() throws SQLException {
        conn = connect();
        Statement statement = conn.createStatement();
        createTable(statement);
        dropTable(statement, "maxTemperatures");
        dropTable(statement, "minTemperatures");
        createTable(statement);
    }

    public void close() throws SQLException {
        conn.close();
    }

    private Connection connect() {
        conn = null;
        try {
            String url = "jdbc:sqlite:" + PATH_DATAMART;
            conn = getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void dropTable(Statement statement, String tablename) throws SQLException {

        String sql = "DROP TABLE " + tablename;
        statement.executeUpdate(sql);
    }

    public void insertMaxWeather(Weather weather) throws SQLException {
        Statement statement = conn.createStatement();
            conn = connect();
            statement.execute(Translate.insertMaxWeather(weather));
    }

    public void insertMinWeather(Weather weather) throws  SQLException{
        Statement statement = conn.createStatement();
        conn = connect();
        statement.execute(Translate.insertMinWeather(weather));
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