package com.example.pogooda_backend.external_wather_api;


import lombok.Data;

import java.util.List;

@Data
public class WeatherSensorsDto {
    private String version;
    private String user;
    private String dateGenerated;

    private String status;

    private List<DataPerParameter> data;
}
