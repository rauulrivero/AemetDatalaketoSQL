package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.command.Command;
import es.ulpgc.dacd.aemet.api.datalake.DatafileReader;
import es.ulpgc.dacd.aemet.api.datalake.Datalake;
import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.sqlite.AemetSQLite;
import es.ulpgc.dacd.aemet.api.sqlite.SQLiteAemetDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * The type Controller.
 */
public class Controller {


    private final AemetSQLite sqLiteAemetDatabase;
    private final Datalake datafileReader;

    /**
     * Instantiates a new Controller.
     */
    public Controller() {
        sqLiteAemetDatabase = new SQLiteAemetDatabase();
        datafileReader = new DatafileReader();
    }

    /**
     * Run.
     *
     * @throws IOException  the io exception
     * @throws SQLException the sql exception
     */
    public void run() throws IOException, SQLException, ParseException {
        List<Weather> weathers = datafileReader.getWeathers("datalake");
        List<Weather> maxweathers = Command.maxTemperatureSensors(weathers);
        List<Weather> minweathers = Command.minTemperatureSensors(weathers);
        saveWeathers(maxweathers, minweathers);
    }

    private void saveWeathers(List<Weather> maxweathers, List<Weather> minweathers) throws SQLException {
        sqLiteAemetDatabase.init();
        for (Weather maxweather: maxweathers) sqLiteAemetDatabase.insertMaxWeather(maxweather);
        for (Weather minweather: minweathers) sqLiteAemetDatabase.insertMinWeather(minweather);
    }
}
