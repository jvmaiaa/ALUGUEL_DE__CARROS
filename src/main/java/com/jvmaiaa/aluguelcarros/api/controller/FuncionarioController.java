package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.config.openapi.FuncionarioControllerOpenApi;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.FuncionarioRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.FuncionarioResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.FuncionarioService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController implements FuncionarioControllerOpenApi {

    private final FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public FuncionarioResponseDTO cadastra(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO,
                                           HttpServletResponse response){
        FuncionarioResponseDTO funcionarioResponse = funcionarioService.cadastra(funcionarioRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(funcionarioResponse.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return funcionarioResponse;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<FuncionarioResponseDTO> getFuncionarios(){
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
