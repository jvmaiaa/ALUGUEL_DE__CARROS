package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.config.openapi.EnderecoControllerOpenApi;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.EnderecoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.EnderecoService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController implements EnderecoControllerOpenApi {

    private final EnderecoService enderecoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public EnderecoResponseDTO cadastra(@RequestBody @Valid EnderecoRequestDTO request,
                                            HttpServletResponse response){
        EnderecoResponseDTO enderecoResponse = enderecoService.cadastra(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(enderecoResponse.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return enderecoResponse;
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @GetMapping
    @ResponseStatus(OK)
    public List<EnderecoResponseDTO> getEnderecos(){
        return enderecoService.lista();
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponseDTO getEnderecoById(@PathVariable Long id){
        return enderecoService.buscaId(id);
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponseDTO atualiza(@PathVariable("id") Long id,
                                      @RequestBody EnderecoRequestDTO request){
        return enderecoService.atualiza(id, request);
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable("id") Long id){
        enderecoService.deleta(id);
    }

}
