package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocacaoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocacaoResponseDTO;

import java.util.List;

public interface LocacaoService {

    LocacaoResponseDTO cadastra(LocacaoRequestDTO locacaoRequestDTO);

    List<LocacaoResponseDTO> getLocacao();

    LocacaoResponseDTO getLocacaoPorId(Long id);

    void deleta(Long id);
}
