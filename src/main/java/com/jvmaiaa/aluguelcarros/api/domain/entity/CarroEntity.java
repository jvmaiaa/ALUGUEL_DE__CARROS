package com.jvmaiaa.aluguelcarros.api.domain.entity;

import com.jvmaiaa.aluguelcarros.api.domain.enums.TipoDoMotor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_car")
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String marca;
    private String modelo;
    private String ano;
    private BigDecimal taxaDiaria;
    private TipoDoMotor tipoDoMotor;
}
