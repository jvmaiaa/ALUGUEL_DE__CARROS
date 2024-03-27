package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.EnderecoRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponse;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ViaCepResponse;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.EnderecoRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.EnderecoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final ModelMapper modelMapper;

    private final EnderecoRepository enderecoRepository;

    private final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    private final RestTemplate restTemplate;

    public ViaCepResponse consultaCep(String cep){
        String url = VIA_CEP_URL + cep + "/json/";
        return restTemplate.getForObject(url, ViaCepResponse.class);
    }

    public EnderecoResponse insert(EnderecoRequest enderecoRequest){
        verificaCamposNulos(enderecoRequest);
        EnderecoEntity enderecoEntity = modelMapper.map(enderecoRequest, EnderecoEntity.class);
        enderecoRepository.save(enderecoEntity);
        return modelMapper.map(enderecoEntity, EnderecoResponse.class);
    }

    public List<EnderecoResponse> findAll(){
        return  enderecoRepository.findAll()
                .stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class))
                .collect(Collectors.toList());
    }

    public EnderecoResponse findById(Long id){
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id));
        return modelMapper.map(enderecoEntity, EnderecoResponse.class);
    }

    public EnderecoResponse update(Long id, EnderecoRequest request){
        EnderecoEntity entity = enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id));
        atualizaCamposEndereco(entity, request);
        modelMapper.map(entity, EnderecoResponse.class);
        enderecoRepository.save(entity);
        return modelMapper.map(entity, EnderecoResponse.class);
    }

    public void delete(Long id){
        enderecoRepository.delete(enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id)));
    }

    private void atualizaCamposEndereco(EnderecoEntity entity, EnderecoRequest obj){
        if (obj.getCep() != null && !(Objects.equals(entity.getCep(), obj.getCep()))){
            entity.setCep(obj.getCep());
        }
        if (obj.getRua() != null && !(Objects.equals(entity.getRua(), obj.getRua()))){
            entity.setRua(obj.getRua());
        }
        if (obj.getNumero() != null && !(Objects.equals(entity.getNumero(), obj.getNumero()))){
            entity.setNumero(obj.getNumero());
        }
        if ( obj.getBairro() != null && !(Objects.equals(entity.getBairro(), obj.getBairro()))){
            entity.setBairro(obj.getBairro());
        }
        if (obj.getCidade() != null && !(Objects.equals(entity.getCidade(), obj.getCidade()))){
            entity.setCidade(obj.getCidade());
        }
        if (obj.getEstado() != null && !(Objects.equals(entity.getEstado(), obj.getEstado()))){
            entity.setEstado(obj.getEstado());
        }
    }

    private void verificaCamposNulos(EnderecoRequest enderecoRequest){
        String url = VIA_CEP_URL + enderecoRequest.getCep() + "/json/";
        ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);

        if (enderecoRequest.getRua() == null){
            enderecoRequest.setRua(response.getLogradouro());
        }
        if (enderecoRequest.getBairro() == null){
            enderecoRequest.setBairro(response.getBairro());
        }
        if (enderecoRequest.getCidade() == null){
            enderecoRequest.setCidade(response.getLocalidade());
        }
        if (enderecoRequest.getEstado() == null){
            enderecoRequest.setEstado(response.getUf());
        }
    }
}
