package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Gwarancja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String hashGodnosci;

    String instrukcjaUzytkownika;

    public Gwarancja(String hashGodnosci, String instrukcjaUzytkownika) {
        this.hashGodnosci = hashGodnosci;
        this.instrukcjaUzytkownika = instrukcjaUzytkownika;
    }
}
