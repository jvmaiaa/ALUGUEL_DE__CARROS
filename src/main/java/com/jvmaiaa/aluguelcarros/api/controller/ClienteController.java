package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.form.ClienteRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.ClienteResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.Impl.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteServiceImpl clienteServiceImpl;

    @PostMapping
    @ResponseStatus(CREATED)
    public ClienteResponseDTO cadastraCliente(@Valid @RequestBody ClienteRequestDTO clienteRequest){
        return clienteServiceImpl.cadastraCliente(clienteRequest);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ClienteResponseDTO> listaClientes(){
        return clienteServiceImpl.listarClientes();
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO buscarId(@Valid @PathVariable("id") Long id){
        return clienteServiceImpl.buscaPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public ClienteResponseDTO atualizaClientes(@Valid @PathVariable("id") Long id,
                                               @RequestBody ClienteRequestDTO dto){
        return clienteServiceImpl.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaCliente(@PathVariable("id") Long id){
        clienteServiceImpl.deletaCliente(id);
    }
}
