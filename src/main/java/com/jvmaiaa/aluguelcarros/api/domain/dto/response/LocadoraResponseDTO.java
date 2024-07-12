package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

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

    private LocalTime horarioAbertura;

    private LocalTime horarioFechamento;
}
