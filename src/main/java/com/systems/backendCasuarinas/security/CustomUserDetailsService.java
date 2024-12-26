package com.systems.backendCasuarinas.security;

import com.systems.backendCasuarinas.entity.UserResult;
import com.systems.backendCasuarinas.exceptions.NotFoundException;
import com.systems.backendCasuarinas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String de_alias) throws UsernameNotFoundException {
        System.out.println("Custom: "+de_alias);
        UserResult user = userRepository.findByDeAlias(de_alias)
                .orElseThrow(()-> new NotFoundException("Alias de Usuario no encontrado"));

        return AuthUser.builder()
                .user(user)
                .build();
    }
}
