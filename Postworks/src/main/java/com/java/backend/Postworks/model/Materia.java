package com.java.backend.Postworks.model;

import javax.persistence.*;

@Entity
@Table(name = "MATERIAS")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

}
