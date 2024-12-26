package com.systems.backendCasuarinas.repository;

import com.systems.backendCasuarinas.entity.LoginResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginResult, Long> {

    /*@Query(value = "SELECT * from mantenimiento.f_sp_val_login(:aioNuResult, :asoDeResult, :aioIdUsuario, :asoDeRol, :aioIdHabitante, :asoDeHabitante, :asDeUsuario, :asDeClave)", nativeQuery = true)
    List<Object[]> validateLogin(
        @Param("aioNuResult") Integer aioNuResult,
        @Param("asoDeResult") String asoDeResult,
        @Param("aioIdUsuario") Integer aioIdUsuario,
        @Param("asoDeRol") String asoDeRol,
        @Param("aioIdHabitante") Integer aioIdHabitante,
        @Param("asoDeHabitante") String asoDeHabitante,
        @Param("asDeUsuario") String asDeUsuario,
        @Param("asDeClave") String asDeClave
    );*/
    @Query(value = "SELECT * from mantenimiento.f_sp_val_login(:asDeUsuario, :asDeClave)", nativeQuery = true)
    List<Object[]> validateLogin(
        @Param("asDeUsuario") String asDeUsuario,
        @Param("asDeClave") String asDeClave
    );
}
