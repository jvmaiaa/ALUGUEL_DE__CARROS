package com.jvmaiaa.aluguelcarros.api.exeption;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(Long id){
        super(String.format("Cliente com id %d não encontrada" + id));
    }
}
