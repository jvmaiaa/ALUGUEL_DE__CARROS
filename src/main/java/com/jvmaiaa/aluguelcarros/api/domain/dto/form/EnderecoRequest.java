package com.jvmaiaa.aluguelcarros.api.domain.dto.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoRequest {

    @NotEmpty
    private String cep;

    @NotEmpty
    private String rua;

    @NotEmpty
    private String numero;

    @NotEmpty
    private String bairro;

    private String cidade;

    private String estado;
}
