package es.ulpgc.dacd.aemet.api.sensor;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * The interface Sensor.
 */
public interface Sensor {
    /**
     * Gets data.
     *
     * @return the data
     * @throws ParseException the parse exception
     * @throws IOException    the io exception
     */
    List<Weather> getData() throws ParseException, IOException;
}
