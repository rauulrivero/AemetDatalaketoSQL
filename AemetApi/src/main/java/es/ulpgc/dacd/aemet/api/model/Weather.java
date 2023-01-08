package es.ulpgc.dacd.aemet.api.model;

import java.time.LocalDate;

public class Weather {
    private final LocalDate date;
    private final String time;
    private final String station;
    private final String place;
    private final double temperature;


    public Weather(LocalDate date, String time, String station, String place, double temperature) {
        this.date = date;
        this.time = time;
        this.station = station;
        this.place = place;
        this.temperature = temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

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
