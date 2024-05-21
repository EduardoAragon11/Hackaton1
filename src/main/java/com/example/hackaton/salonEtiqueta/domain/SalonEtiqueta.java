package com.example.hackaton.salonEtiqueta.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class SalonEtiqueta {
    @ManyToOne
    Salon salon;

    @ManyToOne
    Etiqueta etiqueta;
}
