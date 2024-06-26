package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;

public class FuncionarioMapper {

    public static FuncionarioEntity toFuncionarioEntity(FuncionarioRequestDTO dto){
        FuncionarioEntity entity = new FuncionarioEntity();
        entity.setCpf(dto.getCpf());
        entity.setNomesUsuario(NomesUsuarioMapper.requestToEntity(dto.getNomesUsuario()));
        entity.setIdade(dto.getIdade());
        entity.setNumeroDeTelefone(dto.getNumeroDeTelefone());
        entity.setEmail(dto.getEmail());
        entity.setSalario(dto.getSalario());
        entity.setDepartamento(dto.getDepartamento());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFim(dto.getHoraFim());
        return entity;
    }

    public static FuncionarioResponseDTO entityToResponse(FuncionarioEntity entity){
        FuncionarioResponseDTO response = new FuncionarioResponseDTO();
        response.setId(entity.getId());
        response.setCpf(entity.getCpf());
        response.setNomesUsuario(NomesUsuarioMapper.entityToResponse(entity.getNomesUsuario()));
        response.setIdade(entity.getIdade());
        response.setNumeroDeTelefone(entity.getNumeroDeTelefone());
        response.setEmail(entity.getEmail());
        response.setSalario(entity.getSalario());
        response.setDepartamento(entity.getDepartamento());
        response.setHoraInicio(entity.getHoraInicio());
        response.setHoraFim(entity.getHoraFim());
        return response;
    }
}