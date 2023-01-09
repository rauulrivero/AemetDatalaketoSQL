package es.ulpgc.dacd.aemet.api.model;

import java.time.LocalDate;

/**
 * The type Weather.
 */
public class Weather {
    private final LocalDate date;
    private final String time;
    private final String station;
    private final String place;
    private final double temperature;


    /**
     * Instantiates a new Weather.
     *
     * @param date        the date
     * @param time        the time
     * @param station     the station
     * @param place       the place
     * @param temperature the temperature
     */
    public Weather(LocalDate date, String time, String station, String place, double temperature) {
        this.date = date;
        this.time = time;
        this.station = station;
        this.place = place;
        this.temperature = temperature;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets station.
     *
     * @return the station
     */
    public String getStation() {
        return station;
    }

    /**
     * Gets place.
     *
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Gets temperature.
     *
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

}
