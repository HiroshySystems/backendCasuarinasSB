package com.systems.backendCasuarinas.entity;

import com.systems.backendCasuarinas.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@NamedStoredProcedureQuery(
                            name = "f_sp_val_login",
                            procedureName = "mMantenimiento.f_val_login",
                            parameters = {
                                            @StoredProcedureParameter(mode=ParameterMode.IN,name="p_de_alias",type = String.class),
                                            @StoredProcedureParameter(mode = ParameterMode.IN,name="p_de_clave",type=String.class)
                            })
@Data
public class LoginResult {
    
    private Integer status;
    
    private Integer codigo;
    
    private String mensaje;
    
    @Id
    private Integer idUsuario;
    
    @Enumerated(EnumType.STRING) 
    private UserRole rol;
    
    private Integer idHabitante;
    
    private String deUsuario ;
}
