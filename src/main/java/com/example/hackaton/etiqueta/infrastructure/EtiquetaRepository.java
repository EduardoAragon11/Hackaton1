package com.example.hackaton.etiqueta.infrastructure;

import com.example.hackaton.etiqueta.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
}
