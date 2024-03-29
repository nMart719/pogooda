package com.example.pogooda_backend.external_weather_api;

import lombok.Data;

import java.util.List;

@Data
public class DataPerCoordinates {
    private Float lat;
    private Float lon;
    private List<SingleData> dates;
}
