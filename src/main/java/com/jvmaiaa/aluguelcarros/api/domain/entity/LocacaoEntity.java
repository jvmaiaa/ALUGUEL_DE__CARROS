package com.jvmaiaa.aluguelcarros.api.domain.entity;

import com.jvmaiaa.aluguelcarros.api.domain.enums.FormaDePagamento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "tb_pedido")
@Entity
public class LocacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_do_pedido")
    private String numeroDoPedido;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

//    @ManyToOne
//    @JoinColumn(name = "cliente_id")
//    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity funcionarioEntity;

    private LocalDate dataInicialDoAluguel;

    private LocalDate dataFinalDoAluguel;

    private BigDecimal preco;

}
