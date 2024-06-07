package com.foro.foro_hub.domain.usuario;

import com.foro.foro_hub.domain.profile.Perfil;
import jakarta.validation.constraints.Pattern;

public record DatosAutenticacionUsuario(
        String login,
        String password
) {
}
