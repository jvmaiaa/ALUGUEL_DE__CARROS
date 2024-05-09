package com.jvmaiaa.aluguelcarros.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "tb_endereco")
@Entity
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    @JsonIgnore
    @OneToOne(mappedBy = "enderecoEntity")
    private ClienteEntity cliente;

}
