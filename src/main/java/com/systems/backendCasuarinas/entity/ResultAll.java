package com.systems.backendCasuarinas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder

public class ResultAll {
    
    private Integer status;
    @Id
    private Integer codigo;  
    
    private String mensaje;
    
    
}
