package com.example.hackaton.reserva.domain;

import com.example.hackaton.salon.domain.Salon;
import com.example.hackaton.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", nullable=false)
    private long idReserva;

    Date fecha;

    LocalDateTime horaInicio;

    LocalDate horaFin;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;
    // @OnetoMany para user

    @ManyToOne(cascade = CascadeType.ALL)
    Salon salon;


}
