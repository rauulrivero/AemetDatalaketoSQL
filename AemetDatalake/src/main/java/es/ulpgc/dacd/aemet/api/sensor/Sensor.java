package es.ulpgc.dacd.aemet.api.sensor;

import es.ulpgc.dacd.aemet.api.model.Weather;

import java.util.List;

public interface Sensor {
    List<Weather> getData();
}
