package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EnderecoRequestDTO {

    @NotEmpty(message = "O campo CEP não pode ficar em branco.")
    private String cep;

    @NotEmpty(message = "O campo RUA não pode ficar em branco.")
    private String rua;

    @Positive
    @NotEmpty(message = "O campo NÚMERO não pode ficar em branco.")
    private String numero;

    @NotEmpty(message = "O campo BAIRRO não pode ficar em branco.")
    private String bairro;

    private String cidade;

    private String estado;
}
