package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequest;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponse;
import com.jvmaiaa.aluguelcarros.api.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(OK)
    public List<ClienteResponse> listaClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public ClienteResponse buscarId(@Valid @PathVariable("id") Long id){
        return clienteService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public ClienteResponse atualizaClientes(@Valid @PathVariable("id") Long id,
                                            @RequestBody ClienteRequest dto){
        return clienteService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaCliente(@PathVariable("id") Long id){
        clienteService.deletaCliente(id);
    }
}
