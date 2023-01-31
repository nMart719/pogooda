package com.example.pogooda_backend.service;

import com.example.pogooda_backend.model.dto.response.HintDto;
import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HintsService {
    private final WeatherDataHandlerService weatherDataHandlerService;

    public List<HintDto> getHints()
    {
        PomiarCzujnikaZew actualWeather;
        try {
            actualWeather = weatherDataHandlerService.getActualWeather();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<HintDto> hints = new ArrayList<>();

        if (actualWeather.getTemperaturaZewnetrzna() < 0.0f)
            hints.add(new HintDto("Mróz", "Temperatura spadła poniżej zera. Pamiętaj o ochronie roślin doniczkowych"));
        else if (actualWeather.getTemperaturaZewnetrzna() < 2.0f)
            hints.add(new HintDto("Możliwe przymrozki", "Temperatura jest bliska zeru. Pamiętaj o ochronie roślin doniczkowych"));

        if (actualWeather.getUvi() < 2.0f)
            hints.add(new HintDto("Niski indeks UV", "Pamiętaj o włączeniu naświetlania dodatkowego w szklarniach!"));

        if (actualWeather.getWilgotnoscZewnetrzna() < 20.0f)
            hints.add(new HintDto("Niska wilgotność powietrza", "Wilgotność względna spadła poniżej 20%. Zalecane podlewanie upraw."));

        return hints;

    }

}
