package es.ulpgc.dacd.aemet.api.model;

import java.time.LocalDate;
import java.util.Date;

public class Weather {
    public final Date date;
    public final String station;
    public final String place;
    public final double temperature;


    public Weather(Date date, String station, String place, double temperature) {
        this.date = date;
        this.station = station;
        this.place = place;
        this.temperature = temperature;
    }


    public Date getDate() { return date;}

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
