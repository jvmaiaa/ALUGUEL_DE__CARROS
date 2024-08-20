package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.UsuarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.enums.RoleEnum;
import com.jvmaiaa.aluguelcarros.api.domain.repository.ClienteRepository;
import com.jvmaiaa.aluguelcarros.api.domain.repository.EnderecoRepository;
import com.jvmaiaa.aluguelcarros.api.domain.repository.UsuarioRepository;
import com.jvmaiaa.aluguelcarros.api.exception.EntityNotFoundException;
import com.jvmaiaa.aluguelcarros.api.exception.UsuarioExistenteException;
import com.jvmaiaa.aluguelcarros.api.mapper.ClienteMapper;
import com.jvmaiaa.aluguelcarros.api.mapper.NomesUsuarioMapper;
import com.jvmaiaa.aluguelcarros.api.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jvmaiaa.aluguelcarros.api.exception.ErroMessages.*;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public ClienteResponseDTO cadastra(ClienteRequestDTO clienteRequest){
        clienteExiste(clienteRequest);
        var passwordHash = encoder.encode(clienteRequest.getPassword());
        clienteRequest.setPassword(passwordHash);
        ClienteEntity clienteEntity = ClienteMapper.requestToEntity(clienteRequest);
        clienteEntity.setRole(RoleEnum.CLIENTE);
        Long idEndereco = clienteRequest.getIdEndereco();
        EnderecoEntity endereco = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, idEndereco)));
        clienteEntity.setEnderecoEntity(endereco);
        clienteRepository.save(clienteEntity);
        return ClienteMapper.entityToResponse(clienteEntity);
    }


    @Override
    public List<ClienteResponseDTO> listaCliente() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> ClienteResponseDTO.builder()
                        .id(cliente.getId())
                        .cpf(cliente.getCpf())
                        .nomesUsuario(NomesUsuarioMapper.entityToResponse(cliente.getNomesUsuario()))
                        .idade(cliente.getIdade())
                        .numeroDeTelefone(cliente.getNumeroDeTelefone())
                        .email(cliente.getEmail())
                        .cnh(cliente.getCnh())
                        .genero(cliente.getGenero())
                        .observacao(cliente.getObservacao())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<ClienteResponseDTO> listaClienteComEndereco() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO buscaClientePorId(Long id) {
        ClienteEntity clienteEntity =  clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id)));
        return ClienteResponseDTO.builder()
                .id(clienteEntity.getId())
                .cpf(clienteEntity.getCpf())
                .nomesUsuario(NomesUsuarioMapper.entityToResponse(clienteEntity.getNomesUsuario()))
                .idade(clienteEntity.getIdade())
                .numeroDeTelefone(clienteEntity.getNumeroDeTelefone())
                .email(clienteEntity.getEmail())
                .cnh(clienteEntity.getCnh())
                .genero(clienteEntity.getGenero())
                .observacao(clienteEntity.getObservacao()).build();
    }

    @Override
    public ClienteResponseDTO buscaClienteComEnderecoPorId(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id)));
        return ClienteMapper.entityToResponse(clienteEntity);
    }

    @Override
    public ClienteResponseDTO atualiza(Long id, ClienteRequestDTO dto){
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id)));
        atualizaCampos(entity, dto);
        return ClienteMapper.entityToResponse(entity);
    }

    @Override
    public void deleta(Long id){
        clienteRepository.delete(clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id))));
    }

    public static void atualizaCampos(ClienteEntity entity, ClienteRequestDTO dto){
        entity.setCpf(dto.getCpf() != null ? dto.getCpf() : entity.getCpf());
        entity.setNomesUsuario(dto.getNomesUsuario() != null
                ? NomesUsuarioMapper.requestToEntity(dto.getNomesUsuario())
                : entity.getNomesUsuario());
    }

    private void clienteExiste(ClienteRequestDTO clienteRequest) {
        UsuarioEntity clienteJaExiste = usuarioRepository.findByEmail(clienteRequest.getEmail());
        if (clienteJaExiste != null){
            throw new UsuarioExistenteException("Esse e-mail já está cadastrado no sistema.");
        }
    }
}
