package com.procceed.weatherappjob.infrastructure.adapter;

import com.procceed.weatherappjob.domain.model.Weather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class WeatherMapper {

    public String convert(String data){
        return data;
    }

//    public Weather convert(String data){
//        JSONObject obj = new JSONObject(data);
//        JSONArray arr = obj.getJSONArray("weather");
//        JSONObject weather = arr.getJSONObject(0);
//        JSONObject main = obj.getJSONObject("main");
//        JSONObject wind = obj.getJSONObject("wind");
//        return new Weather(
//                obj.getString("name"),
//                weather.getString("description"),
//                main.getDouble("temp"),
//                main.getDouble("feels_like"),
//                main.getDouble("temp_min"),
//                main.getDouble("temp_max"),
//                wind.getDouble("speed")
//                );
//    }
}
