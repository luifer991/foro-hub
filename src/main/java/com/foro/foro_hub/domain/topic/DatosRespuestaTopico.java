package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.Curso;
import com.foro.foro_hub.domain.curso.Cursos;
import com.foro.foro_hub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Usuario usuario,
        Curso curso,
        Status status
) {
}
