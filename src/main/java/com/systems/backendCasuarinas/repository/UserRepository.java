package com.systems.backendCasuarinas.repository;

import com.systems.backendCasuarinas.entity.UserResult;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserResult, Long>{
    @Query(value = "SELECT * from mantenimiento.f_view_usuarios()", nativeQuery = true)
    List<Object[]> fViewUsuarios();
    
    @Query(value = "SELECT * from mantenimiento.f_get_user_x_alias(:asDeUsuario)", nativeQuery = true)
    Optional<UserResult> findByDeAlias(@Param("asDeUsuario") String asDeUsuario);
 
    @Query(value = "SELECT * from mantenimiento.f_sp_save_user(:aiIdHabitante,:aiIdRol,:asDeAlias,:asDeClave,:asStActivo,:idUsuarioReg)", nativeQuery = true)
    List<Object[]> f_sp_save_user(        
        @Param("aiIdHabitante") Integer aiIdHabitante,        
        @Param("aiIdRol") Integer aiIdRol,
        @Param("asDeAlias") String asDeAlias,
        @Param("asDeClave") String asDeClave,
        @Param("asStActivo") String asStActivo,
        @Param("idUsuarioReg") Integer idUsuarioReg
    );  
     
}

