package com.jvmaiaa.aluguelcarros.api.exeption;

public class CarroNotFoundException extends RuntimeException {

    public CarroNotFoundException(String message) {
        super(message);
    }

    public CarroNotFoundException(Long id) {
        super(String.format("Carro com id %d não encontrado", id));
    }
}
