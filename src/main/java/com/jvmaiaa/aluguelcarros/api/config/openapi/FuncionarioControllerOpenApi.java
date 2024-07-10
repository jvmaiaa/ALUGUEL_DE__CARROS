package com.jvmaiaa.aluguelcarros.api.config.openapi;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Tag(name = "Funcionário")
public interface FuncionarioControllerOpenApi {

    @Operation(summary = "Cadastra um funcionário novo.",
            requestBody = @RequestBody(
                description = "Preencha os campos necessários e realize um POST para cadastrar um novo funcionário",
                required = true,
                content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
    ))
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Funcionário cadastrado com sucesso. CREATED",
                content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = FuncionarioResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Algum campo inválido. BAD REQUEST",
                content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = FuncionarioResponseDTO.class))
            })
    })
    FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO,
                                    HttpServletResponse response);

    @Operation(summary = "Lista todos os Funcionários.",
            requestBody = @RequestBody(
                    description = "Realize um GET para listar todos os carros cadastrados",
                    required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listagem de funcionários realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    })
    })
    List<FuncionarioResponseDTO> getFuncionarios();

    @Operation(summary = "Busca um funcionário pelo Id.",
            requestBody = @RequestBody(
                    description = "Preencha os campos necessários e realize um POST para cadastrar um novo funcionário",
                    required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Funcionário cadastrado com sucesso. CREATED",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum funcinário com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    })
    })
    FuncionarioResponseDTO getFuncionarioPorId(Long id);

    @Operation(summary = "Atualiza um funcionário pelo Id.",
            requestBody = @RequestBody(
                    description = "Realize um PUT passando o Id para atualizar um funcionário.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum funcionário com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    })
    })
    FuncionarioResponseDTO atualizaFuncionario(Long id,
                                               FuncionarioRequestDTO funcionarioRequestDTO);

    @Operation(summary = "Deleta um funcionário ppelo Id.",
            requestBody = @RequestBody(
                    description = "Realize um DELETE passando o Id para remover um funcionário.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deleção realizada com sucesso. DELETE",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum funcionário com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))
                    })
    })
    void deleta(Long id);


}
