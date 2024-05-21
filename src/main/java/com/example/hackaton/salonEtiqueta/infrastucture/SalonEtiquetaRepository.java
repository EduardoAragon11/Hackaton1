package com.example.hackaton.salonEtiqueta.infrastucture;

import com.example.hackaton.salonEtiqueta.domain.SalonEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonEtiquetaRepository extends JpaRepository<SalonEtiqueta, Long> {

}
