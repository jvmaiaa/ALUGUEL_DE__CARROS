package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_locadora")
public class LocadoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private LocalTime horarioAbertura;

    private LocalTime horarioFechamento;

    @OneToMany(mappedBy = "locadora")
    private List<CarroEntity> carros;

}
