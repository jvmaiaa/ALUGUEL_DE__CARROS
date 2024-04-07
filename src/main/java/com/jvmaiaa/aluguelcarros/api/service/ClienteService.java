package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponse;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.ClienteRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.ClienteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public ClienteResponse cadastraCliente(ClienteRequest clienteRequest){
        ClienteEntity clienteEntity = modelMapper.map(clienteRequest, ClienteEntity.class);
        clienteRepository.save(clienteEntity);
        return modelMapper.map(clienteEntity, ClienteResponse.class);
    }

    public List<ClienteResponse> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> {
                    return modelMapper.map(cliente, ClienteResponse.class);
                }).collect(Collectors.toList());
    }

    public ClienteResponse buscaPorId(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElseThrow(
                () -> new ClienteNotFoundException(id));
        return modelMapper.map(clienteEntity, ClienteResponse.class);
    }

}
