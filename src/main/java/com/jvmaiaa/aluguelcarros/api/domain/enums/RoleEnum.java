package com.jvmaiaa.aluguelcarros.api.domain.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    FUNCIONARIO("funcionario"),
    CLIENTE("cliente");

    private String role;

    RoleEnum(String role){
        this.role = role;
    }
}
