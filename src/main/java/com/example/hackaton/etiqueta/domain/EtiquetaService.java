package com.example.hackaton.etiqueta.domain;

import com.example.hackaton.etiqueta.infrastructure.EtiquetaRepository;
import com.example.hackaton.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    @Autowired
    EtiquetaRepository etiquetaRepository;

    public List<Etiqueta> getAllEtiquetaa() {
        return etiquetaRepository.findAll();

    }

    public void postEtiqueta(EtiquetaDto dto) {
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setNombre(dto.getNombre());
        etiquetaRepository.save(etiqueta);
    }

    public void updateEtiqueta(Integer id, EtiquetaDto dto) {
        Etiqueta etiqueta = etiquetaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La etiqueta no existe"));
        etiqueta.setNombre(dto.getNombre());
        etiquetaRepository.save(etiqueta);
    }

    public void deleteEtiqueta(Integer id) {
        etiquetaRepository.deleteById(id);
    }


}
