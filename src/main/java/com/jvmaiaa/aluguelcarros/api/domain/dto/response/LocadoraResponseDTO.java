package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocadoraResponseDTO {

    private Long id;

    private String nome;

    private String telefone;

    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt-BR", timezone = "Brazil/East")
    private LocalTime horarioAbertura;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt-BR", timezone = "Brazil/East")
    private LocalTime horarioFechamento;
}
