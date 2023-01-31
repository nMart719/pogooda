package com.example.pogooda_backend.service;

import com.example.pogooda_backend.external_wather_api.MateomaticsApi;
import com.example.pogooda_backend.external_wather_api.WeatherSensorsDto;
import com.example.pogooda_backend.model.jpa.PomiarCzujnika;
import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import com.example.pogooda_backend.repository.PomiarCzujnikaZewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DataFillerService {

    private final MateomaticsApi mateomaticsApi;
    private final PomiarCzujnikaZewRepository pomiarCzujnikaZewRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(fixedRate = 900000)
    public void readAndSaveLastMaxTwoDaysWeatherData() {
        try {
            Optional<PomiarCzujnikaZew> najnowszyOdczyt = pomiarCzujnikaZewRepository.findFirstByOrderByCzasOdczytuDesc();
            WeatherSensorsDto weatherSensorsDto;
            if (najnowszyOdczyt.isPresent())
                weatherSensorsDto = mateomaticsApi.fullRead(najnowszyOdczyt.get().getCzasOdczytu().toLocalDateTime());
            else
                weatherSensorsDto = mateomaticsApi.fullRead(null);

            Map<LocalDateTime, PomiarCzujnikaZew> reads = new HashMap<>();
            weatherSensorsDto.getData().get(0).getCoordinates().get(0).getDates().forEach(singleData -> {
                LocalDateTime time = LocalDateTime.parse(singleData.getDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                PomiarCzujnikaZew pomiarCzujnikaZew = new PomiarCzujnikaZew();
                pomiarCzujnikaZew.setCzasOdczytu(Timestamp.valueOf(time));
                reads.put(time, pomiarCzujnikaZew);
            });

            weatherSensorsDto.getData().forEach(dataPerParameter -> {
                String parameter = dataPerParameter.getParameter();
                dataPerParameter.getCoordinates().get(0).getDates().forEach(singleData -> {
                    LocalDateTime time = LocalDateTime.parse(singleData.getDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                    PomiarCzujnikaZew pomiarCzujnikaZew = reads.get(time);
                    String value = singleData.getValue();
                    switch (parameter) {
                        case "t_2m:C":
                            pomiarCzujnikaZew.setTemperaturaZewnetrzna(Float.valueOf(value));
                            break;
                        case "relative_humidity_2m:p":
                            pomiarCzujnikaZew.setWilgotnoscZewnetrzna(Float.valueOf(value));
                            break;
                        case "pressure_100m:hPa":
                            pomiarCzujnikaZew.setCisnienieAtmosferyczne(Float.valueOf(value));
                            break;
                        case "prob_precip_1h:p":
                            pomiarCzujnikaZew.setOpadyDeszczu(Float.valueOf(value));
                            break;
                        case "pm10:ugm3":
                            pomiarCzujnikaZew.setJakoscPowietrza(Float.valueOf(value));
                            break;
                        case "wind_speed_FL10:kmh":
                            pomiarCzujnikaZew.setPredkoscWiatru(Float.valueOf(value));
                            break;
                        case "uv:idx":
                            pomiarCzujnikaZew.setUvi(Float.valueOf(value));
                            pomiarCzujnikaZew.setPromieniowanieSloneczne(Float.valueOf(value));
                            break;
                        case "dew_point_2m:C":
                            pomiarCzujnikaZew.setFars(Float.valueOf(value));
                            break;
                        case "windchill:C":
                            pomiarCzujnikaZew.setTemperaturaOdczuwalna(Float.valueOf(value));
                            break;
                        default:
                            break;
                    }
                    reads.put(time, pomiarCzujnikaZew);
                });

            });
            safelyAppendReads(reads.values());

        } catch (IOException e) {
            System.err.println("Connection with external weather api failed!");
        } catch (Exception e) {
            System.err.println("Mapping data from external weather api failed!");
        }

    }

    private void safelyAppendReads(Collection<PomiarCzujnikaZew> pomiarCzujnikaZews) {

        List<PomiarCzujnikaZew> pomiaryWKolejnosci = pomiarCzujnikaZews.stream().sorted(Comparator.comparing(PomiarCzujnika::getCzasOdczytu)).toList();
        List<Boolean> czyWystepujeWKolejnosci = pomiaryWKolejnosci.stream().map(pomiarCzujnikaZew ->
            pomiarCzujnikaZewRepository.findByCzasOdczytu(pomiarCzujnikaZew.getCzasOdczytu()).isPresent()
        ).toList();

        List<PomiarCzujnikaZew> nowePomiary = new ArrayList<>();
        for (int i = 0; i < pomiaryWKolejnosci.size() && i < czyWystepujeWKolejnosci.size(); i++)
        {
            if (!czyWystepujeWKolejnosci.get(i))
                nowePomiary.add(pomiaryWKolejnosci.get(i));

        }


        pomiarCzujnikaZewRepository.saveAllAndFlush(nowePomiary);
    }
}
