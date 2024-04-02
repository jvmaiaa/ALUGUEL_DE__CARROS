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

import java.lang.reflect.Field;
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

    public EnderecoResponse insert(EnderecoRequest dto){
        converteCampos(dto);
        EnderecoEntity dtoParaEntidade = modelMapper.map(dto, EnderecoEntity.class);
        enderecoRepository.save(dtoParaEntidade);
        return modelMapper.map(dtoParaEntidade, EnderecoResponse.class);
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

    public EnderecoResponse update(Long id, EnderecoRequest dto){
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

    private void atualizaCamposEndereco(EnderecoEntity entity, EnderecoRequest dto) {
        Field[] camposDTO = dto.getClass().getDeclaredFields();

        for (Field campoDTO : camposDTO) {
            try {
                Field campoEntity = entity.getClass().getDeclaredField(campoDTO.getName());
                campoDTO.setAccessible(true);
                Object valorDTO = campoDTO.get(dto);

                if (valorDTO != null) {
                    campoEntity.setAccessible(true);
                    campoEntity.set(entity, valorDTO);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
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
