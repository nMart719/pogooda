package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class PomiarCzujnikaWew extends PomiarCzujnika{
    private Integer maksymalnyZasieg;

    private Double temperaturaWewnetrzna;

    private Double wilgotnoscWewnetrzna;

    public PomiarCzujnikaWew(StacjaPogodowa stacjaPogodowa, StanCzujnika stanCzujnika, Integer maksymalnyZasieg, Double temperaturaWewnetrzna, Double wilgotnoscWewnetrzna) {
        super(stacjaPogodowa, stanCzujnika);
        this.maksymalnyZasieg = maksymalnyZasieg;
        this.temperaturaWewnetrzna = temperaturaWewnetrzna;
        this.wilgotnoscWewnetrzna = wilgotnoscWewnetrzna;
    }
}
