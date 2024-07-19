package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.LocacaoRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.dto.response.LocacaoResponseDTO;
import com.jvmaiaa.aluguelcarros.api.service.LocacaoService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/locacao")
@RestController
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public LocacaoResponseDTO cadastra(@RequestBody LocacaoRequestDTO locacaoRequestDTO,
                                      HttpServletResponse response){
        LocacaoResponseDTO locacao = locacaoService.cadastra(locacaoRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(locacao.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return locacao;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<LocacaoResponseDTO> lista(){
        return locacaoService.getLocacao();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public LocacaoResponseDTO getLocacaoPorId(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public LocacaoResponseDTO atualiza(@PathVariable Long id,
                                       @RequestBody LocacaoRequestDTO requestDTO){
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleta(@PathVariable Long id){

    }
}
