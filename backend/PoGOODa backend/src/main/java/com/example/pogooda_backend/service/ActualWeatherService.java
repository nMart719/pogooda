package com.example.pogooda_backend.service;

import com.example.pogooda_backend.model.dto.response.AktualnaPogodaDto;
import com.example.pogooda_backend.model.dto.response.DanePogodoweDto;
import com.example.pogooda_backend.model.dto.response.OcenaPogody;
import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service @RequiredArgsConstructor
public class ActualWeatherService {

    private final WeatherDataHandlerService weatherDataHandlerService;
    @Value("${weather_station.place_name}")
    private String placeName;

    public AktualnaPogodaDto aktualneWarunki()
    {
        try {
            PomiarCzujnikaZew pomiarCzujnikaZew = weatherDataHandlerService.getActualWeather();
            return new AktualnaPogodaDto(placeName, new DanePogodoweDto(
                    pomiarCzujnikaZew.getCzasOdczytu().toLocalDateTime(),
                    pomiarCzujnikaZew.getCisnienieAtmosferyczne(),
                    pomiarCzujnikaZew.getOpadyDeszczu(),
                    pomiarCzujnikaZew.getJakoscPowietrza(),
                    pomiarCzujnikaZew.getPredkoscWiatru(),
                    pomiarCzujnikaZew.getPromieniowanieSloneczne(),
                    pomiarCzujnikaZew.getTemperaturaOdczuwalna(),
                    pomiarCzujnikaZew.getTemperaturaZewnetrzna(),
                    pomiarCzujnikaZew.getWilgotnoscZewnetrzna(),
                    pomiarCzujnikaZew.getFars(),
                    pomiarCzujnikaZew.getUvi(),
                    ocenPogode(pomiarCzujnikaZew)
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private OcenaPogody ocenPogode(PomiarCzujnikaZew pomiarCzujnikaZew) {
        if (pomiarCzujnikaZew.getCisnienieAtmosferyczne() < 1000f && pomiarCzujnikaZew.getUvi() <= 1.0f && pomiarCzujnikaZew.getOpadyDeszczu() >= 1.0f && pomiarCzujnikaZew.getTemperaturaZewnetrzna()>5.0f)
            return OcenaPogody.STORMY;
        if (pomiarCzujnikaZew.getUvi() >= 3.0f)
            return OcenaPogody.SUNNY;
        if (pomiarCzujnikaZew.getUvi() == 0 && pomiarCzujnikaZew.getOpadyDeszczu() == 0)
            return OcenaPogody.FULL_CLOUDY;
        if (pomiarCzujnikaZew.getUvi() > 0 && pomiarCzujnikaZew.getOpadyDeszczu() == 0)
            return OcenaPogody.CLOUDY;
        return OcenaPogody.RAINY;
    }
}
