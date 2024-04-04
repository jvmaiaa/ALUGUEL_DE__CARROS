package com.jvmaiaa.aluguelcarros.api.domain.dto.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class ClienteRequest {

    private Long id;

    @CPF
    private String cpf;

    private String nome;

    @Size(min = 11, max = 11, message = "O número da CNH deve conter 11 caracteres")
    @Pattern(regexp = "[0-9]+", message = "O número da CNH deve conter apenas números")
    private String cnh;

    private LocalDate dataDeNascimento;

    @Column(length = 9)
    private String numeroDeTelefone;

    @Email
    private String email;
}
