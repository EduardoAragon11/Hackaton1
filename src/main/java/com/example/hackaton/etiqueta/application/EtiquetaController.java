package com.example.hackaton.etiqueta.application;

import com.example.hackaton.etiqueta.domain.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    EtiquetaService etiquetaService;
}
