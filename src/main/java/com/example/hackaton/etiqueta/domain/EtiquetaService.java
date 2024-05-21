package com.example.hackaton.etiqueta.domain;

import com.example.hackaton.etiqueta.infrastructure.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaService {

    @Autowired
    EtiquetaRepository etiquetaRepository;
}
