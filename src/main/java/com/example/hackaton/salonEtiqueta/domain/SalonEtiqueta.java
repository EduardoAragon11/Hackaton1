package com.example.hackaton.salonEtiqueta.domain;

import com.example.hackaton.etiqueta.domain.Etiqueta;
import com.example.hackaton.salon.domain.Salon;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SalonEtiqueta {
    @ManyToOne
    Salon salon;

    @ManyToOne
    Etiqueta etiqueta;
}
