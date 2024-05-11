package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.EnderecoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.EnderecoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.EnderecoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public EnderecoResponseDTO criaEndereco(@RequestBody @Valid EnderecoRequestDTO request,
                                            HttpServletResponse response){
        EnderecoResponseDTO enderecoResponse = enderecoService.cadastra(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(enderecoResponse.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return enderecoResponse;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<EnderecoResponseDTO> findAll(){
        return enderecoService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponseDTO findById(@PathVariable Long id){
        return enderecoService.buscaId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoResponseDTO update(@PathVariable("id") Long id,
                                      @RequestBody EnderecoRequestDTO request){
        return enderecoService.atualiza(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        enderecoService.deleta(id);
    }

}
