package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Table(name = "tb_cliente")
@Entity
public final class ClienteEntity extends UsuarioEntity {

    private String cnh;

    private String genero;

    private String observacao;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity enderecoEntity;

//    @OneToMany(mappedBy = "cliente")
//    private List<PedidoEntity> pedidoEntity;
}
