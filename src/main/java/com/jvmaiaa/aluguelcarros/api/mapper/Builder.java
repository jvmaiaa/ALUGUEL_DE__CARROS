package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequest;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Builder {

    private final ClienteRequest clienteRequest;

    private final ClienteEntity clienteEntity;

    public static void atualizaCamposDaEntidade(ClienteEntity entity, ClienteRequest dto){
        if (dto.getCpf() != null){
            entity.setCpf(dto.getCpf());
        }
        if (dto.getNome() != null){
            entity.setNome(dto.getNome());
        }
        if (dto.getCnh() != null){
            entity.setCnh(dto.getCnh());
        }
        if (dto.getDataDeNascimento() != null){
            entity.setDataDeNascimento(dto.getDataDeNascimento());
        }
        if(dto.getNumeroDeTelefone() != null){
            entity.setNumeroDeTelefone(dto.getNumeroDeTelefone());
        }
        if (dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }
    }

}