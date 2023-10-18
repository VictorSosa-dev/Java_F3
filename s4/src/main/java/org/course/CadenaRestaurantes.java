package org.course;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CadenaRestaurantes {

    /**
     * Una conocida cadena de hamburguesas quiere realizar cambios
     * en su infraestructura empleando el procesamiento paralelo
     * para acelerar el cálculo de las ganancias diarias, sumando
     * las ganancias obtenidas por cada una de sus sucursales,
     * las cuales tienen un identificador numérico del 0 al 1000.
     * El tiempo que toma obtener la información de cada sucursal
     * es de 50ms, que deberás simular mediante un sleep en el
     * método que te permita obtener la información de esa sucursal.
     * Las ganancias esperadas para una sucursal promedio van desde
     * los $10000 hasta los $50000.
     *
     * Este reto consiste en simular la implementación de este sistema,
     * generando una clase CadenaRestaurantes que contenga un método
     * obtenerGananciasFranquicia, que retornará el valor numérico
     * con las ganancias del día para el id presentado. Puedes basarte
     * en el proyecto creado para la lectura de los sensores, pero la
     * función será ahora una suma en lugar del promedio de los valores.
     */

    public static void main(String[] args) {
        List<Integer> idSucursales = IntStream
                .rangeClosed(0, 1000)
                .boxed()
                .collect(java.util.stream.Collectors.toList());

        CadenaRestaurantes cadena = new CadenaRestaurantes();
        cadena.obtenerGananciasFranquicia(idSucursales.stream());
        //cadena.obtenerGananciasFranquicia(idSucursales.parallelStream());

    }

    private Random rnd = new Random();

    void esperar(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Las ganancias esperadas para una sucursal promedio van desde los
    // $10000 hasta los $50000.
    double obtenerGananciasSucursal(int id){
        esperar();
        return rnd.nextInt(40000) + 10000;
    }

    void obtenerGananciasFranquicia(Stream<Integer> ids){
        LocalTime inicio = LocalTime.now(); // Tiempo de inicio
        double suma = ids.mapToDouble(this::obtenerGananciasSucursal).sum();
        System.out.printf("Las ganancias totales son: $%5.2f%n", suma);
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.println((Math.round(suma * 100.) / 100.) + " en " + tiempo.toMillis() + "ms"); //imprimimos el resultado
    }




}
