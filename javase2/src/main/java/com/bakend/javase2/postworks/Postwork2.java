package com.bakend.javase2.postworks;

import com.bakend.javase2.model.Curso;
import com.bakend.javase2.model.Estudiante;
import com.bakend.javase2.model.Materia;
import com.bakend.javase2.multithreading.CalculadorPromedioCurso;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Postwork2 {
    /*
     * Completen las siguientes instrucciones para realizar el segundo postwork:
     *
     * Realizar en equipo
     *
     * Utilicen el proyecto del postwork 1.
     *
     * Generen un nuevo package con el nombre de multithreading.
     *
     * Un miembro del equipo creará la clase CalculadorPromedioCurso que implemente un Runnable, su constructor deberá obtener el curso, con las calificaciones a promediar; además, el run deberá calcular el promedio y mostrar el resultado junto con el nombre del curso.
     *
     * Otra persona deberá generar la clase Postwork2 la cual creará los cursos (cuatro como mínimo) con calificaciones aleatorias para cada uno de sus estudiantes. Como muestra dejaremos 20 estudiantes por curso.
     *
     * Una vez generada la información otro miembro del equipo ejecutará el Runnable con un ExecutorService. Donde cada hilo deberá calcular cada curso.
     *
     *
     * A continuación dejamos una imagen donde pueden visualizar el flujo general que tomará la aplicación.
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Postwork 2");
        // creamos un pool preconfigurado
        ExecutorService pool = Executors.newCachedThreadPool();

        //Creamos una materia
        Materia materia1 = new Materia();
        materia1.setNombre("Java");
        Materia materia2 = new Materia();
        materia2.setNombre("Python");

        // creamos los cursos
        Curso curso1 = new Curso();
        curso1.setCiclo("2020-1");
        curso1.setMateria(materia1);
        //curso1.getCalificaciones().put(new Estudiante(1,"Estudiante 1"), 10);
        //curso1.setCalificaciones(curso1.getCalificaciones());
        //System.out.println(curso1.toString());
        Curso curso2 = new Curso();

        curso2.setCiclo("2020-2");
        curso2.setMateria(materia2);
        Curso curso3 = new Curso();
        curso3.setCiclo("2021-1");
        curso3.setMateria(materia1);
        Curso curso4 = new Curso();
        curso4.setMateria(materia2);
        curso4.setCiclo("2021-2");

        // creamos 20 estudiantes por curso
        for (int i = 0; i < 20; i++) {
            curso1.getCalificaciones().put(new Estudiante(i,"Estudiante " + i), (int) (Math.random() * 10));
            curso1.setCalificaciones(curso1.getCalificaciones());
            curso2.getCalificaciones().put(new Estudiante(i,"Estudiante " + i), (int) (Math.random() * 10));
            curso2.setCalificaciones(curso2.getCalificaciones());
            curso3.getCalificaciones().put(new Estudiante(i,"Estudiante " + i), (int) (Math.random() * 10));
            curso3.setCalificaciones(curso3.getCalificaciones());
            curso4.getCalificaciones().put(new Estudiante(i,"Estudiante " + i), (int) (Math.random() * 10));
            curso4.setCalificaciones(curso4.getCalificaciones());
        }

        // ejecutamos los hilos
        List<Curso> cursos = List.of(curso1, curso2, curso3, curso4);
        for (Curso curso : cursos) {
            pool.execute(new CalculadorPromedioCurso(curso));
        }










    }

}
