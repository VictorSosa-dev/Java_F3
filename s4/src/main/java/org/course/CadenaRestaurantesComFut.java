package org.course;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CadenaRestaurantesComFut {

    /**
     * El dueño de la cadena de restaurantes te ha pedido que ahora le ayudes a
     * encontrar el valor máximo obtenido por las ventas de sus sucursales,
     * solo que ahora tienes que emplear la clase CompletableFuture para buscar
     * dicho valor y retornarlo.
     *
     * Tendrás que trabajar sobre el proyecto que creaste en el reto 1 y realizar
     * las adaptaciones necesarias para usar la clase CompletableFuture de la API Future.
     *
     */

    public static void main(String[] args) {
        List<Integer> idSucursales = IntStream
                .rangeClosed(0, 1000)
                .boxed()
                .collect(java.util.stream.Collectors.toList());

        CadenaRestaurantesComFut cadena = new CadenaRestaurantesComFut();
        //cadena.obtenerGananciasFranquicia(idSucursales.stream());
        List<CompletableFuture<Double>> futuros = idSucursales.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> new CadenaRestaurantesComFut().obtenerGananciasSucursal(id)))
                .collect(Collectors.toList());

        OptionalDouble maximo = futuros.stream()
                .mapToDouble(CompletableFuture::join)
                .max();

        if (maximo.isPresent()) {
            System.out.printf("Las ganancias totales son: $%5.2f%n", maximo.getAsDouble());
        } else {
            System.out.print("Error");
        }


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
