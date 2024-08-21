package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {

    ClienteResponseDTO cadastra(ClienteRequestDTO clienteRequestDTO);

    List<ClienteResponseDTO> listaClientes();

    List<ClienteResponseDTO> listaClienteComEndereco();

    ClienteResponseDTO buscaClienteComEnderecoPorId(Long id);

    ClienteResponseDTO buscaClientePorId(Long id);

    ClienteResponseDTO atualiza(Long id, ClienteRequestDTO clienteRequestDTO);

    void deleta(Long id);


}
