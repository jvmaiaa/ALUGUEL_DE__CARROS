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

    public EnderecoResponse cadastraEndereco(EnderecoRequest dto){
        converteCampos(dto);
        EnderecoEntity dtoParaEntidade = modelMapper.map(dto, EnderecoEntity.class);
        enderecoRepository.save(dtoParaEntidade);
        return modelMapper.map(dtoParaEntidade, EnderecoResponse.class);
    }

    public List<EnderecoResponse> listarEnderecos(){
        return  enderecoRepository.findAll()
                .stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoResponse.class))
                .collect(Collectors.toList());
    }

    public EnderecoResponse buscarId(Long id){
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id));
        return modelMapper.map(enderecoEntity, EnderecoResponse.class);
    }

    public EnderecoResponse atualizaEndereco(Long id, EnderecoRequest dto){
        EnderecoEntity entity = enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id));
        atualizaCamposEndereco(entity, dto);
        modelMapper.map(entity, EnderecoResponse.class);
        enderecoRepository.save(entity);
        return modelMapper.map(entity, EnderecoResponse.class);
    }

    public void delete(Long id){
        enderecoRepository.delete(enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id)));
    }

    private void atualizaCamposEndereco(EnderecoEntity entity, EnderecoRequest dto){
        if (dto.getCep() != null) {
            entity.setCep(dto.getCep());
        }
        if (dto.getRua() != null){
            entity.setRua(dto.getRua());
        }
        if (dto.getNumero() != null){
            entity.setNumero(dto.getNumero());
        }
        if ( dto.getBairro() != null){
            entity.setBairro(dto.getBairro());
        }
        if (dto.getCidade() != null){
            entity.setCidade(dto.getCidade());
        }
        if (dto.getEstado() != null){
            entity.setEstado(dto.getEstado());
        }
    }

    private void converteCampos(EnderecoRequest dto){
        String url = VIA_CEP_URL + dto.getCep() + "/json/";
        ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);

        if (dto.getCidade() == null || dto.getCidade().trim().isEmpty()){
            dto.setCidade(response.getLocalidade());
        }
        if (dto.getEstado() == null || dto.getEstado().trim().isEmpty()){
            dto.setEstado(response.getUf());
        }
    }                  
}
