package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.EnderecoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ViaCepResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.EnderecoRepository;
import com.jvmaiaa.aluguelcarros.api.exception.EnderecoNotFoundException;
import com.jvmaiaa.aluguelcarros.api.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final ModelMapper modelMapper;
    private final EnderecoRepository enderecoRepository;
    private final String VIA_CEP_URL = "https://viacep.com.br/ws/";
    private final RestTemplate restTemplate;

    @Override
    public EnderecoResponseDTO cadastra(EnderecoRequestDTO dto){
        converteCampos(dto);
        EnderecoEntity dtoParaEntidade = modelMapper.map(dto, EnderecoEntity.class);
        enderecoRepository.save(dtoParaEntidade);
        return modelMapper.map(dtoParaEntidade, EnderecoResponseDTO.class);
    }

    @Override
    public List<EnderecoResponseDTO> lista(){
        return  enderecoRepository.findAll()
                .stream()
                .map(endereco -> modelMapper.map(endereco, EnderecoResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoResponseDTO buscaId(Long id){
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id));
        return modelMapper.map(enderecoEntity, EnderecoResponseDTO.class);
    }

    @Override
    public EnderecoResponseDTO atualiza(Long id, EnderecoRequestDTO dto){
        EnderecoEntity entity = enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id));
        atualizaCamposEndereco(entity, dto);
        enderecoRepository.save(entity);
        return modelMapper.map(entity, EnderecoResponseDTO.class);
    }

    @Override
    public void deleta(Long id){
        enderecoRepository.delete(enderecoRepository.findById(id).orElseThrow(
                () -> new EnderecoNotFoundException(id)));
    }

    private void atualizaCamposEndereco(EnderecoEntity entity, EnderecoRequestDTO dto){
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

    private void converteCampos(EnderecoRequestDTO dto){
        String url = VIA_CEP_URL + dto.getCep() + "/json/";
        ViaCepResponseDTO response = restTemplate.getForObject(url, ViaCepResponseDTO.class);

        if (dto.getCidade() == null || dto.getCidade().trim().isEmpty()){
            dto.setCidade(response.getLocalidade());
        }
        if (dto.getEstado() == null || dto.getEstado().trim().isEmpty()){
            dto.setEstado(response.getUf());
        }
    }                  
}
