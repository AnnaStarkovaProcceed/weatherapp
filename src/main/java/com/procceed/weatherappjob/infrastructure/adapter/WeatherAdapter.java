package com.procceed.weatherappjob.infrastructure.adapter;

import com.procceed.weatherappjob.domain.model.Weather;

public interface WeatherAdapter {

    String fetchWeather(String location);
}
