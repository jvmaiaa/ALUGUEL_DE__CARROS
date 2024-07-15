package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import com.jvmaiaa.aluguelcarros.api.domain.enums.TipoDoMotor;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CarroRequestDTO {

    // 3 letras maiúsculas, 1 digito, 1 letra maiúscula ou minúscula, e 2 digitos -> ABC1D23
    @NotNull(message = "Placa não pode ser nula")
    @Pattern(regexp = "[A-Za-z]{3}\\d{1}[A-Za-z]\\d{2}", message = "Formato de placa inválido")
    private String placa;

    private String marca;

    private String modelo;

    @Min(value = 1900, message = "O ano do carro deve ter 4 dígitos e ser maior que o ano de 1900")
    @Max(value = 2024, message = "O ano do carro deve ter 4 dígitos e ser menor que o ano de 2024")
    private Integer anoDoCarro;

    private BigDecimal taxaDiaria;

    private TipoDoMotor tipoDoMotor;

    private Long idLocadora;
}
