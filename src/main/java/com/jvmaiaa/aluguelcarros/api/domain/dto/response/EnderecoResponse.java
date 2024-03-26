package com.jvmaiaa.aluguelcarros.api.domain.dto.response;
import lombok.Data;

@Data
public class EnderecoResponse {

    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

//    {
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
//    }
}
