package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponse;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponse;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

}
