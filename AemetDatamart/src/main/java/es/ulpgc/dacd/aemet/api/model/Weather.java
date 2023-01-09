package es.ulpgc.dacd.aemet.api.model;

/**
 * The type Weather.
 */
public class Weather {
    /**
     * The Date.
     */
    public final String date;
    /**
     * The Time.
     */
    public final  String time;
    /**
     * The Station.
     */
    public final String station;
    /**
     * The Place.
     */
    public final String place;
    /**
     * The Temperature.
     */
    public final double temperature;


    /**
     * Instantiates a new Weather.
     *
     * @param date        the date
     * @param time        the time
     * @param station     the station
     * @param place       the place
     * @param temperature the temperature
     */
    public Weather(String date, String time, String station, String place, double temperature) {
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
    public String getDate() { return date;}

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
