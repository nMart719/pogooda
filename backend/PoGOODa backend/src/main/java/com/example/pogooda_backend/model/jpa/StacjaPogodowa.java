package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class StacjaPogodowa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Wymiary wymiary;

    private Float wagaStacji;

    @OneToOne
    private Gwarancja gwarancja;

    @Enumerated(EnumType.STRING)
    private StanPracyStacjiPogodowej stanPracy;

    @ManyToOne
    private Uzytkownik wlasciciel;

    @OneToMany(mappedBy = "stacjaPogodowa")
    private Set<PomiarCzujnika> zapisanePomiary = new HashSet<>();
}
