package com.systems.backendCasuarinas.service.impl;

import com.systems.backendCasuarinas.dto.UserDTO;
import com.systems.backendCasuarinas.entity.UserResult;
import com.systems.backendCasuarinas.exceptions.NotFoundException;
import com.systems.backendCasuarinas.repository.UserRepository;
import com.systems.backendCasuarinas.security.JwtUtils;
import com.systems.backendCasuarinas.service.UserService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtils jwtUtils;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<Object[]> result = userRepository.fViewUsuarios();

        if (!result.isEmpty()) {
            List<UserDTO> dtoList = new ArrayList<>();

            for (Object[] row : result) {
                UserDTO dto = new UserDTO();

                dto.setDe_habitante((String) row[0]);
                dto.setDe_alias((String) row[1]);
                dto.setDe_clave((String) row[2]);
                dto.setDe_rol((String) row[3]);
                dto.setSt_activo((String) row[4]);
                dto.setDe_usuario_reg((String) row[5]);
                dto.setFe_reg(((Timestamp) row[6]).toLocalDateTime()); // Conversión de Timestamp a LocalDateTime
                dto.setDe_usuario_upd((String) row[7]);
                if (row[8] != null) {
                    dto.setFe_upd(((Timestamp) row[8]).toLocalDateTime());
                } else {
                    dto.setFe_upd(null); // Asigna null si el valor es null
                }
                dto.setId_usuario((Integer) row[9]);
                dto.setId_habitante((Integer) row[10]);
                dto.setId_rol((Integer) row[11]);

                dtoList.add(dto);
            }
            return dtoList;
        }

        throw new RuntimeException("No se encontraron resultados");
    }

    @Override
    public UserResult getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuario = authentication.getName();
        System.out.println("usuario login: "+usuario);
        UserResult user = userRepository.findByDeAlias(usuario)
                .orElseThrow(()->new NotFoundException("Usuario no encontrado"));
        
        return user;
    }

}
