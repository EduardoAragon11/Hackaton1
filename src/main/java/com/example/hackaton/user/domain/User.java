package com.example.hackaton.user.domain;

import com.example.hackaton.reserva.domain.Reserva;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String nombre;

    @Column(nullable = false)
    String telefono;

    @Column(nullable = false)
    String password;

    @OneToMany
    private List<Reserva> reservas;

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername(){return this.email;}


    @Override
    public boolean isAccountNonExpired(){return true;};

    @Override
    public boolean isAccountNonLocked(){return true;};

    @Override
    public boolean isCredentialsNonExpired(){return true;};

    @Override
    public boolean isEnabled(){return true;};

    @Override
    public String getPassword(){return "no";}
}
