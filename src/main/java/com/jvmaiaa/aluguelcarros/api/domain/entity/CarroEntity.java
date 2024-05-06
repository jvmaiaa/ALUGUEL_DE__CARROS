package com.jvmaiaa.aluguelcarros.api.domain.entity;

import com.jvmaiaa.aluguelcarros.api.domain.enums.TipoDoMotor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "tb_carro")
@Entity
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String marca;
    private String modelo;
    private Integer anoDoCarro;
    private BigDecimal taxaDiaria;

    @Enumerated(EnumType.STRING)
    private TipoDoMotor tipoDoMotor;

    @OneToOne(mappedBy = "carroEntity")
    private ClienteEntity clienteEntity;
}
