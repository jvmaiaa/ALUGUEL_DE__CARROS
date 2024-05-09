package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.EnderecoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponseDTO;

import java.util.List;

public interface EnderecoService {

    EnderecoResponseDTO cadastra(EnderecoRequestDTO enderecoRequestDTO);

    List<EnderecoResponseDTO> lista();

    EnderecoResponseDTO buscaId(Long id);

    EnderecoResponseDTO atualiza(Long id, EnderecoRequestDTO enderecoRequestDTO);

    void deleta(Long id);
}
