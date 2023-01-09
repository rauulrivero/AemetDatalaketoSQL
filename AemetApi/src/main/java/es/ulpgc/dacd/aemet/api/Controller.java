package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.restapi.APIService;
import es.ulpgc.dacd.aemet.api.restapi.WebService;
import es.ulpgc.dacd.aemet.api.sqlite.MySQLite;
import es.ulpgc.dacd.aemet.api.sqlite.SQLiteConnection;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    public static List<Weather> maxweathers;
    public static List<Weather> minweathers;
    private static MySQLite sqLiteConnection;
    private static APIService webService;

    private Controller() {
    }

    public static void run() throws SQLException {
        sqLiteConnection = new SQLiteConnection();
        webService = new WebService();
        maxweathers = sqLiteConnection.getWeathers("maxtemperatures");
        minweathers = sqLiteConnection.getWeathers("mintemperatures");
        webService.start();
    }
}
