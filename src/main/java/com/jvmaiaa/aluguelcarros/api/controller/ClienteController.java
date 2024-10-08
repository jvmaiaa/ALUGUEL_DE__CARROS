package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.config.openapi.ClienteControllerOpenApi;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.ClienteService;
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

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @GetMapping
    @ResponseStatus(OK)
    public List<ClienteResponseDTO> getClientes(){
        return clienteService.listaClientes();
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @GetMapping("/endereco")
    @ResponseStatus(OK)
    public List<ClienteResponseDTO> getClientesComEndereco(){
        return clienteService.listaClienteComEndereco();
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO getClientePorId(@Valid @PathVariable("id") Long id){
        return clienteService.buscaClientePorId(id);
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @GetMapping("/endereco/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO getClienteComEnderecoPorId(@Valid @PathVariable("id") Long id){
        return clienteService.buscaClienteComEnderecoPorId(id);
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO atualizaCliente(@Valid @PathVariable("id") Long id,
                                       @RequestBody ClienteRequestDTO dto){
        return clienteService.atualiza(id, dto);
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO')")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable("id") Long id){
        clienteService.deleta(id);
    }
}
