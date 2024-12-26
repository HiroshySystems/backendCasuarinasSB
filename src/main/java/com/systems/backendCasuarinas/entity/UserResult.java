package com.systems.backendCasuarinas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.validation.constraints.Null;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@NamedStoredProcedureQuery(
                            name = "f_view_usuarios",
                            procedureName = "mantenimiento.f_view_usuarios")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResult {
    @Null
    private String de_habitante;
    
    @Id
    private String de_alias;  
    
    private String de_clave;
    
    @Null
    private String de_rol;

    private String st_activo;
    
    @Null
    private String de_usuario_reg;
    
    @Null
    private LocalDateTime  fe_reg;
    
    @Null
    private String de_usuario_upd;
    
    @Null
    private LocalDateTime  fe_upd;
    
    private Integer id_usuario;
    
    private Integer id_habitante;
    
    private Integer id_rol;
    
    
    
    
}