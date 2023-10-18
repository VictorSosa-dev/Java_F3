package org.course;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E2 {

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(1, 11)
                .boxed()
                .collect(java.util.stream.Collectors.toList());
        E2 e2 = new E2();

        List<CompletableFuture<Double>> futuros = ids.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> e2.leer(id)))
                .collect(Collectors.toList());

        e2.obtenerPromedio(futuros);
    }

    void obtenerPromedio(List<CompletableFuture<Double>> futuros){
        LocalTime inicio = LocalTime.now();
        double promedio = futuros.stream()
                .mapToDouble(CompletableFuture::join)
                .average()
                .orElse(0);
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
