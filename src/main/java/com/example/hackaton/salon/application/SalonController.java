package com.example.hackaton.salon.application;

import com.example.hackaton.salon.domain.Salon;
import com.example.hackaton.salon.domain.SalonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salones")
public class SalonController {

    @Autowired
    SalonService salonService;

    @GetMapping
    ResponseEntity<List<Salon>> getSalones() {
        List<Salon> salones = salonService.getSalones();
        return ResponseEntity.ok(salones);
    }

    @PostMapping
    ResponseEntity<Void> createSalon(@RequestBody Salon salon) {
        salonService.createSalon(salon);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> actualizarSalon(@PathParam("id") Integer id, @RequestBody Salon salon) {
        salonService.actualizarSalon(salon, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> borrarSalon(@PathParam("id") Integer id) {
        salonService.borrarSalon(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idSalon}/etiquetas/{idEtiqueta}")
    ResponseEntity<Void> crearAsociacion(@PathParam("idSalon") Integer idSalon, @PathParam("idEtiqueta") Integer idEtiqueta) {
        salonService.crearAsociacion(idSalon, idEtiqueta);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{idSalon}/etiquetas/{idEtiqueta}")
    ResponseEntity<Void> borrarAsociacion(@PathParam("idSalon") Integer idSalon, @PathParam("idEtiqueta") Integer idEtiqueta) {
        salonService.borrarAsociacion(idSalon, idEtiqueta);
        return ResponseEntity.noContent().build();
    }

}
