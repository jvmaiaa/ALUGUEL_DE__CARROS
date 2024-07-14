package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "primeiroNome", column = @Column(name = "primeiro_nome")),
            @AttributeOverride(name = "sobrenome", column = @Column(name = "sobrenome")),
            @AttributeOverride(name = "apelido", column = @Column(name = "apelido"))
    })
    private NomesUsuarioEntity nomesUsuario;

    private Integer idade;

    @Column(name = "telefone")
    private String numeroDeTelefone;

    @Column(unique = true)
    private String email;
}
