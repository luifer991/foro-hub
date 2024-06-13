package com.foro.foro_hub.domain.curso;

public record DatosCurso(
        Long cursoId,
        Cursos nombre
) {
    public DatosCurso ( Curso curso ) {
        this ( curso.getId(), curso.getNombre() );
    }
}
