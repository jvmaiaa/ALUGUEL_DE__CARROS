package com.jvmaiaa.aluguelcarros.api.domain.dto.response;
import lombok.Data;

@Data
public class EnderecoResponseDTO {

    private Long id;

    private String cep;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

}
