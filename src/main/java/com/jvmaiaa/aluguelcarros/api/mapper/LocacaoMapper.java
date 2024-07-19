package com.jvmaiaa.aluguelcarros.api.mapper;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocacaoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocacaoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.LocacaoEntity;

public class LocacaoMapper {

    public static LocacaoEntity requestToEntity(LocacaoRequestDTO dto){
        if (dto == null){
            return null;
        }
        LocacaoEntity entity = new LocacaoEntity();
        entity.setFormaDePagamento(dto.getFormaDePagamento());
        entity.setDataInicioLocacao(dto.getDataInicioLocacao());
        entity.setDataFimLocacao(dto.getDataFimLocacao());
        entity.setValorFinal(dto.getValorFinal());
        return entity;
    }

    public static LocacaoResponseDTO entityToResponse(LocacaoEntity entity){
        if(entity == null){
            return null;
        }
        LocacaoResponseDTO responseDTO = new LocacaoResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setCodigoDoPedido(entity.getCodigoDoPedido());
        responseDTO.setFormaDePagamento(entity.getFormaDePagamento());
        responseDTO.setDataInicioLocacao(entity.getDataInicioLocacao());
        responseDTO.setDataFimLocacao(entity.getDataFimLocacao());
        responseDTO.setDataCriacao(entity.getDataCriacao());
        responseDTO.setValorFinal(entity.getValorFinal());
        responseDTO.setDataCriacao(entity.getDataCriacao());
        return responseDTO;
    }

}
