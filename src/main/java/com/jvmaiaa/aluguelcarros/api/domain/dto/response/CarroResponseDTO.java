package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.jvmaiaa.aluguelcarros.api.domain.enums.TipoDoMotor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroResponseDTO {

    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private Integer anoDoCarro;

    private BigDecimal taxaDiaria;

    private TipoDoMotor tipoDoMotor;

    private Boolean disponivel;

    private Long idLocadora;
}
