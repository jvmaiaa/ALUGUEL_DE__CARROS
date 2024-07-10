package com.jvmaiaa.aluguelcarros.api.config.openapi;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Tag(name = "Carro")
public interface CarroControllerOpenApi {

    @Operation(summary = "Cadastra um carro novo.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Preencha os campos necessários para cadastrar um novo carro",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CarroRequestDTO.class))
    ))
    CarroResponseDTO cadastra(CarroRequestDTO carroRequestDTO, HttpServletResponse httpServletResponse);

    @Operation(summary = "Lista todos os carros.")
    List<CarroResponseDTO> getCarros();

    @Operation(summary = "Busca um carro pelo Id.")
    CarroResponseDTO getCarroPorId(Long id);

    @Operation(summary = "Atualiza um carro pelo Id.")
    CarroResponseDTO atualiza(Long id, CarroRequestDTO dto);

    @Operation(summary = "Deleta um carro pelo Id.")
    void deleta(Long id);
}
