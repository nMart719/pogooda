package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class PomiarCzujnikaZew extends PomiarCzujnika {

    private Double cisnienieAtmosferyczne;

    private Double opadyDeszczu;

    private Double jakoscPowietrza;

    private Double predkoscWiatru;

    private Double promieniowanieSloneczne;

    private Double temperaturaOdczuwalna;

    private Double temperaturaZewnetrzna;

    private Double wilgotnoscZewnetrzna;

    private Double fars;

    private Double uvi;

    public PomiarCzujnikaZew(StacjaPogodowa stacjaPogodowa, StanCzujnika stanCzujnika, Double cisnienieAtmosferyczne, Double opadyDeszczu, Double jakoscPowietrza, Double predkoscWiatru, Double promieniowanieSloneczne, Double temperaturaOdczuwalna, Double temperaturaZewnetrzna, Double wilgotnoscZewnetrzna, Double fars, Double uvi) {
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
