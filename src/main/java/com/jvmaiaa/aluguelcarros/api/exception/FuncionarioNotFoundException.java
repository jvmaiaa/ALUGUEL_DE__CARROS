package com.jvmaiaa.aluguelcarros.api.exception;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(String message) {
        super(message);
    }

    public FuncionarioNotFoundException(Long id) {
        super(String.format("Funcionário com id %d não encontrado", id));
    }
}
