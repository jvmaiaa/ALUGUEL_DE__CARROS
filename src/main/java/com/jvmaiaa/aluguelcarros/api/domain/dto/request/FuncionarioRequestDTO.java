package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class FuncionarioRequestDTO {

    @CPF(message = "O CPF informado é inválido.")
    private String cpf;

    private NomesUsuarioRequestDTO nomesUsuario;

    private Integer idade;

    @Pattern(regexp = "^9[0-9]{8}$", message = "O número de telefone deve conter o padrão: 9xxxxxxxx")
    private String numeroDeTelefone;

    private String email;

    private String password;

    private BigDecimal salario;

    private String departamento;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    @NotNull(message = "O id não deve ser nulo.")
    private Long idLocadora;

}
