package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_client")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;
    private String cnh;
    private LocalDate dataDeNascimento;
    private String numeroDeTelefone;
    private String email;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity enderecoEntity;
}
