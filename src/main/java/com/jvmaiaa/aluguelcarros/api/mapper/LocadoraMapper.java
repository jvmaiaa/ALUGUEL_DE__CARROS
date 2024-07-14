package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocadoraRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocadoraResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.LocadoraEntity;

public class LocadoraMapper {

    public static LocadoraEntity requestToEntity(LocadoraRequestDTO requestDTO){
        if (requestDTO == null){
            return null;
        }
        LocadoraEntity entity = new LocadoraEntity();
        entity.setNome(requestDTO.getNome());
        entity.setTelefone(requestDTO.getTelefone());
        entity.setEmail(requestDTO.getEmail());
        entity.setHorarioAbertura(requestDTO.getHorarioAbertura());
        entity.setHorarioFechamento(requestDTO.getHorarioFechamento());
        return entity;
    }

    public static LocadoraResponseDTO entityToResponse(LocadoraEntity entity){
        if (entity == null){
            return null;
        }
        LocadoraResponseDTO response = new LocadoraResponseDTO();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setTelefone(entity.getTelefone());
        response.setEmail(entity.getEmail());
        response.setHorarioAbertura(entity.getHorarioAbertura());
        response.setHorarioFechamento(entity.getHorarioFechamento());
        return response;
    }
}
