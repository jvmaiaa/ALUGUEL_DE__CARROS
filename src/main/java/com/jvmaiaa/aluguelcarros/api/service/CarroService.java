package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;

import java.util.List;

public interface CarroService {

    CarroResponseDTO cadastra(CarroRequestDTO carroRequestDTO);

    CarroResponseDTO buscaId(Long id);

    List<CarroResponseDTO> lista();

    CarroResponseDTO atualiza(Long id, CarroRequestDTO carroRequestDTO);

    void deleta(Long id);
}
