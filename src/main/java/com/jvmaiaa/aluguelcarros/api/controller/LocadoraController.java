package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocadoraRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocadoraResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.LocadoraService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

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

    @GetMapping
    @ResponseStatus(OK)
    public List<LocadoraResponseDTO> lista() {
        return locadoraService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public LocadoraResponseDTO buscaId(@PathVariable Long id) {
        return locadoraService.buscaId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public LocadoraResponseDTO atualiza(@PathVariable Long id,
                                        @RequestBody LocadoraRequestDTO locadoraRequestDTO) {
        return locadoraService.atualiza(id, locadoraRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id) {
        locadoraService.deleta(id);
    }

}
