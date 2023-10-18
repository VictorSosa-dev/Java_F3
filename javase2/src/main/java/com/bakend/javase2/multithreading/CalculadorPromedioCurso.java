package com.bakend.javase2.multithreading;

import com.bakend.javase2.model.Curso;
import com.bakend.javase2.model.Estudiante;

import java.util.Map;

public class CalculadorPromedioCurso implements Runnable{

    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso){
        this.curso = curso;
    }

    @Override
    public void run() {
        double suma = 0;
        Map<Estudiante,Integer> calificaciones = curso.getCalificaciones();
        for (Map.Entry<Estudiante,Integer> entry : calificaciones.entrySet()) {
            suma += entry.getValue();
        }
        promedio = suma / calificaciones.size();

        System.out.println("El promedio del curso " + curso.getMateria().getNombre() + " es: " + promedio);
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
