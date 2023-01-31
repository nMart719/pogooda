package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data @NoArgsConstructor
public abstract class PomiarCzujnika {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp czasOdczytu;

    @ManyToOne
    private StacjaPogodowa stacjaPogodowa;

    @Enumerated(EnumType.STRING)
    private StanCzujnika stanCzujnika;

    public PomiarCzujnika(StacjaPogodowa stacjaPogodowa, StanCzujnika stanCzujnika) {
        this.stacjaPogodowa = stacjaPogodowa;
        this.stanCzujnika = stanCzujnika;
    }
}
