package com.example.hackaton.salon.application;

import com.example.hackaton.salon.domain.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    SalonService salonService;
}
