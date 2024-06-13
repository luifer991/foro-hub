package com.foro.foro_hub.domain.usuario;

import com.foro.foro_hub.domain.profile.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Usuario implements UserDetails { //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String password;
    @JoinColumn(name = "perfil_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Perfil perfil;
    
    
    public Usuario ( Long id ) {
        this.id = id;
    }

    public Usuario ( String login ) {
        this.login = getLogin();
    }

    @Override
    public Collection <? extends GrantedAuthority> getAuthorities () {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername () {
        return login;
    }

    @Override
    public String getPassword () {
        return password;
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return true;
    }
}
