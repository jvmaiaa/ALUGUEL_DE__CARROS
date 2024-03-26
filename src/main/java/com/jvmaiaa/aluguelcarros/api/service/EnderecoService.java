package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.EnderecoRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponse;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ViaCepResponse;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.EnderecoRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.EnderecoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
