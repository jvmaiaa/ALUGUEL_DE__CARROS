package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocadoraRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocadoraResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.LocadoraService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/locadora")
@RequiredArgsConstructor
public class LocadoraController {

    private final LocadoraService locadoraService;

    @PostMapping
    @ResponseStatus(CREATED)
    public LocadoraResponseDTO cadastra(@RequestBody @Valid LocadoraRequestDTO locadoraRequestDTO,
                                        HttpServletResponse response) {
        LocadoraResponseDTO locadora = locadoraService.cadastra(locadoraRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(locadora.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return locadora;
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @GetMapping
    @ResponseStatus(OK)
    public List<LocadoraResponseDTO> lista() {
        log.info("Consultando locadoras...");
        return locadoraService.lista();
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public LocadoraResponseDTO buscaId(@PathVariable Long id) {
        return locadoraService.buscaId(id);
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public LocadoraResponseDTO atualiza(@PathVariable Long id,
                                        @RequestBody LocadoraRequestDTO locadoraRequestDTO) {
        return locadoraService.atualiza(id, locadoraRequestDTO);
    }

    @PreAuthorize("hasRole('FUNCIONARIO')")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id) {
        locadoraService.deleta(id);
    }

}
