package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import org.hibernate.validator.internal.engine.PredefinedScopeConfigurationImpl;

import java.util.List;

public interface FuncionarioService {

    FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO);

    List<FuncionarioResponseDTO> lista();

    FuncionarioResponseDTO buscaId(Long id);

    FuncionarioResponseDTO atualiza(Long id, FuncionarioRequestDTO funcionarioRequestDTO);

    void deleta(Long id);
}
