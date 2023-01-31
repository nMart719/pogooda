package com.example.pogooda_backend.controller;

import com.example.pogooda_backend.model.dto.response.HintDto;
import com.example.pogooda_backend.service.HintsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"${client.react_address}"})
@RequiredArgsConstructor
public class HintsController {

    private final HintsService hintsService;

    @GetMapping("/hints/")
    public List<HintDto> readActualHints() //pracownik rolny
    {
        return hintsService.getHints();
    }

    public void updateHintsSettings() //pracownik rolny
    {

    }
}
