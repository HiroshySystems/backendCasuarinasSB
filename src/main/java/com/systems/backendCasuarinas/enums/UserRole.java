package com.systems.backendCasuarinas.enums;

public enum UserRole {
    ADMINISTRADOR("Administrador"),
    DELEGADO("Delegado"),
    INVITADO("Invitado"),
    NINGUNO("Ninguno");
    
    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
