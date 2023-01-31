package com.example.pogooda_backend.external_wather_api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SingleData {
    private String date;
    private String value;
}
