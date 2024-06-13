package com.foro.foro_hub.domain.topic;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Long idUsuario,
        Long idCurso,
        Status status
) {
    public DatosRespuestaTopico ( Topico topico ) {
        this(topico.getId(),
                topico.getTitulo(), topico.getMensaje(),
                topico.getUsuario().getId(),
                topico.getCurso().getId(), topico.getStatus());
    }
}
