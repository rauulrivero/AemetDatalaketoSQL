package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.restapi.WebService;
import es.ulpgc.dacd.aemet.api.restapi.ApiService;
import es.ulpgc.dacd.aemet.api.sqlite.DatabaseReader;
import es.ulpgc.dacd.aemet.api.sqlite.SQLiteReader;

import java.sql.SQLException;
import java.util.List;

/**
 * The type Controller.
 */
public class Controller {
    /**
     * The Maxweathers.
     */
    public static List<Weather> maxweathers;
    /**
     * The Minweathers.
     */
    public static List<Weather> minweathers;

    private Controller() {
    }

    /**
     * Run.
     *
     * @throws SQLException the sql exception
     */
    public static void run() throws SQLException {
        DatabaseReader sqLiteConnection = new SQLiteReader();
        WebService webService = new ApiService();
        maxweathers = sqLiteConnection.read("maxtemperatures");
        minweathers = sqLiteConnection.read("mintemperatures");
        webService.start();
    }
}
