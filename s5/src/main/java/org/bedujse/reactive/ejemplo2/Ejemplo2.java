package org.bedujse.reactive.ejemplo2;

import io.reactivex.Single;
import org.bedujse.reactive.generator.ReactorFluxGenerator;
import reactor.core.publisher.Mono;

public class Ejemplo2 {

    static Mono<Integer> sumarSingle(){
        return ReactorFluxGenerator
                .fluxStream()
                .reduce(0,(a,b) -> a + b);
    }

    static Integer sumar(){
        return ReactorFluxGenerator
                .fluxStream()
                .reduce(0,(a,b) -> a + b)
                .block();
    }

    public static Mono<Integer> elevarAlCuboYSumarMenoresA50() {
        return ReactorFluxGenerator
                .fluxStream()
                .flatMap(i -> Mono.just(i * i * i))
                .filter(i -> i < 50)
                .reduce(0,Integer::sum);
    }
}
