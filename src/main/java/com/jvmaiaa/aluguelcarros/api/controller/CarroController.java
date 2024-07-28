package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.config.openapi.CarroControllerOpenApi;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.CarroService;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("/carro")
public class CarroController implements CarroControllerOpenApi {

    private final CarroService carroService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(CREATED)
    public CarroResponseDTO cadastra(@Parameter(description = "cadastrar Carro")
            @RequestBody @Valid CarroRequestDTO carroRequestDTO,
                                     HttpServletResponse response) {
        CarroResponseDTO carroResponse = carroService.cadastra(carroRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(carroResponse.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return carroResponse;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    @ResponseStatus(OK)
    public List<CarroResponseDTO> getCarros() {
        return carroService.lista();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CarroResponseDTO getCarroPorId(@PathVariable Long id) {
        return carroService.buscaId(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public CarroResponseDTO atualiza(@PathVariable Long id, @RequestBody CarroRequestDTO dto) {
        return carroService.atualiza(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id) {
        carroService.deleta(id);
    }

}
