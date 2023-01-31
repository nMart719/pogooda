package com.example.pogooda_backend.service;

import com.example.pogooda_backend.model.dto.response.PrognozaPogodyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ForecastService {
    private final WeatherDataHandlerService weatherDataHandlerService;

    public PrognozaPogodyDto getForecast()
    {
        return null;
    }
}
