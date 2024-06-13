package com.foro.foro_hub.domain.topic;

import com.foro.foro_hub.domain.curso.Curso;
import com.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table ( name = "topicos" )
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode ( of = "id" )
public class Topico {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    @Enumerated ( EnumType.STRING )
    private Status status;
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "usuario_id" )
    private Usuario usuario;
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "curso_id" )
    private Curso curso;
    //    @ManyToOne ( fetch = FetchType.LAZY )
    //    @JoinColumn ( name = "respuesta_id" )
    //    private Respuesta respuestas;
    
    public void actualizarTopico ( DatosActualizarTopico datos ) {
        if ( datos.titulo() != null ) {
            this.titulo = datos.titulo();
        }
        if ( datos.mensaje() != null ) {
            this.mensaje = datos.mensaje();
        }
        if ( datos.fecha() == null ) {
            this.fecha = LocalDateTime.now();
        }
        if ( datos.status() == null ) {
            this.status = Status.UPDATED;
        }
    }
}
