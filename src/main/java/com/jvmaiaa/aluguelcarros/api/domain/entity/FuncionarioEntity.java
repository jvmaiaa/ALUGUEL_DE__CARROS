package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "tb_funcionario")
@Entity
public final class FuncionarioEntity extends UsuarioEntity{

    private BigDecimal salario;

    private String cargo;

    @OneToMany(mappedBy = "funcionarioEntity")
    private List<PedidoEntity> pedidoEntity;
}
