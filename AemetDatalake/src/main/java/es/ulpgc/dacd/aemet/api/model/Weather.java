package es.ulpgc.dacd.aemet.api.model;

import java.util.Date;

public class Weather {
    public Date ts;
    public String station;
    public String place;
    public double temperature;


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
