package com.java.backend.Postworks.model;

import javax.persistence.*;

@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
}
