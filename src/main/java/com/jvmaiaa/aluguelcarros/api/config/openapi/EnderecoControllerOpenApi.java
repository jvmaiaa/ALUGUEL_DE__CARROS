package com.jvmaiaa.aluguelcarros.api.config.openapi;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.EnderecoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Tag(name = "Endereço")
public interface EnderecoControllerOpenApi {

    EnderecoResponseDTO cadastra(EnderecoRequestDTO request, HttpServletResponse response);

    List<EnderecoResponseDTO> getEnderecos();

    EnderecoResponseDTO getEnderecoById(Long id);

    EnderecoResponseDTO atualiza(Long id, EnderecoRequestDTO request);

    void deleta(Long id);
}
