package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.command.Command;
import es.ulpgc.dacd.aemet.api.datalake.DatafileReader;
import es.ulpgc.dacd.aemet.api.datalake.Datalake;
import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.sqlite.AemetSQLite;
import es.ulpgc.dacd.aemet.api.sqlite.SQLiteAemetDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {


    private final AemetSQLite sqLiteAemetDatabase;
    private final Datalake datafileReader;

    public Controller() {
        sqLiteAemetDatabase = new SQLiteAemetDatabase();
        datafileReader = new DatafileReader();
    }
    public void run() throws IOException, SQLException {
        List<Weather> weathers = datafileReader.getWeathers("C:/Users/rauul/Desktop/GCID 2º/DACD/AemetApiDatalake/datalake");
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
