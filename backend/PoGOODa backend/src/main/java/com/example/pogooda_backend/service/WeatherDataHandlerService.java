package com.example.pogooda_backend.service;

import com.example.pogooda_backend.external_weather_api.MateomaticsApi;
import com.example.pogooda_backend.model.jpa.PomiarCzujnika;
import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import com.example.pogooda_backend.repository.PomiarCzujnikaZewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service @RequiredArgsConstructor
public class WeatherDataHandlerService {

    private final MateomaticsApi mateomaticsApi;
    private final PomiarCzujnikaZewRepository pomiarCzujnikaZewRepository;

    public List<PomiarCzujnikaZew> getWeatherHistory() {
        return pomiarCzujnikaZewRepository.findAll().stream().sorted(Comparator.comparing(PomiarCzujnika::getCzasOdczytu)).toList();
    }

    public PomiarCzujnikaZew getActualWeather() throws IOException {
        Map<LocalDateTime, PomiarCzujnikaZew> pomiary = DataFillerService.convertWeatherSensorsDto(mateomaticsApi.readLatest());
        assert pomiary.size()==0 || pomiary.size()==1;
        return pomiary.values().stream().toList().get(0);
    }
}
