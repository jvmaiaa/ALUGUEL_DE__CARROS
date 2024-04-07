package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.EnderecoRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponse;
import com.jvmaiaa.aluguelcarros.api.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;


    @PostMapping
    @ResponseStatus(CREATED)
    public EnderecoResponse criaEndereco(@RequestBody @Valid EnderecoRequest request){
        return enderecoService.cadastraEndereco(request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<EnderecoResponse> findAll(){
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponse findById(@PathVariable Long id){
        return enderecoService.buscarId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponse update(@PathVariable("id") Long id,
                                   @RequestBody EnderecoRequest request){
        return enderecoService.atualizaEndereco(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        enderecoService.delete(id);
    }

}
