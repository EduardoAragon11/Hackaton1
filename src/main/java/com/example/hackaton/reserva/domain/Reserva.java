package com.example.hackaton.reserva.domain;

import com.example.hackaton.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", nullable=false)
    private long idReserva;

    Date fecha;

    Time horaInicio;

    Time horaFin;

    @ManytoOne(cascade = CascadeType.ALL)
    User user;
    // @OnetoMany para user

    @ManyToOne(cascade = CascadeType.ALL)
    Salon salon;

}
