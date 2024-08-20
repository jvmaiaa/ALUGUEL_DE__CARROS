package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocadoraRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocadoraResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.LocadoraEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.LocadoraRepository;
import com.jvmaiaa.aluguelcarros.api.exception.EntityNotFoundException;
import com.jvmaiaa.aluguelcarros.api.mapper.LocadoraMapper;
import com.jvmaiaa.aluguelcarros.api.service.LocadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jvmaiaa.aluguelcarros.api.exception.ErroMessages.*;

@Service
@RequiredArgsConstructor
public class LocadoraServiceImpl implements LocadoraService {

    private final LocadoraRepository locadoraRepository;

    @Override
    public LocadoraResponseDTO cadastra(LocadoraRequestDTO locadoraRequestDTO) {
        LocadoraEntity entity = LocadoraMapper.requestToEntity(locadoraRequestDTO);
        locadoraRepository.save(entity);
        return LocadoraMapper.entityToResponse(entity);
    }

    @Override
    public List<LocadoraResponseDTO> lista() {
        return locadoraRepository.findAll().stream()
                .map(LocadoraMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LocadoraResponseDTO buscaId(Long id) {
        LocadoraEntity entity = locadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCADORA_NAO_ENCONTRADA, id)));
        return LocadoraMapper.entityToResponse(entity);
    }

    @Override
    public LocadoraResponseDTO atualiza(Long id, LocadoraRequestDTO locadoraRequestDTO) {
        LocadoraEntity entity = locadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCADORA_NAO_ENCONTRADA, id)));
        atualizaCampos(entity, locadoraRequestDTO);
        locadoraRepository.save(entity);
        return LocadoraMapper.entityToResponse(entity);
    }

    @Override
    public void deleta(Long id) {
        LocadoraEntity entity = locadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCADORA_NAO_ENCONTRADA, id)));
        locadoraRepository.delete(entity);
    }

    private static void atualizaCampos(LocadoraEntity entity, LocadoraRequestDTO locadoraRequestDTO){
        entity.setNome(locadoraRequestDTO.getNome() != null ? locadoraRequestDTO.getNome() : entity.getNome());
        entity.setTelefone(locadoraRequestDTO.getTelefone() != null ? locadoraRequestDTO.getTelefone() : entity.getTelefone());
        entity.setEmail(locadoraRequestDTO.getEmail() != null ? locadoraRequestDTO.getEmail() : entity.getEmail());
        entity.setHorarioAbertura(locadoraRequestDTO.getHorarioAbertura() != null
                ? locadoraRequestDTO.getHorarioAbertura()
                : entity.getHorarioAbertura());
        entity.setHorarioFechamento(locadoraRequestDTO.getHorarioFechamento() != null
                ? locadoraRequestDTO.getHorarioFechamento()
                : entity.getHorarioFechamento());
    }
}
