package com.foro.foro_hub.domain.response;

import com.foro.foro_hub.domain.topic.Topico;
import com.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table (name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private Topico topico; // one to many
    private LocalDateTime fechaCreacion;
    private Usuario usuario; // many to many
    private String solucion;
}
