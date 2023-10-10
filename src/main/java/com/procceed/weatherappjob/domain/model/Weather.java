package com.procceed.weatherappjob.domain.model;

import jakarta.persistence.*;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="weather", length = 500)
    private String data;

    public Weather() {
    }

    public Weather(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
