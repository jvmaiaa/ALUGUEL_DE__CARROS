package com.jvmaiaa.aluguelcarros.api.exeption;

import org.hibernate.metamodel.spi.RuntimeModelCreationContext;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(String message) {
        super(message);
    }

    public FuncionarioNotFoundException(Long id) {
        super(String.format("Funcionário com id %d não encontrado", id));
    }
}
