package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClienteResponseDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idade;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numeroDeTelefone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cnh;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String genero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String observacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EnderecoEntity endereco;
}
