package com.example.pogooda_backend.model.jpa;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Uzytkownik {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Date createdAt;

    String login;

//  usuwam hasło, dla uproszczenia autoryzacji (po prostu tokeny i tyle, bez logowania)
//    String encryptedPassword;

    @Enumerated(EnumType.STRING)
    RolaUzytkownika rolaUzytkownika;
}
