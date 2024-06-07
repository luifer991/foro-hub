package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.Cursos;
import com.foro.foro_hub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        Usuario usuarioId,
        Cursos curso
) {
}
