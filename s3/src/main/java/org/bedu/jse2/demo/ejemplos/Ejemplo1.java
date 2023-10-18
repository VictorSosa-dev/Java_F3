package org.bedu.jse2.demo.ejemplos;

import java.util.function.Function;

public class Ejemplo1 {

    // E1
    /**
     * private final StringToInteger stringToInteger = new StringToInteger() {
     *         @Override
     *         public Integer convert(String s) {
     *             return Integer.valueOf(s);
     *         }
     *     };
     *
     *    private final StringToInteger stringToInteger = s -> Integer.valueOf(s);
     *
     *    private final StringToInteger stringToInteger = Integer::valueOf;
     *
     *    Integer sumar(String a, String b){
     *         return stringToInteger.convert(a) + stringToInteger.convert(b);
     *     }
     */

    // Reto 1
    Function<String, Integer> stringToInteger = Integer::valueOf;

    Integer sumar(String a, String b){
        return stringToInteger.apply(a) + stringToInteger.apply(b);
    }

}
