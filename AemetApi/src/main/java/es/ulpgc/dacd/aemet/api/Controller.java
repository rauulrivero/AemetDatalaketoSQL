package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.restapi.WebService;
import es.ulpgc.dacd.aemet.api.sqlite.SQLiteConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<Weather> maxweathers;
    public static List<Weather> minweathers;
    private final SQLiteConnection sqLiteConnection;
    private final WebService webService;

    public Controller() {
        sqLiteConnection = new SQLiteConnection();
        webService = new WebService();
    }

    public void run() throws SQLException {
        maxweathers = sqLiteConnection.getWeathers("maxtemperatures");
        minweathers = sqLiteConnection.getWeathers("mintemperatures");
        webService.start();
    }
}
