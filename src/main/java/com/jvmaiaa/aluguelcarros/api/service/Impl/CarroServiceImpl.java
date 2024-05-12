package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.CarroEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.CarroRepository;
import com.jvmaiaa.aluguelcarros.api.exeption.CarroNotFoundException;
import com.jvmaiaa.aluguelcarros.api.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final ModelMapper modelMapper;

    @Override
    public CarroResponseDTO cadastra(CarroRequestDTO carroRequestDTO) {
        CarroEntity entity = modelMapper.map(carroRequestDTO, CarroEntity.class);
        carroRepository.save(entity);
        return modelMapper.map(entity, CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO buscaId(Long id) {
        CarroEntity entity = carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(id));
        return modelMapper.map(entity, CarroResponseDTO.class);
    }

    @Override
    public List<CarroResponseDTO> lista() {
        return carroRepository.findAll()
                .stream()
                .map(carro -> modelMapper.map(carro, CarroResponseDTO.class)).collect(Collectors.toList());/
    }

//    @Override
//    public CarroResponseDTO atualiza(Long id, CarroRequestDTO carroRequestDTO) {
//        return;
//    }

    @Override
    public void deleta(Long id) {
        carroRepository.delete(carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(id)));
    }
}
