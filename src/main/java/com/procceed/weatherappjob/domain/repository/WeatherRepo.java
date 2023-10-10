package com.procceed.weatherappjob.domain.repository;

import com.procceed.weatherappjob.domain.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather, Integer> {
}
