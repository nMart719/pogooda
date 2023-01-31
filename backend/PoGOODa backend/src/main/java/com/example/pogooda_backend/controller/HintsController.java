package com.example.pogooda_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${client.react_address}"})
public class HintsController {

    public void readActualHints() //pracownik rolny
    {

    }

    public void updateHintsSettings() //pracownik rolny
    {

    }
}
