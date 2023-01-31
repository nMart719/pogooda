package com.example.pogooda_backend.model.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class DanePogodoweDto {
    @NotNull
    private LocalDateTime czasOdczytu;

    private Float cisnienieAtmosferyczne;

    @NotNull
    private Float opadyDeszczu;

    private Float jakoscPowietrza;

    @NotNull
    private Float predkoscWiatru;

    private Float promieniowanieSloneczne;

    @NotNull
    private Float temperaturaOdczuwalna;

    private Float temperaturaZewnetrzna;

    private Float wilgotnoscZewnetrzna;

    private Float fars;

    private Float uvi;

    @NotNull
    private OcenaPogody ocenaPogody;


}
