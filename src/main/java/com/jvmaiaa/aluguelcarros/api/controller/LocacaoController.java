package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocacaoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocacaoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.LocacaoService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/locacao")
@RestController
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @PostMapping
    @ResponseStatus(CREATED)
    public LocacaoResponseDTO cadastra(@RequestBody LocacaoRequestDTO locacaoRequestDTO,
                                      HttpServletResponse response){
        LocacaoResponseDTO locacao = locacaoService.cadastra(locacaoRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(locacao.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return locacao;
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @GetMapping
    @ResponseStatus(OK)
    public List<LocacaoResponseDTO> lista(){
        return locacaoService.getLocacao();
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public LocacaoResponseDTO getLocacaoPorId(@PathVariable Long id){
        return locacaoService.getLocacaoPorId(id);
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id){
        locacaoService.deleta(id);
    }
}
