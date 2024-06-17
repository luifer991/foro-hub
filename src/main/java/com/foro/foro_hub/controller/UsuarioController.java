package com.foro.foro_hub.controller;

import com.foro.foro_hub.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ( "/usuarios" )
public class UsuarioController {
    
    @Autowired
    private RegistroUsuarioService registroUsuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ActualizarUsuarioService actualizarUsuarioService;
    
    @PostMapping
    @Transactional
    public ResponseEntity registrar ( @RequestBody @Valid DatosResgistrarUsuario datosUsuario ) {
        var response = registroUsuarioService.registroUsuario( datosUsuario );
        return ResponseEntity.ok( response );
    }
    
    @GetMapping
    public ResponseEntity listarUsuarios () {
        var usuarios = usuarioRepository.findAll().stream().map( DatosUsuario::new );
        return ResponseEntity.ok( usuarios );
    }
    
    @PutMapping ( "/{id}" )
    @Transactional
    public ResponseEntity actualizarUsuario ( @PathVariable Long id,
                                              @RequestBody @Valid DatosActualizarUsuario datosUsuario ) {
        var response = actualizarUsuarioService.actualizarUsuario( id, datosUsuario);
        return ResponseEntity.ok( response );
    }
    
    @DeleteMapping ( "/{id}" )
    public ResponseEntity eliminar ( @PathVariable Long id ) {
        usuarioRepository.deleteById( id );
        return ResponseEntity.noContent().build();
    }
}
