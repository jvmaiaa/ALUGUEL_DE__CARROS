package com.jvmaiaa.aluguelcarros.api.exception;

public class LocadoraNotFoundException extends RuntimeException {

    public LocadoraNotFoundException(String message) {
        super(message);
    }

    public LocadoraNotFoundException(Long id){
        super(String.format("A locadora com Id %d não foi encontrada!", id));
    }
}
