package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;

public class ClienteMapper {

    public static ClienteEntity requestToEntity(ClienteRequestDTO dto){
        if (dto == null){
            return null;
        }
        ClienteEntity entity = new ClienteEntity();
        entity.setCpf(dto.getCpf());
        entity.setNomesUsuario(NomesUsuarioMapper.requestToEntity(dto.getNomesUsuario()));
        entity.setIdade(dto.getIdade());
        entity.setNumeroDeTelefone(dto.getNumeroDeTelefone());
        entity.setEmail(dto.getEmail());
        entity.setCnh(dto.getCnh());
        entity.setGenero(dto.getGenero());
        entity.setObservacao(dto.getObservacao());
        return entity;
    }

    public static ClienteResponseDTO entityToResponse(ClienteEntity entity){
        if (entity == null){
            return null;
        }
        ClienteResponseDTO response = new ClienteResponseDTO();
        response.setId(entity.getId());
        response.setCpf(entity.getCpf());
        response.setNomesUsuario(NomesUsuarioMapper.entityToResponse(entity.getNomesUsuario()));
        response.setIdade(entity.getIdade());
        response.setNumeroDeTelefone(entity.getNumeroDeTelefone());
        response.setEmail(entity.getEmail());
        response.setCnh(entity.getCnh());
        response.setGenero(entity.getGenero());
        response.setObservacao(entity.getObservacao());
        return response;
    }

}
