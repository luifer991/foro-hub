package com.foro.foro_hub.domain.usuario;

public record DatosUsuario(
        Long Id, String nombre
) {
    public DatosUsuario ( Usuario usuario ) {
        this ( usuario.getId(),  usuario.getLogin());
    }
}
