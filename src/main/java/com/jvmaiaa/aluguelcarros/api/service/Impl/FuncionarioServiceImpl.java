package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.LocadoraEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.UsuarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.enums.RoleEnum;
import com.jvmaiaa.aluguelcarros.api.domain.repository.FuncionarioRepository;
import com.jvmaiaa.aluguelcarros.api.domain.repository.LocadoraRepository;
import com.jvmaiaa.aluguelcarros.api.domain.repository.UsuarioRepository;
import com.jvmaiaa.aluguelcarros.api.exception.EntityNotFoundException;
import com.jvmaiaa.aluguelcarros.api.exception.FuncionarioNotFoundException;
import com.jvmaiaa.aluguelcarros.api.exception.LocadoraNotFoundException;
import com.jvmaiaa.aluguelcarros.api.exception.UsuarioExistenteException;
import com.jvmaiaa.aluguelcarros.api.mapper.FuncionarioMapper;
import com.jvmaiaa.aluguelcarros.api.mapper.NomesUsuarioMapper;
import com.jvmaiaa.aluguelcarros.api.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final String FUNCIONARIO_NAO_ENCONTRADO = "O funcionário com id %d não foi encontrado!";

    private final FuncionarioRepository funcionarioRepository;
    private final LocadoraRepository locadoraRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarioExiste(funcionarioRequestDTO);
        var passwordHash = passwordEncoder.encode(funcionarioRequestDTO.getPassword());
        funcionarioRequestDTO.setPassword(passwordHash);
        FuncionarioEntity entity = FuncionarioMapper.toFuncionarioEntity(funcionarioRequestDTO);
        entity.setRole(RoleEnum.FUNCIONARIO);
        Long idLocadora = funcionarioRequestDTO.getIdLocadora();
        LocadoraEntity locadora = locadoraRepository.findById(idLocadora)
                .orElseThrow(() -> new LocadoraNotFoundException(idLocadora));
        entity.setLocadora(locadora);
        funcionarioRepository.save(entity);
        FuncionarioResponseDTO funcionarioResponseDTO = FuncionarioMapper.entityToResponse(entity);
        funcionarioResponseDTO.setIdLocadora(idLocadora);
        return funcionarioResponseDTO;
    }


    @Override
    public List<FuncionarioResponseDTO> lista() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionario -> {
                        FuncionarioResponseDTO response = FuncionarioMapper.entityToResponse(funcionario);
                        response.setIdLocadora(funcionarioRepository.findIdLocadoraByIdFuncionario(response.getId()));
                        return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioResponseDTO buscaId(Long id) {
        FuncionarioEntity entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(FUNCIONARIO_NAO_ENCONTRADO + id));
        FuncionarioResponseDTO response = FuncionarioMapper.entityToResponse(entity);
        response.setIdLocadora(funcionarioRepository.findIdLocadoraByIdFuncionario(id));
        return response;
    }

    @Override
    public FuncionarioResponseDTO atualiza(Long id,
                                           FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(FUNCIONARIO_NAO_ENCONTRADO + id));
        atualizaCampos(entity, funcionarioRequestDTO);
        funcionarioRepository.save(entity);
        return FuncionarioMapper.entityToResponse(entity);
    }

    @Override
    public void deleta(Long id) {
        funcionarioRepository.delete(funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(FUNCIONARIO_NAO_ENCONTRADO + id)));
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

    private void funcionarioExiste(FuncionarioRequestDTO funcionarioRequestDTO) {
        UsuarioEntity clienteJaExiste = usuarioRepository.findByEmail(funcionarioRequestDTO.getEmail());
        if (clienteJaExiste != null) {
            throw new UsuarioExistenteException("Esse e-mail já está cadastrado no sistema.");
        }
    }
}
