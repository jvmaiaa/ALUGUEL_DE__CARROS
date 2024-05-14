package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

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
public class CarroUpdateDTO {

    @Pattern(regexp = "[A-Za-z]{3}\\d{1}[A-Za-z]\\d{2}", message = "Formato de placa inválido")
    private String placa;

    private String marca;

    private String modelo;

    @Min(value = 1900, message = "O ano do carro deve ter 4 dígitos")
    @Max(value = 2024, message = "O ano do carro deve ter 4 dígitos")
    private Integer anoDoCarro;

    private BigDecimal taxaDiaria;

    private TipoDoMotor tipoDoMotor;
}
