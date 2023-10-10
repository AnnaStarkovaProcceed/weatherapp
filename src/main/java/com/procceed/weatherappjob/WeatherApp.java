package com.procceed.weatherappjob;

import com.procceed.weatherappjob.domain.model.Weather;
import com.procceed.weatherappjob.domain.repository.WeatherRepo;
import com.procceed.weatherappjob.domain.service.WeatherAppServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeatherApp {

	private final WeatherAppServiceImpl weatherAppService;

	private final WeatherRepo weatherRepo;

	public WeatherApp(WeatherAppServiceImpl weatherAppService, WeatherRepo weatherRepo) {

		this.weatherAppService = weatherAppService;

		this.weatherRepo = weatherRepo;

	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherApp.class, args);
	}


	@Bean
	public CommandLineRunner run(){
		return runner -> {
			String location = "hamburg";
			String weatherReport = weatherAppService.getWeather(location);
			System.out.println(weatherReport);
			weatherRepo.save(new Weather(weatherReport));
		};
	}

}
