package com.example.hackaton.reserva.infraestructure;

import com.example.hackaton.reserva.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {


}
