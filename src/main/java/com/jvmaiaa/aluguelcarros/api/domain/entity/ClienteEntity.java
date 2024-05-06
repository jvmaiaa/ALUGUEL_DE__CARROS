package com.jvmaiaa.aluguelcarros.api.domain.entity;

import com.jvmaiaa.aluguelcarros.api.domain.enums.FormaDePagamento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "tb_cliente")
@Entity
public final class ClienteEntity extends UsuarioEntity{

    private String cnh;
    private FormaDePagamento formaDePagamento;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity enderecoEntity;

    @OneToOne
    @JoinColumn(name = "carro_id")
    private CarroEntity carroEntity;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidoEntity;
}
