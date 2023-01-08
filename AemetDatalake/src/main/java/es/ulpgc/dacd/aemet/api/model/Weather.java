package es.ulpgc.dacd.aemet.api.model;

import java.util.Date;

public class Weather {
    public final Date ts;
    public final String station;
    public final String place;
    public final double temperature;


    public Weather(Date ts, String station, String place, double temperature) {
        this.ts = ts;
        this.station = station;
        this.place = place;
        this.temperature = temperature;

    }

    public Date getDate() { return ts;}

    public String getStation() {
        return station;
    }

    public String getPlace() {
        return place;
    }

    public double getTemperature() {
        return temperature;
    }

}
