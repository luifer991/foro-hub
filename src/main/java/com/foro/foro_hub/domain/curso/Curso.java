package com.foro.foro_hub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Cursos nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    public Curso ( Cursos nombre ) {
        this.nombre = Cursos.valueOf( getNombre().toString() );
        this.categoria = Categoria.valueOf( getNombre().toString() );
    }
    
    public Curso ( DatosCurso curso ) {
        this.id = curso.cursoId();
    }
    
    public Curso ( Long aLong ) {
        this.id = aLong;
    }
}
