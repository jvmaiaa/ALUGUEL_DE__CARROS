package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class FuncionarioRequestDTO {

    private String cpf;

    private NomesUsuarioRequestDTO nomesUsuario;

    private Integer idade;

    private String numeroDeTelefone;

    private String email;

    private BigDecimal salario;

    private String departamento;

    private LocalTime horaInicio;

    private LocalTime horaFim;

}
