package com.systems.backendCasuarinas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.systems.backendCasuarinas.enums.UserRole;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    //generic
    private int status;
    private String message;
    //for login
    private String token;
    private UserRole role;
    private String expirationTime;
    
    private Integer NuResult;
    private String DeResult;

    private final LocalDateTime timestamp = LocalDateTime.now();

}
