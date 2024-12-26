package com.systems.backendCasuarinas.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Usuario es requerido")
    private String usuario;
    @NotBlank(message = "Password es requerido")
    private String password;

}
