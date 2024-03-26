package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.CepDTO;
import com.jvmaiaa.aluguelcarros.api.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("consulta-cep")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping("{cep}")
    public CepDTO consultaCep(@PathVariable("cep") String cep){
        return enderecoService.consultaCep(cep);
    }

}
