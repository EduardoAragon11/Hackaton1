package com.example.hackaton.salon.infrastructure;

import com.example.hackaton.salon.domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Integer> {
}
