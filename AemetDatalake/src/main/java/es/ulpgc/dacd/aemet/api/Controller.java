package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.datalake.FileDatalake;
import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.sensor.AemetApiReader;

import java.io.IOException;
import java.util.List;

public class Controller {
    private final AemetApiReader aemetApiReader;
    private final FileDatalake fileDatalake;

    public Controller() {
        aemetApiReader = new AemetApiReader();
        fileDatalake = new FileDatalake();
    }

    public void run() throws IOException {
        List<Weather> data = aemetApiReader.getData();
        fileDatalake.createFile(data);
    }
}
