package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.FuncionarioRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.FuncionarioNotFoundException;
import com.jvmaiaa.aluguelcarros.api.mapper.FuncionarioMapper;
import com.jvmaiaa.aluguelcarros.api.mapper.NomesUsuarioMapper;
import com.jvmaiaa.aluguelcarros.api.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity entity = FuncionarioMapper.toFuncionarioEntity(funcionarioRequestDTO);
        funcionarioRepository.save(entity);
        return FuncionarioMapper.entityToResponse(entity);
    }

    @Override
    public List<FuncionarioResponseDTO> lista() {
        return funcionarioRepository.findAll()
                .stream()
                .map(FuncionarioMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioResponseDTO buscaId(Long id) {
        FuncionarioEntity entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
        return FuncionarioMapper.entityToResponse(entity);
    }

    @Override
    public FuncionarioResponseDTO atualiza(Long id,
                                           FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
        atualizaCampos(entity, funcionarioRequestDTO);
        return FuncionarioMapper.entityToResponse(entity);
    }

    @Override
    public void deleta(Long id) {
        funcionarioRepository.delete(funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id)));
    }

    public static void atualizaCampos(FuncionarioEntity entity, FuncionarioRequestDTO dto){
        entity.setCpf(dto.getCpf() != null ? dto.getCpf() : entity.getCpf());
        entity.setNomesUsuario(dto.getNomesUsuario() != null
                ? NomesUsuarioMapper.requestToEntity(dto.getNomesUsuario())
                : entity.getNomesUsuario());
        entity.setIdade(dto.getIdade() != null ? dto.getIdade() : entity.getIdade());
        entity.setNumeroDeTelefone(dto.getNumeroDeTelefone() != null ? dto.getNumeroDeTelefone() : entity.getNumeroDeTelefone());
        entity.setEmail(dto.getEmail() != null ? dto.getNumeroDeTelefone() : entity.getNumeroDeTelefone());
        entity.setSalario(dto.getSalario() != null ? dto.getSalario() : entity.getSalario());
        entity.setDepartamento(dto.getDepartamento() != null ? dto.getDepartamento() : entity.getDepartamento());
        entity.setHoraInicio(dto.getHoraInicio() != null ? dto.getHoraInicio() : entity.getHoraInicio());
        entity.setHoraFim(dto.getHoraFim() != null ? dto.getHoraFim() : entity.getHoraFim());
    }
}
