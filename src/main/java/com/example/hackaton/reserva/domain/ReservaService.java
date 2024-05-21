package com.example.hackaton.reserva.domain;

import com.example.hackaton.etiqueta.domain.Etiqueta;
import com.example.hackaton.etiqueta.infrastructure.EtiquetaRepository;
import com.example.hackaton.exceptions.ResourceNotFoundException;
import com.example.hackaton.reserva.infraestructure.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva ListarReserva(){
        return (Reserva) reservaRepository.findAll();
    }

    public void CreateReserva(Reserva reserva){
        reservaRepository.save(reserva);
    }

    public void DeleteReserva(Long id){
        reservaRepository.deleteById(id);
    }

    public void PutReserva(Long Id){
        /* Reserva reserva = reservaRepository.findById(Id);
        reservaRepository.save(reserva);  no funciona */
    }

}
