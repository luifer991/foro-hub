package com.foro.foro_hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosResgistrarUsuario(
        @NotBlank
        String login,
        @NotBlank
        String email,
        @NotNull
        String password,
        Long perfilId
) {
}
