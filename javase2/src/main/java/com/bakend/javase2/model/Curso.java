package com.bakend.javase2.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ciclo")
    private String ciclo;

    @ManyToOne
    @JoinColumn(name = "materias_fk")
    private Materia materia;

    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = @JoinColumn(name = "cursos_fk"))
    @MapKeyJoinColumn(name = "estudiantes_fk")
    @Column(name = "calificacion")
    private Map<Estudiante,Integer> calificaciones ;

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones == null ? new HashMap<>() : calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
