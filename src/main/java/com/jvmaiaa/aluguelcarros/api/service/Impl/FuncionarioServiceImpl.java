package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.FuncionarioRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.FuncionarioNotFoundException;
import com.jvmaiaa.aluguelcarros.api.mapper.FuncionarioMapper;
import com.jvmaiaa.aluguelcarros.api.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final ModelMapper modelMapper;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity entity = modelMapper.map(funcionarioRequestDTO, FuncionarioEntity.class);
        funcionarioRepository.save(entity);
        return modelMapper.map(entity, FuncionarioResponseDTO.class);
    }

    @Override
    public List<FuncionarioResponseDTO> lista() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionario -> modelMapper.map(funcionario, FuncionarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioResponseDTO buscaId(Long id) {
        FuncionarioEntity entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
        return modelMapper.map(entity, FuncionarioResponseDTO.class);
    }

    @Override
    public FuncionarioResponseDTO atualiza(Long id,
                                           FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
        FuncionarioMapper.atualizaCampos(entity, funcionarioRequestDTO);
        return modelMapper.map(entity, FuncionarioResponseDTO.class);
    }

    @Override
    public void deleta(Long id) {
        funcionarioRepository.delete(funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id)));
    }
}
