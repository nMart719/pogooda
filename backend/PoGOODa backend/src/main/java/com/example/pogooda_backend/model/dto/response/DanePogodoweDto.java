package com.example.pogooda_backend.model.dto.response;

import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class DanePogodoweDto {
    @NotNull
    private LocalDateTime czasOdczytu;

    private Float cisnienieAtmosferyczne;

    @NotNull
    private Float opadyDeszczu;

    private Float jakoscPowietrza;

    @NotNull
    private Float predkoscWiatru;

    private Float promieniowanieSloneczne;

    @NotNull
    private Float temperaturaOdczuwalna;

    private Float temperaturaZewnetrzna;

    private Float wilgotnoscZewnetrzna;

    private Float fars;

    private Float uvi;

    @NotNull
    private OcenaPogody ocenaPogody;

    public static DanePogodoweDto of(DanePogodoweDto other)
    {
        return new DanePogodoweDto(
                other.czasOdczytu,
                other.cisnienieAtmosferyczne,
                other.opadyDeszczu,
                other.jakoscPowietrza,
                other.predkoscWiatru,
                other.promieniowanieSloneczne,
                other.temperaturaOdczuwalna,
                other.temperaturaZewnetrzna,
                other.wilgotnoscZewnetrzna,
                other.fars,
                other.uvi,
                other.ocenaPogody);
    }

    public static DanePogodoweDto from(PomiarCzujnikaZew pomiarCzujnikaZew)
    {
        return new DanePogodoweDto(
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
                null);
    }

}
