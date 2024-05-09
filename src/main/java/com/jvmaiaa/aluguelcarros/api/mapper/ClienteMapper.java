package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteMapper {

    private final ClienteRequestDTO clienteRequest;

    private final ClienteEntity clienteEntity;

    public static void atualizaCamposDaEntidade(ClienteEntity entity, ClienteRequestDTO dto){
        if (dto.getCpf() != null){
            entity.setCpf(dto.getCpf());
        }
        if (dto.getNome() != null){
            entity.setNome(dto.getNome());
        }
        if (dto.getCnh() != null){
            entity.setCnh(dto.getCnh());
        }
        if (dto.getIdade() != null){
            entity.setIdade(dto.getIdade());
        }
        if(dto.getNumeroDeTelefone() != null){
            entity.setNumeroDeTelefone(dto.getNumeroDeTelefone());
        }
        if (dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }
        if (dto.getCnh() != null){
            entity.setCnh(dto.getCnh());
        }
        if (dto.getGenero() != null){
            entity.setGenero(dto.getGenero());
        }
        if (dto.getObservacao() != null){
            entity.setObservacao(dto.getObservacao());
        }
    }

    public static ClienteEntity toAddressEntity(ClienteRequestDTO dto){
        ClienteEntity entity = new ClienteEntity();
        entity.setCpf(dto.getCpf());
        entity.setNome(dto.getNome());
        entity.setIdade(dto.getIdade());
        entity.setNumeroDeTelefone(dto.getNumeroDeTelefone());
        entity.setEmail(dto.getEmail());
        entity.setCnh(dto.getCnh());
        entity.setGenero(dto.getGenero());
        entity.setObservacao(dto.getObservacao());
        return entity;
    }

}
