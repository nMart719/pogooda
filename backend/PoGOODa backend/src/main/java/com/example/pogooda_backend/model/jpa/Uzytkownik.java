package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Uzytkownik {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date createdAt;

    private String login;

//  usuwam hasło, dla uproszczenia autoryzacji (po prostu tokeny i tyle, bez logowania)
//    String encryptedPassword;

    @Enumerated(EnumType.STRING)
    RolaUzytkownika rolaUzytkownika;
}
