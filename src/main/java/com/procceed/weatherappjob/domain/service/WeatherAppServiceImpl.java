package com.procceed.weatherappjob.domain.service;
import com.procceed.weatherappjob.domain.model.Weather;
import com.procceed.weatherappjob.infrastructure.adapter.WeatherAdapter;
import org.springframework.stereotype.Service;


@Service
public class WeatherAppServiceImpl implements WeatherAppService {

    private final WeatherAdapter weatherProviderService;

    public WeatherAppServiceImpl(WeatherAdapter weatherProviderService) {
        this.weatherProviderService = weatherProviderService;
    }

    public String getWeather(String location){

        return weatherProviderService.fetchWeather(location);
    }
}
