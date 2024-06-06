package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.Curso;
import com.foro.foro_hub.domain.response.Respuesta;
import com.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // one to many
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuesta_id")
    private Respuesta respuestas;
}
