package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Wymiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    Integer szerokosc;

    Integer wysokosc;

    Integer dlugosc;

    public Wymiary(Integer szerokosc, Integer wysokosc, Integer dlugosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.dlugosc = dlugosc;
    }
}
