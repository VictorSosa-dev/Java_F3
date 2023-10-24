package org.course;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertirStringTest {

    @Test
    @DisplayName("Puede convertir un Integer a String")
    void convertirEntero() {
        Integer entero = 1;
        ConvertirString<Integer> convertirString = new ConvertirString<>();
        convertirString.hold(entero);
        assertEquals(entero.toString(), convertirString.convertirString());
    }

    @Test
    @DisplayName("Puede convertir un String a String")
    void convertirCadena() {
        String string = "Hola";
        ConvertirString<String> convertirString = new ConvertirString<>();
        convertirString.hold(string);
        assertEquals(string, convertirString.convertirString());
    }

    @Test
    @DisplayName("Puede convertir un Double a String")
    void convertirDouble() {
        Double double1 = 1.0;
        ConvertirString<Double> convertirString = new ConvertirString<>();
        convertirString.hold(double1);
        assertEquals(double1.toString(), convertirString.convertirString());
    }

    private class ClasePropia {
        private  final String nombre;
        private final Integer edad;

        ClasePropia(String nombre, Integer edad){
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre(){
            return nombre;
        }

        public Integer getEdad(){
            return edad;
        }
    }

    @Test
    @DisplayName("Puede convertir una clase propia a String")
    void convertirClasePropia() {

        ClasePropia cp = new ClasePropia("Juan", 20);

        ConvertirString<ClasePropia> convertirString = new ConvertirString<>();
        convertirString.hold(cp);

        assertEquals(cp.toString(), convertirString.convertirString());
    }

    @Test
    @DisplayName("Convertir un integer a string con un metodo generico")
    void convertirInteger() {
        Integer entero = 1;
        assertEquals(entero.toString(), ConvertirString.convertirSting2(entero));
    }

    @Test
    @DisplayName("Convertir un boolean a string con un metodo generico")
    void convertirBoolean() {
        boolean bo = false;
        assertEquals(Boolean.toString(bo), ConvertirString.convertirSting2(bo));
    }
}