package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.ClienteRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.ClienteNotFoundException;
import com.jvmaiaa.aluguelcarros.api.mapper.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public ClienteResponseDTO cadastraCliente(ClienteRequestDTO clienteRequest){
        ClienteEntity clienteEntity = modelMapper.map(clienteRequest, ClienteEntity.class);
        clienteRepository.save(clienteEntity);
        return modelMapper.map(clienteEntity, ClienteResponseDTO.class);
    }

    public List<ClienteResponseDTO> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> {
                    return modelMapper.map(cliente, ClienteResponseDTO.class);
                }).collect(Collectors.toList());
    }

    public ClienteResponseDTO buscaPorId(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElseThrow(
                () -> new ClienteNotFoundException(id));
        return modelMapper.map(clienteEntity, ClienteResponseDTO.class);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto){
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        Builder.atualizaCamposDaEntidade(entity, dto);
        return modelMapper.map(entity, ClienteResponseDTO.class);
    }

    public void deletaCliente(Long id){
        clienteRepository.delete(clienteRepository.findById(id)
                .orElseThrow( () -> new ClienteNotFoundException(id) ));
    }


}
