package com.foro.foro_hub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    @Query ( "SELECT u FROM Usuario u WHERE u.login = :username" )
    UserDetails findByLoginUSer ( @Param ( "username" ) String username );
    
}