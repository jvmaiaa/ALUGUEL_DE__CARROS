package com.jvmaiaa.aluguelcarros.api.config.openapi;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@Tag(name = "Cliente")
public interface ClienteControllerOpenApi {

    ClienteResponseDTO cadastra(ClienteRequestDTO clienteRequestDTO, HttpServletResponse response);

    List<ClienteResponseDTO> getClientesComEndereco();

    ClienteResponseDTO getClientePorId(Long id);

    ClienteResponseDTO getClienteComEnderecoPorId(Long id);

    ClienteResponseDTO atualizaCliente(Long id, ClienteRequestDTO dto);

    void deleta(Long id);
}
