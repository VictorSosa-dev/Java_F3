package com.java.backend.Postworks.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ciclo;

    private Materia materia;

    private Map<Estudiante, Integer> calificaciones;

}
