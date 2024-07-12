package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocadoraRequestDTO {

    private String nome;

    @Pattern(regexp = "^9[0-9]{8}$")
    private String telefone;

    @Email
    private String email;

    private LocalTime horarioAbertura;

    private LocalTime horarioFechamento;
}
