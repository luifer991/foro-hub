package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.CursoRepository;
import com.foro.foro_hub.domain.usuario.UsuarioRepository;
import com.foro.foro_hub.infra.errors.ValidationExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActualizarTopicoService {
    
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    
    public DatosRespuestaTopico actualizar ( Long id, DatosActualizarTopico datos ) {
        
        if ( topicoRepository.findByTitulo( datos.titulo() ).isPresent() ) {
            throw new ValidationExist( "El titulo ya existe" );
        }
        
        if ( topicoRepository.findByMensaje( datos.mensaje() ).isPresent() ) {
            throw new ValidationExist( "El mensaje ya existe" );
        }
        
        var actualizacionTopico = topicoRepository.getReferenceById( id );
        actualizacionTopico.actualizarTopico( datos );
        
        return new DatosRespuestaTopico( actualizacionTopico );
    }
}
