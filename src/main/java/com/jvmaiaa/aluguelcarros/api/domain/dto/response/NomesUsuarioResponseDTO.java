package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NomesUsuarioResponseDTO {

    private String primeiroNome;

    private String sobrenome;

    private String apelido;
}
