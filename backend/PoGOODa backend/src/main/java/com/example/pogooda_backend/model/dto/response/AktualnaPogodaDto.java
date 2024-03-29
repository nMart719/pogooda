package com.example.pogooda_backend.model.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @AllArgsConstructor
public class AktualnaPogodaDto {

    @NotNull
    private String miejsce;

    @NotNull
    private DanePogodoweDto najnowszyPomiar;

}
