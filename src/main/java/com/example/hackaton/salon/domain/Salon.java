package com.example.hackaton.salon.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idSalon;

    String nombre;

    String ubicacion;

    int capacidad;

    String descripcion;

    @OneToMany(mappedBy = "salon")
    List<SalonEtiqueta> salonEtiquetas;

    @OneToMany(mappedBy = "salon")
    List<Reserva> reservas;
}
