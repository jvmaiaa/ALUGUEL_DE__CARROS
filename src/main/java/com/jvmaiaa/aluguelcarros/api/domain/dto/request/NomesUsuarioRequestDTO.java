package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NomesUsuarioRequestDTO {

    private String primeiroNome;

    private String sobrenome;

    private String apelido;
}
