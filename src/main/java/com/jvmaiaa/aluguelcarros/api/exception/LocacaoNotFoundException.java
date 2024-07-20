package com.jvmaiaa.aluguelcarros.api.exception;

public class LocacaoNotFoundException extends RuntimeException {

    public LocacaoNotFoundException(String message) {
        super(message);
    }

    public LocacaoNotFoundException(Long id) {
        super(String.format("A locação com Id: %d não foi encontrada.", id));
    }
}
