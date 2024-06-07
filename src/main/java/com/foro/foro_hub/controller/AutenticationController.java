package com.foro.foro_hub.controller;

import com.foro.foro_hub.domain.usuario.DatosAutenticacionUsuario;
import com.foro.foro_hub.domain.usuario.Usuario;
import com.foro.foro_hub.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity loginUsuario (
            @RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario ) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.login(), datosAutenticacionUsuario.password()
        );
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTToken = tokenService.generarToken( ( Usuario ) usuarioAutenticado.getPrincipal() );
        return ResponseEntity.ok(new DatosJWTToken(JWTToken));
    }
    
    private record DatosJWTToken( String jwtToken ) {
    }
}
