package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public final class FuncionarioEntity extends UsuarioEntity{

    private BigDecimal salario;

    private String cargo;

    private String departamento;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fim")
    private LocalTime horaFim;

    @ManyToOne
    @JoinColumn(name = "locadora_id")
    private LocadoraEntity locadora;

    @OneToMany(mappedBy = "funcionarioEntity")
    private List<LocacaoEntity> locacaoEntity = new ArrayList<>();

    public void comissaoDeVenda(BigDecimal valorDoPedido){
        this.salario = this.salario.add(valorDoPedido.multiply(BigDecimal.valueOf(0.1)));
    }
}
