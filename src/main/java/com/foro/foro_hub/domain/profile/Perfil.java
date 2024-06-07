package com.foro.foro_hub.domain.profile;

import com.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a user profile entity in the application.
 */
@Entity
@Table(name = "perfiles")
@Getter
@Setter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;



    /**
     * Constructs a new Perfil instance with a default nombre value.
     */
    public Perfil() {
        this.nombre = "ROLE_USER";
    }

    /**
     * Constructs a new Perfil instance with the specified nombre.
     *
     * @param nombre The nombre for the profile.
     */
    public Perfil(String nombre) {
        this.nombre = nombre;
    }
}

