package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FuncionarioMapper {

    private final FuncionarioEntity funcionario;
    private final FuncionarioRequestDTO funcionarioRequestDTO;

    public static void atualizaCampos(FuncionarioEntity entity, FuncionarioRequestDTO dto){
        entity.setCpf(dto.getCpf() != null ? dto.getCpf() : entity.getCpf());
        entity.setNome(dto.getNome() != null ? dto.getNome() : entity.getNome());
        entity.setIdade(dto.getIdade() != null ? dto.getIdade() : entity.getIdade());
        entity.setNumeroDeTelefone(dto.getNumeroDeTelefone() != null ? dto.getNumeroDeTelefone() : entity.getNumeroDeTelefone());
        entity.setEmail(dto.getEmail() != null ? dto.getNumeroDeTelefone() : entity.getNumeroDeTelefone());
        entity.setSalario(dto.getSalario() != null ? dto.getSalario() : entity.getSalario());
        entity.setDepartamento(dto.getDepartamento() != null ? dto.getDepartamento() : entity.getDepartamento());
        entity.setHoraInicio(dto.getHoraInicio() != null ? dto.getHoraInicio() : entity.getHoraInicio());
        entity.setHoraFim(dto.getHoraFim() != null ? dto.getHoraFim() : entity.getHoraFim());
    }
}