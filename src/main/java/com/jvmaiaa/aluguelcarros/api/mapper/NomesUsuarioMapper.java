package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.NomesUsuarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.NomesUsuarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.NomesUsuarioEntity;

public class NomesUsuarioMapper {

    public static NomesUsuarioEntity requestToEntity(NomesUsuarioRequestDTO dto){
        NomesUsuarioEntity entity = new NomesUsuarioEntity();
        entity.setPrimeiroNome(dto.getPrimeiroNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setApelido(dto.getApelido());
        return entity;
    }

    public static NomesUsuarioResponseDTO entityToResponse(NomesUsuarioEntity entity){
        NomesUsuarioResponseDTO response = new NomesUsuarioResponseDTO();
        response.setPrimeiroNome(entity.getPrimeiroNome());
        response.setSobrenome(entity.getSobrenome());
        response.setApelido(entity.getApelido());
        return response;
    }

}
