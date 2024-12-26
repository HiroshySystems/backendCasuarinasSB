package com.systems.backendCasuarinas.service;

import com.systems.backendCasuarinas.dto.UserDTO;
import com.systems.backendCasuarinas.entity.UserResult;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    
    UserResult getLoginUser();
    //ResultAll registerUser(UserDTO userDTO);
    
}
