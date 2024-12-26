package com.systems.backendCasuarinas.service;

import com.systems.backendCasuarinas.dto.LoginResponseDTO;
import com.systems.backendCasuarinas.dto.UserDTO;
import com.systems.backendCasuarinas.entity.LoginRequest;
import com.systems.backendCasuarinas.entity.ResultAll;

public interface LoginService {
    LoginResponseDTO validateLogin(LoginRequest loginRequest);
    ResultAll registerUser(UserDTO userDTO);
}
