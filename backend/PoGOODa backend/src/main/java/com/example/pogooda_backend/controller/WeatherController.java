package com.example.pogooda_backend.controller;


import com.example.pogooda_backend.model.dto.response.AktualnaPogodaDto;
import com.example.pogooda_backend.model.dto.response.DanePogodoweDto;
import com.example.pogooda_backend.model.dto.response.OcenaPogody;
import com.example.pogooda_backend.model.dto.response.PrognozaPogodyDto;
import com.example.pogooda_backend.service.ActualWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<DanePogodoweDto> prognozy = new ArrayList<>();

        prognozy.add(new DanePogodoweDto(
                LocalDateTime.now().plusDays(1),
                1013f,
                0.90f,
                0.8f,
                20f,
                5f,
                -2f,
                0f,
                0.4f,
                0f,
                0f,
                OcenaPogody.FULL_CLOUDY
        ));

        prognozy.add(new DanePogodoweDto(
                LocalDateTime.now().plusDays(2),
                1013f,
                0.90f,
                0.8f,
                20f,
                5f,
                -2f,
                0f,
                0.4f,
                0f,
                0f,
                OcenaPogody.FULL_CLOUDY
        ));

        return new PrognozaPogodyDto(
                "Wrocław",
                prognozy
        );
    }
}
