package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.AuthenticationRequestDTO;
import com.jvmaiaa.aluguelcarros.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    @PostMapping
    @ResponseStatus(OK)
    public String auth(@RequestBody AuthenticationRequestDTO dto){

        var usuarioAutenticationToken =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        authenticationManager.authenticate(usuarioAutenticationToken);

        return authenticationService.obterToken(dto);
    }
}
