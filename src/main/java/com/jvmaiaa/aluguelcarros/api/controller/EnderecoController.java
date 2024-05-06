package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.EnderecoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.Impl.EnderecoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoServiceImpl enderecoServiceImpl;


    @PostMapping
    @ResponseStatus(CREATED)
    public EnderecoResponseDTO criaEndereco(@RequestBody @Valid EnderecoRequestDTO request){
        return enderecoServiceImpl.cadastraEndereco(request);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<EnderecoResponseDTO> findAll(){
        return enderecoServiceImpl.listarEnderecos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponseDTO findById(@PathVariable Long id){
        return enderecoServiceImpl.buscarId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponseDTO update(@PathVariable("id") Long id,
                                      @RequestBody EnderecoRequestDTO request){
        return enderecoServiceImpl.atualizaEndereco(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        enderecoServiceImpl.delete(id);
    }

}
