package com.jvmaiaa.aluguelcarros.api.domain.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
