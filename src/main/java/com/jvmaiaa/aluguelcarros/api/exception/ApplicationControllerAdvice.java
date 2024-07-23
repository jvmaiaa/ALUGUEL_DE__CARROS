package com.jvmaiaa.aluguelcarros.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(EnderecoNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleEnderecoNotFoundException(EnderecoNotFoundException e){
        log.error("Exceção lançada devido endereço não ter sido encontrado!");
        return e.getMessage();
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleClienteNotFoundException(ClienteNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(FuncionarioNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleFuncionarioNotFoundException(FuncionarioNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(CarroNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleCarroNotFoundException(CarroNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(LocadoraNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleLocadoraNotFoundException(LocadoraNotFoundException e){
        log.error("Exceção lançada devido Locadora não ter sido encontrada!");
        return e.getMessage();
    }

    @ExceptionHandler(DataInvalidaException.class)
    @ResponseStatus(BAD_REQUEST)
    public String handleDataInvalidaException(DataInvalidaException e){
        return e.getMessage();
    }

    @ExceptionHandler(LocacaoNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleLocacaoNotFoundException(LocacaoNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(UsuarioExistenteException.class)
    @ResponseStatus(CONFLICT)
    public String handleUsuarioExistenteException(UsuarioExistenteException e){
        return e.getMessage();
    }
}
