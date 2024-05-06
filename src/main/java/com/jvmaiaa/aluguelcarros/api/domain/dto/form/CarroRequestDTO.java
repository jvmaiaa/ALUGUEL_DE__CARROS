package com.jvmaiaa.aluguelcarros.api.domain.dto.form;

import com.jvmaiaa.aluguelcarros.api.domain.enums.TipoDoMotor;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarroRequestDTO {

    @NotNull(message = "Placa não pode ser nula")
    @Pattern(regexp = "[A-Za-z]{3}\\d{1}[A-Za-z]\\d{2}", message = "Formato de placa inválido")
    private String placa;

    private String marca;
    private String modelo;

    @Min(value = 1800, message = "O ano do carro deve ter 4 dígitos")
    @Max(value = 2024, message = "O ano do carro deve ter 4 dígitos")
    private Integer anoDoCarro;
    private BigDecimal taxaDiaria;

    private TipoDoMotor tipoDoMotor;

}
