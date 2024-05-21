package com.example.hackaton.etiqueta.domain;

import com.example.hackaton.salon.domain.Salon;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idEtiqueta;

    String nombre;

    @ManyToMany
    List<Salon> salones;
}
