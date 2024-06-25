package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.NomesUsuarioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteResponseDTO {


    private Long id;

    private String cpf;

    private NomesUsuarioResponseDTO nomesUsuario;

    private Integer idade;

    private String numeroDeTelefone;

    private String email;

    private String cnh;

    private String genero;

    private String observacao;

    private EnderecoResponseDTO endereco;
}
