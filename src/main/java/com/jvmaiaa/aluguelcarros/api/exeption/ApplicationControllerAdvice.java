package com.jvmaiaa.aluguelcarros.api.exeption;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(EnderecoNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleEnderecoNotFoundException(EnderecoNotFoundException e){
        return e.getMessage();
    }

}
