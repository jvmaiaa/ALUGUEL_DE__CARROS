package com.jvmaiaa.aluguelcarros.api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(EnderecoNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleEnderecoNotFoundException(EnderecoNotFoundException e){
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
        return e.getMessage();
    }


}
