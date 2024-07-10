package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.config.openapi.ClienteControllerOpenApi;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.ClienteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController implements ClienteControllerOpenApi {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ClienteResponseDTO cadastra(@Valid @RequestBody ClienteRequestDTO clienteRequest,
                                       HttpServletResponse response){
        ClienteResponseDTO clienteResponse = clienteService.cadastra(clienteRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(clienteResponse.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return clienteResponse;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ClienteResponseDTO> getClientes(){
        return clienteService.listaCliente();
    }

    @GetMapping("/endereco")
    @ResponseStatus(OK)
    public List<ClienteResponseDTO> getClientesComEndereco(){
        return clienteService.listaClienteComEndereco();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO getClientePorId(@Valid @PathVariable("id") Long id){
        return clienteService.buscaClientePorId(id);
    }

    @GetMapping("/endereco/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO getClienteComEnderecoPorId(@Valid @PathVariable("id") Long id){
        return clienteService.buscaClienteComEnderecoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO atualizaCliente(@Valid @PathVariable("id") Long id,
                                       @RequestBody ClienteRequestDTO dto){
        return clienteService.atualiza(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable("id") Long id){
        clienteService.deleta(id);
    }
}
