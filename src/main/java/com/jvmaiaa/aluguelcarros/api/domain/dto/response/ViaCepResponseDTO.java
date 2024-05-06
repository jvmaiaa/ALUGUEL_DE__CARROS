package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import lombok.Data;

@Data
public class ViaCepResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String igbe;
    private String gia;
    private String ddd;
    private String siafi;
}
