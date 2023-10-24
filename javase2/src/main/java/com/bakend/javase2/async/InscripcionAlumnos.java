package com.bakend.javase2.async;

import com.bakend.javase2.model.Curso;
import com.bakend.javase2.model.Estudiante;
import com.bakend.javase2.model.Materia;

public class InscripcionAlumnos {
    public static void main(String[] args) {

        SolicitudEstudiante SolicitudEstudiante;
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


        // creamos 20 estudiantes



        //EventLoop
        ReceptorSolicitudes receptorSolicitudes = new ReceptorSolicitudes(evento -> {

        });
    }
}
