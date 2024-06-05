package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.Curso;
import com.foro.foro_hub.domain.response.Respuesta;
import com.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status; // estado del topico TODO: hacer un enum
    private Usuario autor; // one to many
    private Curso curso; // one to one
    private Respuesta respuestas;
}
