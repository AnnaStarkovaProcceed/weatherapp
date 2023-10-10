package com.procceed.weatherappjob.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherAdapterImpl implements WeatherAdapter {

    private final WeatherMapper weatherAdapter;

    public OpenWeatherAdapterImpl(WeatherMapper weatherAdapter) {
        this.weatherAdapter = weatherAdapter;
    }

    @Value("${apiKey}")
    private String apiKey;

    @Value("${openWeatherUri}")
    private String openWeatherUri;
    @Override
    public String fetchWeather(String location) {

        String uri = String.format(openWeatherUri, location, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return weatherAdapter.convert(result);
    }
}
