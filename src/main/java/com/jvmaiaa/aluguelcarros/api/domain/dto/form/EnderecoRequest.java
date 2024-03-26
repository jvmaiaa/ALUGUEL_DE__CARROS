package com.jvmaiaa.aluguelcarros.api.domain.dto.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoRequest {

    @NotNull
    private String cep;

    private String rua;

    @NotNull
    private String numero;

    private String bairro;

    private String cidade;

    private String estado;
}
