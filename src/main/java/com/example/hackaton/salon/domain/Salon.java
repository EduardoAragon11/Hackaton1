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
    int idSalon;

    String nombre;

    String ubicacion;

    int capacidad;

    String descripcion;

    @ManyToMany(mappedBy = "salones")
    List<Etiqueta> etiquetas;

    @OneToMany(mappedBy = "salon")
    List<Reserva> reservas;
}
