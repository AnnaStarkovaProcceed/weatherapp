package com.procceed.weatherappjob.dao;

public class WeatherData {
    private String location;

    private Weather weather;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "location='" + location + '\'' +
                ", weather=" + weather +
                '}';
    }
}
