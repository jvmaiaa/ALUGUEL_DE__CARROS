package com.jvmaiaa.aluguelcarros.api.domain.entity;

import com.jvmaiaa.aluguelcarros.api.domain.enums.FormaDePagamento;
import com.jvmaiaa.aluguelcarros.api.mapper.LocacaoMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "tb_locacao")
@Entity
public class LocacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_do_pedido")
    private String codigoDoPedido;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

    private LocalDate dataInicioLocacao;

    private LocalDate dataFimLocacao;

    private BigDecimal valorFinal;

    @CreatedDate
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity funcionarioEntity;

    @ManyToOne
    @JoinColumn(name = "locadora_id")
    private LocadoraEntity locadora;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private CarroEntity carro;


    @PrePersist
    public void prePersist(){
        if (this.codigoDoPedido == null){
            this.codigoDoPedido = UUID.randomUUID().toString();
        }
        if (this.dataCriacao == null){
            this.dataCriacao = LocalDateTime.now();
        }
    }
}
