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
@Table (name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @JoinColumn(name = "topico_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;
    private LocalDateTime fecha;
    @JoinColumn(name = "usuario_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    private Boolean solucion;
}
