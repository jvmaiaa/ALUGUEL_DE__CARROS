package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import lombok.Data;

@Data
public class ViaCepResponse {

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

//        "cep": "01001-000",
//            "logradouro": "Praça da Sé",
//            "complemento": "lado ímpar",
//            "bairro": "Sé",
//            "localidade": "São Paulo",
//            "uf": "SP",
//            "ibge": "3550308",
//            "gia": "1004",
//            "ddd": "11",
//            "siafi": "7107"
//
}
