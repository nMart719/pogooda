package com.example.pogooda_backend.service;

import com.example.pogooda_backend.model.dto.response.DanePogodoweDto;
import com.example.pogooda_backend.model.dto.response.OcenaPogody;
import com.example.pogooda_backend.model.dto.response.PrognozaPogodyDto;
import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class ForecastService {
    @Value("${weather_station.place_name}")
    private String placeName;
    private final WeatherDataHandlerService weatherDataHandlerService;

    public PrognozaPogodyDto getForecast()  {
        List<PomiarCzujnikaZew> weatherHistory = weatherDataHandlerService.getWeatherHistory();
        PomiarCzujnikaZew actualWeather = null;
        try {
            actualWeather = weatherDataHandlerService.getActualWeather();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<PomiarCzujnikaZew> simpleDataFromLast3DaysAndToday = new ArrayList<>();
        simpleDataFromLast3DaysAndToday.add(actualWeather);
        simpleDataFromLast3DaysAndToday.addAll(getSimpleDataFromLast3Days(weatherHistory));
        simpleDataFromLast3DaysAndToday.sort(Comparator.comparing(PomiarCzujnikaZew::getCzasOdczytu));


        float pressureTendency = tendency(simpleDataFromLast3DaysAndToday.stream().map(PomiarCzujnikaZew::getCisnienieAtmosferyczne).toList());
        float temperatureTendency = tendency(simpleDataFromLast3DaysAndToday.stream().map(PomiarCzujnikaZew::getTemperaturaZewnetrzna).toList());
        float windTendency = tendency(simpleDataFromLast3DaysAndToday.stream().map(PomiarCzujnikaZew::getPredkoscWiatru).toList());

        List<DanePogodoweDto> danePogodoweDtos = generateForecast(DanePogodoweDto.from(actualWeather), pressureTendency, temperatureTendency, windTendency);
        return new PrognozaPogodyDto(placeName, danePogodoweDtos);
    }

    private List<PomiarCzujnikaZew> getSimpleDataFromLast3Days(List<PomiarCzujnikaZew> weatherHistory)
    {
        LocalDateTime today = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(12, 00));
        LocalDateTime todayMinus1 = today.minusDays(1);
        LocalDateTime todayMinus2 = today.minusDays(2);
        LocalDateTime todayMinus3 = today.minusDays(3);

        Optional<PomiarCzujnikaZew> pomiarTodayMinus1 = findClose(weatherHistory, todayMinus1);
        Optional<PomiarCzujnikaZew> pomiarTodayMinus2 = findClose(weatherHistory, todayMinus2);
        Optional<PomiarCzujnikaZew> pomiarTodayMinus3 = findClose(weatherHistory, todayMinus3);

        List<PomiarCzujnikaZew> list = new ArrayList<>();

        pomiarTodayMinus1.ifPresent(list::add);
        pomiarTodayMinus2.ifPresent(list::add);
        pomiarTodayMinus3.ifPresent(list::add);
        return list;
    }

    private Optional<PomiarCzujnikaZew> findClose(List<PomiarCzujnikaZew> weatherHistory, LocalDateTime time)
    {
        return weatherHistory.stream().filter(
                pomiarCzujnikaZew -> ChronoUnit.MINUTES.between(pomiarCzujnikaZew.getCzasOdczytu().toLocalDateTime(), time) < 30
                        && pomiarCzujnikaZew.getCzasOdczytu().toLocalDateTime().toLocalDate().equals(time.toLocalDate())
                ).findFirst();
    }


    private float tendency(List<Float> lastPomiars)
    {
        float overallTendency = 0.0f;
        float weight = 1.0f;
        for (int i = lastPomiars.size()-1; i > 0; i--, weight/=2.0)
        {
            overallTendency += (lastPomiars.get(i) - lastPomiars.get(i - 1)) * weight;
        }
        return overallTendency;
    }

    private List<DanePogodoweDto> generateForecast(DanePogodoweDto actual, float pressureTendency, float temperatureTendency, float windTendency)
    {
        DanePogodoweDto todayPlus1 = DanePogodoweDto.of(actual);
        DanePogodoweDto todayPlus2 = DanePogodoweDto.of(actual);
        DanePogodoweDto todayPlus3 = DanePogodoweDto.of(actual);

        todayPlus1.setCzasOdczytu(actual.getCzasOdczytu().plusDays(1));
        todayPlus2.setCzasOdczytu(actual.getCzasOdczytu().plusDays(2));
        todayPlus3.setCzasOdczytu(actual.getCzasOdczytu().plusDays(3));

        todayPlus1.setCisnienieAtmosferyczne(actual.getCisnienieAtmosferyczne()+pressureTendency);
        todayPlus2.setCisnienieAtmosferyczne(actual.getCisnienieAtmosferyczne()+(pressureTendency*0.75f));
        todayPlus3.setCisnienieAtmosferyczne(actual.getCisnienieAtmosferyczne()+(pressureTendency*0.5f));

        todayPlus1.setTemperaturaZewnetrzna(actual.getTemperaturaZewnetrzna()+temperatureTendency);
        todayPlus2.setTemperaturaZewnetrzna(actual.getTemperaturaZewnetrzna()+temperatureTendency*0.75f);
        todayPlus3.setTemperaturaZewnetrzna(actual.getTemperaturaZewnetrzna()+temperatureTendency*0.5f);

        todayPlus1.setPredkoscWiatru(actual.getPredkoscWiatru()+windTendency);
        todayPlus2.setPredkoscWiatru(actual.getPredkoscWiatru()+windTendency*0.75f);
        todayPlus3.setPredkoscWiatru(actual.getPredkoscWiatru()+windTendency*0.5f);

        todayPlus1.setOcenaPogody(OcenaPogody.CLOUDY);
        todayPlus2.setOcenaPogody(OcenaPogody.RAINY);
        todayPlus3.setOcenaPogody(OcenaPogody.SUNNY);

        return List.of(todayPlus1, todayPlus2, todayPlus3);
    }

}
