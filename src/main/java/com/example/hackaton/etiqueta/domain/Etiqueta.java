package com.example.hackaton.etiqueta.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idEtiqueta;

    String nombre;

    @OneToMany(mappedBy = "etiqueta")
    List<SalonEtiqueta> salonEtiquetas;
}
