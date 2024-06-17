package com.foro.foro_hub.domain.usuario;

public record DatosActualizarUsuario(
        String login,
        String email,
        String password
) {
}
