package es.ulpgc.dacd.aemet.api.datalake;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.IOException;
import java.util.List;

public interface Datalake {
    List<Weather> getWeathers(String pathname) throws IOException;
}
