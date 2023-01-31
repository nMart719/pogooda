package com.example.pogooda_backend.model.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class PrognozaPogodyDto {
    @NotNull
    private String miejsce;

    @NotNull
    List<DanePogodoweDto> prognozy;
}
