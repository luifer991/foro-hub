package com.foro.foro_hub.domain.usuario;

import com.foro.foro_hub.domain.profile.Perfil;

public record DatosRespuestaUsuario(
        Long id, String login, String email, Long perfilId
) {
    public DatosRespuestaUsuario ( Usuario usuario ) {
        this(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getEmail(),
                usuario.getPerfil().getId()
        );
    }
}
