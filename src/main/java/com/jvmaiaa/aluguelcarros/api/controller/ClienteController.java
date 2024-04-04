package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponse;
import com.jvmaiaa.aluguelcarros.api.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ClienteResponse cadastraCliente(@Valid @RequestBody ClienteRequest clienteRequest){
        return clienteService.cadastraCliente(clienteRequest);
    }
}
