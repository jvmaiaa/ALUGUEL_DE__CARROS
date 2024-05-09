package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.ClienteRepository;
import com.jvmaiaa.aluguelcarros.api.domain.repository.EnderecoRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.ClienteNotFoundException;
import com.jvmaiaa.aluguelcarros.api.exeption.EnderecoNotFoundException;
import com.jvmaiaa.aluguelcarros.api.mapper.ClienteMapper;
import com.jvmaiaa.aluguelcarros.api.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import static com.jvmaiaa.aluguelcarros.api.mapper.ClienteMapper.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final EnderecoRepository enderecoRepository;

    private final ModelMapper modelMapper;

    @Override
    public ClienteResponseDTO cadastra(ClienteRequestDTO clienteRequest){
        ClienteEntity clienteEntity = ClienteMapper.toAddressEntity(clienteRequest);
        Long idEndereco = clienteRequest.getIdEndereco();
        EnderecoEntity endereco = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new EnderecoNotFoundException(idEndereco));
        clienteEntity.setEnderecoEntity(endereco);
        clienteRepository.save(clienteEntity);
        return modelMapper.map(clienteEntity, ClienteResponseDTO.class);
    }

    @Override
    public List<ClienteResponseDTO> listaCliente() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> ClienteResponseDTO.builder()
                        .id(cliente.getId())
                        .cpf(cliente.getCpf())
                        .nome(cliente.getNome())
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
                .map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO buscaClientePorId(Long id) {
        ClienteEntity entity =  clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return ClienteResponseDTO.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .nome(entity.getNome())
                .idade(entity.getIdade())
                .numeroDeTelefone(entity.getNumeroDeTelefone())
                .email(entity.getEmail())
                .cnh(entity.getCnh())
                .genero(entity.getGenero())
                .observacao(entity.getObservacao()).build();
    }

    @Override
    public ClienteResponseDTO buscaClienteComEnderecoPorId(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElseThrow(
                () -> new ClienteNotFoundException(id));
        return modelMapper.map(clienteEntity, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO atualiza(Long id, ClienteRequestDTO dto){
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        atualizaCamposDaEntidade(entity, dto);
        return modelMapper.map(entity, ClienteResponseDTO.class);
    }

    @Override
    public void deleta(Long id){
        clienteRepository.delete(clienteRepository.findById(id)
                .orElseThrow( () -> new ClienteNotFoundException(id) ));
    }


}
