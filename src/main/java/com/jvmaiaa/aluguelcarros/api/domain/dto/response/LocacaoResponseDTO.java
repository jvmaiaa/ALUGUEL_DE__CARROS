package com.jvmaiaa.aluguelcarros.api.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jvmaiaa.aluguelcarros.api.domain.enums.FormaDePagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocacaoResponseDTO {

    private Long id;

    private String codigoDoPedido;

    private FormaDePagamento formaDePagamento;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicioLocacao;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFimLocacao;

    private BigDecimal valorFinal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy:HH:mm")
    private LocalDateTime dataCriacao;

    private Long idCliente;

    private Long idFuncionario;

    private Long idLocadora;

    private Long idCarro;

}
