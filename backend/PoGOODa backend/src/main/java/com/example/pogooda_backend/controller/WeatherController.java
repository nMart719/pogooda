package com.example.pogooda_backend.controller;


import com.example.pogooda_backend.model.dto.response.AktualnaPogodaDto;
import com.example.pogooda_backend.model.dto.response.DanePogodoweDto;
import com.example.pogooda_backend.model.dto.response.OcenaPogody;
import com.example.pogooda_backend.model.dto.response.PrognozaPogodyDto;
import com.example.pogooda_backend.service.ActualWeatherService;
import com.example.pogooda_backend.service.ForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"${client.react_address}"})
@RequiredArgsConstructor
public class WeatherController {
    private final ActualWeatherService actualWeatherService;
    private final ForecastService forecastService;


    @GetMapping("/weather/history")
    public void getHistoryWeatherInfo() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/weather/actual")
    public AktualnaPogodaDto getActualWeatherInfo() {
        return actualWeatherService.aktualneWarunki();
    }

    @GetMapping("/weather/forecast")
    public PrognozaPogodyDto getTenDaysForecast() {
        return forecastService.getForecast();
    }
}
