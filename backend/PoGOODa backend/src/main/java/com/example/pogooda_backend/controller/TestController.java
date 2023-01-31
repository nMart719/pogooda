package com.example.pogooda_backend.controller;

import com.example.pogooda_backend.external_wather_api.MateomaticsApi;
import com.example.pogooda_backend.external_wather_api.WeatherSensorsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController @RequiredArgsConstructor
public class TestController {
    private final MateomaticsApi mateomaticsApi;

    @GetMapping("/test")
    public WeatherSensorsDto test() throws IOException {
        return mateomaticsApi.fullRead();
    }
}
