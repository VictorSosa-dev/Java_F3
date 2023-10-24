package org.bedujse.reactive.ejemplo1;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.bedujse.reactive.generator.RxJavaObservableGenerator;

public class Ejemplo1 {

    static  Single<Integer> sumarSingle(){
        return RxJavaObservableGenerator
                .observableStream()
                .reduce(0,(a,b) -> a + b);
    }

    static Integer sumar(){
        return RxJavaObservableGenerator
                .observableStream()
                .reduce(0,(a,b) -> a + b)
                .blockingGet();
    }


    static Single<Integer> cubosFiltrados(){
        return RxJavaObservableGenerator
                .observableStream()
                .map(i -> i * i * i)
                .filter(i -> i > 50)
                .reduce(0,Integer::sum);
    }
}
