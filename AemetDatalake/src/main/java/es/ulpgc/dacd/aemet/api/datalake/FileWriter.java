package es.ulpgc.dacd.aemet.api.datalake;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.IOException;
import java.util.List;

/**
 * The interface Datalake.
 */
public interface FileWriter {
    /**
     * Create file.
     *
     * @param weatherList the weather list
     * @throws IOException the io exception
     */
    void createFile(List<Weather> weatherList) throws IOException;
}
