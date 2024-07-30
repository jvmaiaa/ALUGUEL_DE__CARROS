package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.CarroEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.LocadoraEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.CarroRepository;
import com.jvmaiaa.aluguelcarros.api.domain.repository.LocadoraRepository;
import com.jvmaiaa.aluguelcarros.api.exception.CarroNotFoundException;
import static com.jvmaiaa.aluguelcarros.api.mapper.CarroMapper.*;

import com.jvmaiaa.aluguelcarros.api.exception.LocadoraNotFoundException;
import com.jvmaiaa.aluguelcarros.api.mapper.CarroMapper;
import com.jvmaiaa.aluguelcarros.api.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final ModelMapper modelMapper;
    private final LocadoraRepository locadoraRepository;

    @Override
    @Transactional
    public CarroResponseDTO cadastra(CarroRequestDTO carroRequestDTO) {
        CarroEntity entity = CarroMapper.requestToEntity(carroRequestDTO);
        Long idLocadora = carroRequestDTO.getIdLocadora();
        LocadoraEntity locadora = locadoraRepository.findById(idLocadora)
                .orElseThrow(() -> new LocadoraNotFoundException(idLocadora));
        entity.setLocadora(locadora);
        entity.setDisponivel(true);
        carroRepository.save(entity);
        CarroResponseDTO response = CarroMapper.entityToResponse(entity);
        response.setIdLocadora(idLocadora);
        return response;
    }

    @Override
    public CarroResponseDTO buscaId(Long id) {
        CarroEntity entity = carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(id));
        CarroResponseDTO response = CarroMapper.entityToResponse(entity);
        response.setIdLocadora(carroRepository.findIdLocadooraByIdCarro(id));
        return response;
    }

    @Override
    public List<CarroResponseDTO> lista() {
        return carroRepository.findAll()
                .stream()
                .map(carro -> {
                    CarroResponseDTO response = CarroMapper.entityToResponse(carro);
                    response.setIdLocadora(carroRepository.findIdLocadooraByIdCarro(carro.getId()));
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CarroResponseDTO atualiza(Long id, CarroRequestDTO dto) {
        return carroRepository.findById(id)
                .map(carro -> {
                    atualizaCampos(carro, dto);
                    carroRepository.save(carro);
                    return modelMapper.map(carro, CarroResponseDTO.class);
                }).orElseThrow(() -> new CarroNotFoundException(id));
    }

    @Override
    public void deleta(Long id) {
        carroRepository.delete(carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(id)));
    }
}
