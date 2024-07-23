package com.jvmaiaa.aluguelcarros.api.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jvmaiaa.aluguelcarros.api.domain.dto.request.AuthenticationRequestDTO;
import com.jvmaiaa.aluguelcarros.api.domain.entity.UsuarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.UsuarioRepository;
import com.jvmaiaa.aluguelcarros.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(login);
    }

    @Override
    public String obterToken(AuthenticationRequestDTO dto) {

        UsuarioEntity login = usuarioRepository.findByEmail(dto.getEmail());

        return geraTokenJwt(login);
    }


    public String geraTokenJwt(UsuarioEntity usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256("my-secret");

            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao tentar gerar o token!" + e.getMessage());
        }
    }

    public String validaTokenJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("my-secret");

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant gerarDataExpiracao() {
        return LocalDateTime.now()
                .plusMinutes(3)
                .toInstant(ZoneOffset.of("-03:00"));
    }

}
