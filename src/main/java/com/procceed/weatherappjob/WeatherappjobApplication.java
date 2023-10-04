package com.procceed.weatherappjob;

import com.procceed.weatherappjob.dao.Weather;
import com.procceed.weatherappjob.dao.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class WeatherappjobApplication {

	private static final Logger log = LoggerFactory.getLogger(WeatherappjobApplication.class);

	@Value("${apiKey}")
	private String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(WeatherappjobApplication.class, args).close();
	}


	@Bean
	public CommandLineRunner run(){
		return runner -> {
			getWeatherData();
		};
	}

	@Scheduled(cron = "@daily")
	public void getWeatherData(){
		List<WeatherData> weatherDataList = new ArrayList<>();
		List<String> locations = Arrays.asList("london", "hamburg", "frankfurt", "paris");
		for (int i=0; i < locations.size(); i++){
			WeatherData weatherData = new WeatherData();
			String location = locations.get(i);
			weatherData.setLocation(location);
			System.out.println(apiKey);
			String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + location+ "&units=metric&appid=" + apiKey;
			RestTemplate restTemplate1 = new RestTemplate();
			Weather result = restTemplate1.getForObject(uri, Weather.class);
			weatherData.setWeather(result);
			weatherDataList.add(weatherData);
		}
		log.info(weatherDataList.toString());
	}

}
