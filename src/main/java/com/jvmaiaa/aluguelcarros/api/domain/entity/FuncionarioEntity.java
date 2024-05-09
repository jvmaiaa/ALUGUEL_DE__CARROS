package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Table(name = "tb_funcionario")
@Entity
public final class FuncionarioEntity extends UsuarioEntity{

    private BigDecimal salario;

    private String cargo;

    private String departamento;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fim")
    private String horaFim;

    @OneToMany(mappedBy = "funcionarioEntity")
    private List<LocacaoEntity> locacaoEntity = new ArrayList<>();
}
