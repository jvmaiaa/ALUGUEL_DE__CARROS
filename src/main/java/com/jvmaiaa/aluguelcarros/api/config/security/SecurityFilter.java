package com.jvmaiaa.aluguelcarros.api.config.security;

import com.jvmaiaa.aluguelcarros.api.domain.entity.UsuarioEntity;
import com.jvmaiaa.aluguelcarros.api.domain.repository.UsuarioRepository;
import com.jvmaiaa.aluguelcarros.api.exception.UnauthorizedException;
import com.jvmaiaa.aluguelcarros.api.service.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String token = extraiTokenHeader(request);

        if (token != null){
            String login = authenticationService.validaTokenJwt(token);
            UsuarioEntity usuario = usuarioRepository.findByEmail(login);

            if (usuario == null){
                throw new UnauthorizedException("Unauthorized");
            }
            var authentication =
                    new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    public String extraiTokenHeader(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");

        //   [0]     [1]
        // Bearer xxxxxxxxx
        if (authHeader == null){
            return null;
        }

        if (!authHeader.split(" ")[0].equals("Bearer")){
            return null;
        }

        return authHeader.split(" ")[1];
    }

}
