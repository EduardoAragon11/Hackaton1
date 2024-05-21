package com.example.hackaton.etiqueta.application;

import com.example.hackaton.etiqueta.domain.Etiqueta;
import com.example.hackaton.etiqueta.domain.EtiquetaDto;
import com.example.hackaton.etiqueta.domain.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    EtiquetaService etiquetaService;

    @PostMapping("/etiquetas")
    ResponseEntity<Void> createEtiqueta(@RequestBody EtiquetaDto dto) {
        etiquetaService.postEtiqueta(dto);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/etiquetas")
    ResponseEntity<List<Etiqueta>> getAllEtiqueta() {
        List<Etiqueta> etiquetas =  etiquetaService.getAllEtiquetaa();
        return ResponseEntity.ok(etiquetas);
    }

    @PutMapping("/etiquetas/{id}")
    ResponseEntity<Void> changeEtiqueta(@PathVariable Integer id, @RequestBody EtiquetaDto dto) {
        etiquetaService.updateEtiqueta(id, dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/etiquetas/{id}")
    ResponseEntity<Void> deleteEtiquetas(@PathVariable Integer id) {
        etiquetaService.deleteEtiqueta(id);
        return ResponseEntity.noContent().build();
    }

}
