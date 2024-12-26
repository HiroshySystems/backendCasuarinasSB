package com.systems.backendCasuarinas.dto;

import com.systems.backendCasuarinas.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Integer status;
    private Integer codigo;
    private String mensaje;
    private Integer idUsuario;
    private UserRole rol;
    private Integer idHabitante;
    private String deHabitante;
    
    /*@NotBlank(message = "Usuario es requerido")
    private String deUsuario;
    @NotBlank(message = "Password es requerido")
    private String deClave;*/
    
    private String token;
}
