package com.example.hackaton.example.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    String example;
}
