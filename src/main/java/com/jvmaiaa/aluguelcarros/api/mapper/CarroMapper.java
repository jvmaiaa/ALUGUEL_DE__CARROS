package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.CarroEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarroMapper {

    public static void atualizaCampos(CarroEntity entity, CarroRequestDTO dto){
       entity.setPlaca(dto.getPlaca() != null ? dto.getPlaca() : entity.getPlaca());
       entity.setMarca(dto.getMarca() != null ? dto.getMarca() : entity.getMarca());
       entity.setModelo(dto.getModelo() != null ? dto.getModelo() : entity.getModelo());
       entity.setAnoDoCarro(dto.getAnoDoCarro() != null ? dto.getAnoDoCarro() : entity.getAnoDoCarro());
       entity.setTaxaDiaria(dto.getTaxaDiaria() != null ? dto.getTaxaDiaria() : entity.getTaxaDiaria());
       entity.setTipoDoMotor(dto.getTipoDoMotor() != null ? dto.getTipoDoMotor() : entity.getTipoDoMotor());
    }
}
