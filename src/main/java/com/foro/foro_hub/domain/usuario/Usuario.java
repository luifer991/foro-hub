package com.foro.foro_hub.domain.usuario;

import com.foro.foro_hub.domain.profile.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String password;
    @JoinColumn(name = "perfil_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Perfil perfil;
}
