package com.jvmaiaa.aluguelcarros.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(DataInvalidaException.class)
    @ResponseStatus(BAD_REQUEST)
    public String handleDataInvalidaException(DataInvalidaException e){
        return e.getMessage();
    }

    @ExceptionHandler(UsuarioExistenteException.class)
    @ResponseStatus(CONFLICT)
    public String handleUsuarioExistenteException(UsuarioExistenteException e){
        return e.getMessage();
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(UNAUTHORIZED)
    public String handleUnauthorizedException(UnauthorizedException e){
        return e.getMessage();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleEntityNotFoundException(EntityNotFoundException e){
        return e.getMessage();
    }
}
