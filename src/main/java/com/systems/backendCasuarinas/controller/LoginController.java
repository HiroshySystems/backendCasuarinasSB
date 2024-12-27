package com.systems.backendCasuarinas.controller;

import com.systems.backendCasuarinas.dto.LoginResponseDTO;
import com.systems.backendCasuarinas.dto.UserDTO;
import com.systems.backendCasuarinas.entity.LoginRequest;
import com.systems.backendCasuarinas.entity.ResultAll;
import com.systems.backendCasuarinas.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    //private final UserService userService;
    
    /*@PostMapping("/validate")
    public ResponseEntity<LoginResponseDTO> validateLogin(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            LoginResponseDTO response = loginService.validateLogin(loginRequest.getUsuario(), loginRequest.getPassword());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }*/
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.validateLogin(loginRequest));
    }

    @GetMapping('hola')
    public ResponseEntity<String> hola() {
        return ResponseEntity.ok("hola");
    }
    
    @PostMapping("/register")
    public ResponseEntity<ResultAll> createUser(@RequestBody @Valid UserDTO userDTO) {
        //ResultAll result = loginService.registerUser(userDTO);
        return ResponseEntity.ok(loginService.registerUser(userDTO));
    }
}
