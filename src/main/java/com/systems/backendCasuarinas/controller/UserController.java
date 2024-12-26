package com.systems.backendCasuarinas.controller;

import com.systems.backendCasuarinas.dto.UserDTO;
import com.systems.backendCasuarinas.entity.UserResult;
import com.systems.backendCasuarinas.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> listarUser() {
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }
    
    @GetMapping("/usuarioLogueado")
    public ResponseEntity<UserResult> getCurrentUser() {
        return ResponseEntity.ok(userService.getLoginUser());
    }
}
