package com.jvmaiaa.aluguelcarros.api.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NomesUsuarioEntity {

    private String primeiroNome;

    private String sobrenome;

    private String apelido;

}
