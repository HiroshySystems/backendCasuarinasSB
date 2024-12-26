package com.systems.backendCasuarinas.service.impl;

import com.systems.backendCasuarinas.dto.LoginResponseDTO;
import com.systems.backendCasuarinas.dto.UserDTO;
import com.systems.backendCasuarinas.entity.LoginRequest;
import com.systems.backendCasuarinas.entity.ResultAll;
import com.systems.backendCasuarinas.enums.UserRole;
import com.systems.backendCasuarinas.repository.LoginRepository;
import com.systems.backendCasuarinas.repository.UserRepository;
import com.systems.backendCasuarinas.security.JwtUtils;
import com.systems.backendCasuarinas.service.LoginService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    
    private LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private final JwtUtils jwtUtils;
    
    @Autowired
    public void setLoginRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public LoginResponseDTO validateLogin(LoginRequest loginRequest) {
        
        List<Object[]> result = loginRepository.validateLogin(loginRequest.getUsuario(), loginRequest.getPassword()
        );                
        
        if (!result.isEmpty()) {
            Object[] row = result.get(0);
            LoginResponseDTO dto = new LoginResponseDTO();
            
            String token = jwtUtils.generateToken(loginRequest.getUsuario());
            
            dto.setStatus(200);
            dto.setCodigo((Integer) row[0]);
            dto.setMensaje((String) row[1]);
            dto.setIdUsuario((Integer) row[2]);
            dto.setRol(UserRole.valueOf((String) row[3].toString().toUpperCase()));
            dto.setIdHabitante((Integer) row[4]);
            dto.setDeHabitante((String) row[5]);
            
            if (dto.getCodigo()==1) {
                dto.setToken(token);
            }                
            
            return dto;
        }
        
        throw new RuntimeException("No se encontraron resultados");
    }
    
    @Override
    public ResultAll registerUser(UserDTO userDTO) {
        Integer IdRol = 2;
        
        UserDTO userToSave = UserDTO.builder()
                .de_alias(userDTO.getDe_alias())
                .de_clave(userDTO.getDe_clave())
                .id_habitante(userDTO.getId_habitante())
                .st_activo(userDTO.getSt_activo())
                .id_rol(IdRol)
                .build();
        
        List<Object[]> result = userRepository.f_sp_save_user(
                userToSave.getId_habitante(),
                userToSave.getId_rol(),
                userToSave.getDe_alias(),
                userToSave.getDe_clave(),
                userToSave.getSt_activo(),
                1);
        
        if (!result.isEmpty()) {
            Object[] row = result.get(0);
            return ResultAll.builder()
                    .status(200)
                    .codigo((Integer) row[0])
                    .mensaje((String) row[1])
                    .build();
        }
        throw new RuntimeException("Error al registrar el Usuario");
    }
}
