package com.example.hackaton.reserva.application;

import com.example.hackaton.reserva.domain.Reserva;
import com.example.hackaton.reserva.domain.ReservaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")

public class ReservaController {

    @Autowired
    ReservaService reservaService;

    //GET /reservas
    @GetMapping()
    public ResponseEntity<Reserva> ListarReserva(){
        return ResponseEntity.ok(reservaService.ListarReserva());
    }

    //POST /reservas
    @PostMapping()
    public ResponseEntity<Void> CreateReserva(@RequestBody Reserva reserva){
        reservaService.CreateReserva(reserva);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //PUT /reservas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> UpdateReserva(@PathVariable Long id){
        reservaService.PutReserva(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DELETE /reservas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteReserva(@PathVariable Long id){
        reservaService.DeleteReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
