package com.example.pogooda_backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "API back-endu aplikacji PoGOODa",
        description = "Back-end aplikacji PoGOODa do użycia na projekcie z przedmiotu \"Projektowanie oprogramowania\". API zgodne z OAS v3."))
public class PoGooDaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoGooDaBackendApplication.class, args);
    }

}
