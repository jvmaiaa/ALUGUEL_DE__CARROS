package com.jvmaiaa.aluguelcarros.api.service;

import com.jvmaiaa.aluguelcarros.api.domain.dto.request.AuthenticationRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    String obterToken(AuthenticationRequestDTO dto);

    String validaTokenJwt(String token);
}
