package com.example.hackaton.salon.domain;

import com.example.hackaton.etiqueta.domain.Etiqueta;
import com.example.hackaton.etiqueta.infrastructure.EtiquetaRepository;
import com.example.hackaton.exceptions.ResourceNotFoundException;
import com.example.hackaton.salon.infrastructure.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    EtiquetaRepository etiquetaRepository;

    public List<Salon> getSalones() {
        return salonRepository.findAll();
    }

    public void createSalon(Salon salon) {
        salonRepository.save(salon);
    }

    public void actualizarSalon(Salon salon, Integer id) {
        salon.setIdSalon(salonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado")).getIdSalon());
        salonRepository.save(salon);
    }

    public void borrarSalon(Integer id) {
        salonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado"));
        salonRepository.deleteById(id);
    }

    public void crearAsociacion(Integer idSalon, Integer idEtiqueta) {
        Salon salon = salonRepository.findById(idSalon).orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado"));
        Etiqueta etiqueta = etiquetaRepository.findById(idEtiqueta).orElseThrow(() -> new ResourceNotFoundException("Etiqueta no encontrada"));
        salon.getEtiquetas().add(etiqueta);
        etiqueta.getSalones().add(salon);
        salonRepository.save(salon);
        etiquetaRepository.save(etiqueta);
    }

    public void borrarAsociacion(Integer idSalon, Integer idEtiqueta) {
        Salon salon = salonRepository.findById(idSalon).orElseThrow(() -> new ResourceNotFoundException("Salon no encontrado"));
        Etiqueta etiqueta = etiquetaRepository.findById(idEtiqueta).orElseThrow(() -> new ResourceNotFoundException("Etiqueta no encontrada"));
        salon.getEtiquetas().remove(etiqueta);
        etiqueta.getSalones().remove(salon);
        salonRepository.save(salon);
        etiquetaRepository.save(etiqueta);
    }
}
