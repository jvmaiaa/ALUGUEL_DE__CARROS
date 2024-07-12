package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocadoraRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocadoraResponseDTO;

import java.util.List;

public interface LocadoraService {

    LocadoraResponseDTO cadastra(LocadoraRequestDTO locadoraRequestDTO);

    List<LocadoraResponseDTO> lista();

    LocadoraResponseDTO buscaId(Long id);

    LocadoraResponseDTO atualiza(Long id, LocadoraRequestDTO locadoraRequestDTO);

    void deleta(Long id);
}
