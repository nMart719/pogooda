package com.example.pogooda_backend.external_weather_api;

import lombok.Data;

import java.util.List;

@Data
public class DataPerParameter {
    private String parameter;
    private List<DataPerCoordinates> coordinates;
}
