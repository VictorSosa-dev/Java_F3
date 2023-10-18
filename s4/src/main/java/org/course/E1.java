package org.course;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E1 {

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(1, 101).boxed().collect(java.util.stream.Collectors.toList());
        E1 e1 = new E1();
        e1.obtenerPromedio(ids.stream());
        e1.obtenerPromedio(ids.parallelStream());

    }

    void obtenerPromedio(Stream<Integer> ids){
        LocalTime inicio = LocalTime.now();
        double promedio = ids.mapToDouble(this::leer).average().orElse(0);
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.printf((Math.round(promedio * 100.) / 100.) + " en " + tiempo.toMillis() + " ms");
    }

    double leer(int id){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return id * Math.random();
    }
}
