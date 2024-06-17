package com.foro.foro_hub.domain.usuario;

import com.foro.foro_hub.domain.profile.Perfil;
import com.foro.foro_hub.domain.profile.PerfilRepository;
import com.foro.foro_hub.infra.errors.ValidationExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistroUsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public DatosRespuestaUsuario registroUsuario ( DatosResgistrarUsuario registro ) {
        
//        if ( repository.findByLogin( registro.login() ) ) {
//            throw new ValidationExist( "El nombre de usuario ya existe" );
//        }
//
//        if ( repository.findByEmail( registro.email() ) ) {
//            throw new ValidationExist( "El email ya existe" );
//        }
        
        var perfilId =  perfilRepository.findById( registro.perfilId() ).get();
        
        var password = passwordEncoder.encode( registro.password() );
        
        var usuario = new Usuario( null, registro.login(), registro.email(), password, perfilId );
        repository.save( usuario );
        
        return new DatosRespuestaUsuario( usuario );
    }
}
