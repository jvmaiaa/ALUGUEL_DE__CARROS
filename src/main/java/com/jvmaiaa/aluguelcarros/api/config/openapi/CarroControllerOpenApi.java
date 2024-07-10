package com.jvmaiaa.aluguelcarros.api.config.openapi;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Tag(name = "Carro")
public interface CarroControllerOpenApi {

    // TODO: configurações da REQUEST
    @Operation(summary = "Cadastra um carro novo.",
            requestBody = @RequestBody(
            description = "Preencha os campos necessários e realize um POST para cadastrar um novo carro.",
            required = true,
            content = @Content(schema = @Schema(implementation = CarroRequestDTO.class))
    ))
    @ApiResponses({ // TODO: configurações da RESPONSE
            @ApiResponse(responseCode = "201", description = "Carro cadastrado com sucesso. CREATED",
                    content = { @Content(mediaType = "application/json",
                            // define qual a classe base, deve ter para a resposta TODO: Sempre usar DTO
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Algum campo inválido. BAD REQUEST",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    })
    })
    CarroResponseDTO cadastra(CarroRequestDTO carroRequestDTO, HttpServletResponse httpServletResponse);


    @Operation(summary = "Lista todos os carros.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um GET para listar todos os carros cadastrados.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listagem de carros realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    })
    })
    List<CarroResponseDTO> getCarros();

    @Operation(summary = "Busca um carro pelo Id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um GET passando o Id para buscar um carro.",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum carro com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    })
    })
    CarroResponseDTO getCarroPorId(Long id);

    @Operation(summary = "Atualiza um carro pelo Id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um PUT passando o Id para atualizar um carro. ",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso. OK",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum carro com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    })
    })
    CarroResponseDTO atualiza(Long id, CarroRequestDTO dto);


    @Operation(summary = "Deleta um carro pelo Id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Realize um DELETE passando o Id para remover um carro. ",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class))
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deleção realizada com sucesso. NO CONTENT",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Nenhum carro com esse Id foi encontrado. NOT FOUND",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarroResponseDTO.class))
                    })
    })
    void deleta(Long id);
}
