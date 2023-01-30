package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class StacjaPogodowa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    Wymiary wymiary;

    Double wagaStacji;

    @OneToOne
    Gwarancja gwarancja;

    @Enumerated(EnumType.STRING)
    StanPracyStacjiPogodowej stanPracy;

    @ManyToOne
    Uzytkownik wlasciciel;

    @OneToMany(mappedBy = "stacjaPogodowa")
    private Set<PomiarCzujnika> zapisanePomiary = new HashSet<>();
}
