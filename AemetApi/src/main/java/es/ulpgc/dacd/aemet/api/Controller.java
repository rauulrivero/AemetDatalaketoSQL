package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.restapi.APIService;
import es.ulpgc.dacd.aemet.api.restapi.WebService;
import es.ulpgc.dacd.aemet.api.sqlite.MySQLite;
import es.ulpgc.dacd.aemet.api.sqlite.SQLiteConnection;

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
        MySQLite sqLiteConnection = new SQLiteConnection();
        APIService webService = new WebService();
        maxweathers = sqLiteConnection.getWeathers("maxtemperatures");
        minweathers = sqLiteConnection.getWeathers("mintemperatures");
        webService.start();
    }
}
