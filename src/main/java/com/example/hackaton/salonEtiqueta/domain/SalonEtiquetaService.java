package com.example.hackaton.salonEtiqueta.domain;

import com.example.hackaton.salonEtiqueta.infrastucture.SalonEtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalonEtiquetaService {
    @Autowired
    private SalonEtiquetaRepository salonEtiquetaRepository;
}
