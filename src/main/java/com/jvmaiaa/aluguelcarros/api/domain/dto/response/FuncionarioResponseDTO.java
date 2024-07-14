package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.NomesUsuarioRequestDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class FuncionarioResponseDTO {

    private Long id;

    private String cpf;

    private NomesUsuarioResponseDTO nomesUsuario;

    private Integer idade;

    private String numeroDeTelefone;

    private String email;

    private BigDecimal salario;

    private String departamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt-BR", timezone = "Brazil/East")
    private LocalTime horaInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "pt-BR", timezone = "Brazil/East")
    private LocalTime horaFim;

    private Long idLocadora;
}
