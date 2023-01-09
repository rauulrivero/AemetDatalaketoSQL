package es.ulpgc.dacd.aemet.api;

import es.ulpgc.dacd.aemet.api.datalake.Datalake;
import es.ulpgc.dacd.aemet.api.datalake.FileDatalake;
import es.ulpgc.dacd.aemet.api.model.Weather;
import es.ulpgc.dacd.aemet.api.sensor.AemetApiReader;
import es.ulpgc.dacd.aemet.api.sensor.Sensor;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * The type Controller.
 */
public class Controller {
    private final Sensor aemetApiReader;
    private final Datalake fileDatalake;

    /**
     * Instantiates a new Controller.
     */
    public Controller() {
        aemetApiReader = new AemetApiReader();
        fileDatalake = new FileDatalake();
    }

    /**
     * Run.
     *
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public void run() throws IOException, ParseException {
        List<Weather> data = aemetApiReader.getData();
        fileDatalake.createFile(data);
    }
}
