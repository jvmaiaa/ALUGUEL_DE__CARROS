package com.jvmaiaa.aluguelcarros.api.domain.dto.request;

import com.jvmaiaa.aluguelcarros.api.domain.enums.FormaDePagamento;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocacaoRequestDTO {

    private FormaDePagamento formaDePagamento;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataInicioLocacao;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataFimLocacao;

    private BigDecimal valorFinal;

    private Long idCliente;

    // Preciso pegar o Id da locadora, mas posso pegar pelo Id do funcionário
    // já que um funcionário só existe, se estiver vinculado com o Id de uma locadora.
    private Long idFuncionario;

    private Long idCarro;

}
