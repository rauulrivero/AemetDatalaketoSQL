package es.ulpgc.dacd.aemet.api.datalake;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface Datalake {
    void createFile(List<Weather> weatherList) throws IOException, ParseException;
}
