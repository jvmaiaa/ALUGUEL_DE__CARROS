package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.CarroEntity;

public class CarroMapper {

    public static CarroEntity requestToEntity(CarroRequestDTO carroRequestDTO){
        if (carroRequestDTO == null){
            return null;
        }
        CarroEntity entity = new CarroEntity();
        entity.setPlaca(carroRequestDTO.getPlaca());
        entity.setMarca(carroRequestDTO.getMarca());
        entity.setModelo(carroRequestDTO.getModelo());
        entity.setAnoDoCarro(carroRequestDTO.getAnoDoCarro());
        entity.setTaxaDiaria(carroRequestDTO.getTaxaDiaria());
        entity.setTipoDoMotor(carroRequestDTO.getTipoDoMotor());
        return entity;
    }

    public static CarroResponseDTO entityToResponse(CarroEntity entity){
        if (entity == null){
            return null;
        }
        CarroResponseDTO response = new CarroResponseDTO();
        response.setId(entity.getId());
        response.setPlaca(entity.getPlaca());
        response.setMarca(entity.getMarca());
        response.setModelo(entity.getModelo());
        response.setAnoDoCarro(entity.getAnoDoCarro());
        response.setTaxaDiaria(entity.getTaxaDiaria());
        response.setTipoDoMotor(entity.getTipoDoMotor());
        response.setDisponivel(entity.getDisponivel());
        return response;
    }


    public static void atualizaCampos(CarroEntity entity, CarroRequestDTO dto){
       entity.setPlaca(dto.getPlaca() != null ? dto.getPlaca() : entity.getPlaca());
       entity.setMarca(dto.getMarca() != null ? dto.getMarca() : entity.getMarca());
       entity.setModelo(dto.getModelo() != null ? dto.getModelo() : entity.getModelo());
       entity.setAnoDoCarro(dto.getAnoDoCarro() != null ? dto.getAnoDoCarro() : entity.getAnoDoCarro());
       entity.setTaxaDiaria(dto.getTaxaDiaria() != null ? dto.getTaxaDiaria() : entity.getTaxaDiaria());
       entity.setTipoDoMotor(dto.getTipoDoMotor() != null ? dto.getTipoDoMotor() : entity.getTipoDoMotor());
    }
}
