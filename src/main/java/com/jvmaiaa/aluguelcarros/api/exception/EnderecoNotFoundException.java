package com.jvmaiaa.aluguelcarros.api.exception;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(String message){
        super(message);
    }

    public EnderecoNotFoundException(Long id){
        super(String.format("Pessoa com id %d não encontrada", id));
    }
}
