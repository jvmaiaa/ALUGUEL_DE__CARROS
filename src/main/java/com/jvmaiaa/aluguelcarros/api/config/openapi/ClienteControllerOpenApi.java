package com.jvmaiaa.aluguelcarros.api.config.openapi;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Tag(name = "Cliente")
public interface ClienteControllerOpenApi {

    // TODO: configurações da REQUEST
    @Operation(summary = "Cadastra cliente carro novo.",
            requestBody = @RequestBody(
                    description = "Preencha os campos necessários e realize um POST para cadastrar um novo cliente.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class))
            ))
    @ApiResponses({ // TODO: configurações da RESPONSE
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso. CREATED",
                    content = { @Content(mediaType = "application/json",
                            // define qual a classe base, deve ter para a resposta TODO: Sempre usar DTO
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Algum campo inválido. BAD REQUEST",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    })
    })
    ClienteResponseDTO cadastra(ClienteRequestDTO clienteRequestDTO, HttpServletResponse response);

    @Operation(summary = "Lista todos os clientes.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um GET para listar todos os clientes cadastrados.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listagem de clientes realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    })
    })
    List<ClienteResponseDTO> getClientes();

    List<ClienteResponseDTO> getClientesComEndereco();

    @Operation(summary = "Busca um cliente pelo Id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um GET passando o Id para buscar um cliente.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    })
    })
    ClienteResponseDTO getClientePorId(Long id);

    ClienteResponseDTO getClienteComEnderecoPorId(Long id);

    @Operation(summary = "Atualiza um cliente pelo Id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um PUT passando o Id para atualizar um carro. ",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    })
    })
    ClienteResponseDTO atualizaCliente(Long id, ClienteRequestDTO dto);

    @Operation(summary = "Deleta um cliente pelo Id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um DELETE passando o Id para remover um cliente.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ClienteRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deleção realizada com sucesso. NO CONTENT",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponseDTO.class))
                    })
    })
    void deleta(Long id);
}
