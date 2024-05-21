package com.example.hackaton.salon.domain;

import com.example.hackaton.etiqueta.domain.Etiqueta;
import com.example.hackaton.reserva.domain.Reserva;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idSalon;

    String nombre;

    String ubicacion;

    Integer capacidad;

    String descripcion;

    @ManyToMany
    List<Etiqueta> etiquetas;

    @OneToMany
    List<Reserva> reservas;
}
