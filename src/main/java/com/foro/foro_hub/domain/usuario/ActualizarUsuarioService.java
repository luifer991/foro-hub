package com.foro.foro_hub.domain.usuario;

import com.foro.foro_hub.infra.errors.ValidationExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActualizarUsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    public DatosRespuestaUsuario actualizarUsuario ( Long id, DatosActualizarUsuario datos ) {
        if ( repository.findByLogin( datos.login() ).isPresent() ) {
            throw new ValidationExist( "El nombre de usuario ya existe" );
        }
        
        if ( repository.findByEmail( datos.email() ).isPresent() ) {
            throw new ValidationExist( "El email ya existe" );
        }
        
        var actualizarUsuario = repository.getReferenceById( id );
        actualizarUsuario.actualizarUsuario( datos );
        
        return new DatosRespuestaUsuario( actualizarUsuario );
    }
}
