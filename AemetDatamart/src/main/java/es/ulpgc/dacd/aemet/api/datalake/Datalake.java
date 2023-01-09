package es.ulpgc.dacd.aemet.api.datalake;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.IOException;
import java.util.List;

/**
 * The interface Datalake.
 */
public interface Datalake {
    /**
     * Gets weathers.
     *
     * @param pathname the pathname
     * @return the weathers
     * @throws IOException the io exception
     */
    List<Weather> getWeathers(String pathname) throws IOException;
}
