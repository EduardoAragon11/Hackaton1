package com.example.hackaton.etiqueta.domain;

import com.example.hackaton.salonEtiqueta.domain.SalonEtiqueta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
