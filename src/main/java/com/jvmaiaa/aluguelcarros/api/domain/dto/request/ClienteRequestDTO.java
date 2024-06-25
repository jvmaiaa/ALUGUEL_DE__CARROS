package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ClienteRequestDTO {

    @CPF(message = "CPF inválido. Realize a verificação")
    @NotNull(message = "Campo CPF não pode ser nulo")
    private String cpf;

    private NomesUsuarioRequestDTO nomesUsuario;

    @NotNull(message = "O campo 'DATA DE NASCIMENTO' não pode ser nulo.")
    private Integer idade;

    @Column(length = 9)
    private String numeroDeTelefone;

    @Email(message = "E-mail inválido. Realize a verificação.")
    private String email;

    @Size(min = 11, max = 11, message = "O número da CNH deve conter 11 caracteres")
    @Pattern(regexp = "[0-9]+", message = "O número da CNH deve conter apenas números")
    private String cnh;

    @NotEmpty(message = "O campo GENERO precisa ser preenchido")
    private String genero;

    private String observacao;

    private Long idEndereco;


}
