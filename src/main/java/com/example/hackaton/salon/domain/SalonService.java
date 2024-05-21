package com.example.hackaton.salon.domain;

import com.example.hackaton.salon.infrastructure.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalonService {

    @Autowired
    SalonRepository salonRepository;

}
