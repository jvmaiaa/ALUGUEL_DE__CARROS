package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public FuncionarioResponseDTO cadastra(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO){
        return funcionarioService.cadastra(funcionarioRequestDTO);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<FuncionarioResponseDTO> getFuncionario(){
        return funcionarioService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public FuncionarioResponseDTO getFuncionarioPorId(@PathVariable Long id){
        return funcionarioService.buscaId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public FuncionarioResponseDTO atualizaFuncionario(@PathVariable Long id,
                                                      @RequestBody FuncionarioRequestDTO requestDTO){
        return funcionarioService.atualiza(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id){
        funcionarioService.deleta(id);
    }

}
