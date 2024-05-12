package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.jvmaiaa.aluguelcarros.api.domain.enums.TipoDoMotor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CarroResponseDTO {

    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private Integer anoDoCarro;

    private BigDecimal taxaDiaria;

    private TipoDoMotor tipoDoMotor;
}
