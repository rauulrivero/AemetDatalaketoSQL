package es.ulpgc.dacd.aemet.api.model;

public class Weather {
    public String date;
    public String time;
    public String station;
    public String place;
    public double temperature;


    public Weather(String date, String time, String station, String place, double temperature) {
        this.date = date;
        this.time = time;
        this.station = station;
        this.place = place;
        this.temperature = temperature;

    }

    public String getDate() { return date;}

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
