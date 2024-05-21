package com.example.hackaton.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ReservaEventListener {

    @Autowired
    EmailService emailService;

    @EventListener
    @Async
    public void sendNuevaReservaEmail(ReservaEmailEvent event) {
        emailService.sendEmail( event.getEmail(), "Nueva Reserva!",
                "Querid@ " + event.getName() + " le mandamos este mail de confirmacion de su reserva en el salon: " +
                event.getSalonName());
    }

}
