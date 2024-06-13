package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.DatosCurso;
import com.foro.foro_hub.domain.usuario.DatosUsuario;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        DatosUsuario usuario,
        DatosCurso curso,
        Status status
) {
    public DatosListadoTopico ( Topico topico ) {
        this( topico.getId(),
                topico.getTitulo(), topico.getMensaje(),
                topico.getFecha(),
                new DatosUsuario( topico.getUsuario() ),
                new DatosCurso( topico.getCurso() ), topico.getStatus() );
    }
}
