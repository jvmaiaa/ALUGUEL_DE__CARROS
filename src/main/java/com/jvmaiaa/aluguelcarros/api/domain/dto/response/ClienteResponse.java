package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteResponse {

    private Long id;

    private String cpf;

    private String nome;

    private String cnh;

    private LocalDate dataDeNascimento;

    private String numeroDeTelefone;

    private String email;
}
