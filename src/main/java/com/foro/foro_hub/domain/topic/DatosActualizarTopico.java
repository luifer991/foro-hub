package com.foro.foro_hub.domain.topic;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Status status
) {
    public DatosActualizarTopico ( Topico topico ) {
        this( topico.getTitulo(), topico.getMensaje(), LocalDateTime.now(), Status.UPDATED );
    }
}
