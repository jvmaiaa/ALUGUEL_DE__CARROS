package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocacaoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocacaoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.*;
import com.jvmaiaa.aluguelcarros.api.domain.repository.*;
import com.jvmaiaa.aluguelcarros.api.exception.*;
import com.jvmaiaa.aluguelcarros.api.mapper.LocacaoMapper;
import com.jvmaiaa.aluguelcarros.api.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.jvmaiaa.aluguelcarros.api.exception.ErroMessages.*;

@RequiredArgsConstructor
@Service
public class LocacaoServiceImpl implements LocacaoService {

    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final LocadoraRepository locadoraRepository;
    private final LocacaoRepository locacaoRepository;
    private final CarroRepository carroRepository;

    @Override
    @Transactional
    public LocacaoResponseDTO cadastra(LocacaoRequestDTO locacaoRequestDTO) {

        verificaData(locacaoRequestDTO.getDataInicioLocacao(), locacaoRequestDTO.getDataFimLocacao());

        // TODO : Criar método para realizar tudo de uma vez
        Long idCliente = locacaoRequestDTO.getIdCliente();
        Long idFuncionario = locacaoRequestDTO.getIdFuncionario();
        Long idCarro = locacaoRequestDTO.getIdCarro();

        ClienteEntity clienteEntity = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, idCliente)));
        FuncionarioEntity funcionarioEntity = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new EntityNotFoundException(String.format(FUNCIONARIO_NAO_ENCONTRADO, idFuncionario)));
        LocadoraEntity locadoraEntity = carroRepository.findLocadoraByIdCarro(idCarro);
        CarroEntity carroEntity = carroRepository.findById(idCarro)
                .orElseThrow(() -> new EntityNotFoundException(String.format(CARRO_NAO_ENCONTRADO, idCarro)));

        LocacaoEntity locacaoEntity = LocacaoMapper.requestToEntity(locacaoRequestDTO);
        locacaoEntity.setCliente(clienteEntity);
        locacaoEntity.setFuncionarioEntity(funcionarioEntity);
        locacaoEntity.setLocadora(locadoraEntity);
        locacaoEntity.setCarro(carroEntity);
        locacaoRepository.save(locacaoEntity);
        carroEntity.setDisponivel(false);
        locacaoEntity.getFuncionarioEntity().comissaoDeVenda(locacaoEntity.getValorFinal());

        LocacaoResponseDTO locacaoResponse = LocacaoMapper.entityToResponse(locacaoEntity);
        locacaoResponse.setIdCliente(idCliente);
        locacaoResponse.setIdFuncionario(idFuncionario);
        locacaoResponse.setIdLocadora(locadoraEntity.getId());
        locacaoResponse.setIdCarro(idCarro);

        return locacaoResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocacaoResponseDTO> getLocacao() {
        return locacaoRepository.findAll()
                .stream()
                .map(locacaoEntity -> {
                    Long idFuncionario = locacaoEntity.getFuncionarioEntity().getId();
                    LocacaoResponseDTO locacaoResponseDTO = LocacaoMapper.entityToResponse(locacaoEntity);
                    locacaoResponseDTO.setIdCliente(locacaoEntity.getCliente().getId());
                    locacaoResponseDTO.setIdFuncionario(locacaoEntity.getFuncionarioEntity().getId());
                    locacaoResponseDTO.setIdLocadora(funcionarioRepository.findIdLocadoraByIdFuncionario(idFuncionario));
                    locacaoResponseDTO.setIdCarro(locacaoEntity.getCarro().getId());
                    return locacaoResponseDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public LocacaoResponseDTO getLocacaoPorId(Long id) {
        LocacaoEntity locacaoEntity = locacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCACAO_NAO_ENCONTRADA, id)));
        Long idFuncionario = locacaoEntity.getFuncionarioEntity().getId();
        LocacaoResponseDTO locacaoResponseDTO = LocacaoMapper.entityToResponse(locacaoEntity);
        locacaoResponseDTO.setIdCliente(locacaoEntity.getCliente().getId());
        locacaoResponseDTO.setIdFuncionario(idFuncionario);
        locacaoResponseDTO.setIdLocadora(funcionarioRepository.findIdLocadoraByIdFuncionario(idFuncionario));
        locacaoResponseDTO.setIdCarro(locacaoEntity.getCarro().getId());
        return locacaoResponseDTO;
    }

    @Override
    public void deleta(Long id) {
        locacaoRepository.delete(locacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOCACAO_NAO_ENCONTRADA, id))));
    }

    private static void verificaData(LocalDate dataInicio, LocalDate dataFim){
        if (!dataInicio.isBefore(dataFim)){
            throw new DataInvalidaException("A data inicial deve ser antes da data final!");
        }
    }
}
