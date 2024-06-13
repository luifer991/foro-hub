package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.CursoRepository;
import com.foro.foro_hub.domain.usuario.UsuarioRepository;
import com.foro.foro_hub.infra.errors.ValidationExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroTopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    
    public DatosRespuestaTopico registrar ( DatosRegistroTopico datos ) {
        
        if ( ! cursoRepository.findById( datos.idCurso() ).isPresent() ) {
            throw new ValidationExist( "El curso no existe" );
        }
        
        if ( topicoRepository.findByTitulo( datos.titulo() ).isPresent() ) {
            throw new ValidationExist( "El titulo ya existe" );
        }
        
        if ( topicoRepository.findByMensaje( datos.mensaje() ).isPresent() ) {
            throw new ValidationExist( "El mensaje ya existe" );
        }
        
        var usuario = usuarioRepository.findById( datos.idUsuario() ).get();
        var curso = cursoRepository.findById( datos.idCurso() ).get();
        var fecha = LocalDateTime.now();
        var status = Status.NUEVO;
        
        var topico = new Topico ( null, datos.titulo(), datos.mensaje(), fecha, status, usuario, curso );
        
        topicoRepository.save ( topico );
        
        return new DatosRespuestaTopico ( topico );
    }
}
