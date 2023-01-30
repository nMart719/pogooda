package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class PomiarCzujnikaZew extends PomiarCzujnika {

    private Float cisnienieAtmosferyczne;

    private Float opadyDeszczu;

    private Float jakoscPowietrza;

    private Float predkoscWiatru;

    private Float promieniowanieSloneczne;

    private Float temperaturaOdczuwalna;

    private Float temperaturaZewnetrzna;

    private Float wilgotnoscZewnetrzna;

    private Float fars;

    private Float uvi;

    public PomiarCzujnikaZew(StacjaPogodowa stacjaPogodowa, StanCzujnika stanCzujnika, Float cisnienieAtmosferyczne, Float opadyDeszczu, Float jakoscPowietrza, Float predkoscWiatru, Float promieniowanieSloneczne, Float temperaturaOdczuwalna, Float temperaturaZewnetrzna, Float wilgotnoscZewnetrzna, Float fars, Float uvi) {
        super(stacjaPogodowa, stanCzujnika);
        this.cisnienieAtmosferyczne = cisnienieAtmosferyczne;
        this.opadyDeszczu = opadyDeszczu;
        this.jakoscPowietrza = jakoscPowietrza;
        this.predkoscWiatru = predkoscWiatru;
        this.promieniowanieSloneczne = promieniowanieSloneczne;
        this.temperaturaOdczuwalna = temperaturaOdczuwalna;
        this.temperaturaZewnetrzna = temperaturaZewnetrzna;
        this.wilgotnoscZewnetrzna = wilgotnoscZewnetrzna;
        this.fars = fars;
        this.uvi = uvi;
    }
}
