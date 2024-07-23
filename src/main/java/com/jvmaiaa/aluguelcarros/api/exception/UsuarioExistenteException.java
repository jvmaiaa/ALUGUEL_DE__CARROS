package com.jvmaiaa.aluguelcarros.api.exception;

public class UsuarioExistenteException extends RuntimeException {

    public UsuarioExistenteException(String message) {
        super(message);
    }
}
