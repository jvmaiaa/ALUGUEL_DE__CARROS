package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.CarroRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.CarroResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.CarroService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carro")
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    @ResponseStatus(CREATED)
    public CarroResponseDTO cadastra(@RequestBody @Valid CarroRequestDTO carroRequestDTO,
                                     HttpServletResponse response) {
        CarroResponseDTO carroResponse = carroService.cadastra(carroRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(carroResponse.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return carroResponse;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<CarroResponseDTO> getCarros() {
        return carroService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CarroResponseDTO getCarroPorId(@PathVariable Long id) {
        return carroService.buscaId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public CarroResponseDTO atualiza(@PathVariable Long id, @RequestBody CarroRequestDTO dto) {
        return carroService.atualiza(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id) {
        carroService.deleta(id);
    }

}
