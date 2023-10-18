package org.bedu.jse2.demo.ejemplos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
class Ejemplo2Test {

    private final List<Integer> CONJUNTO = List.of(1, 4, 6, -5, 9);

    @Test
    @DisplayName("Negativos")
    void negativos() {
        Ejemplo2 ejemplo2 = new Ejemplo2();
        List<Integer> real = ejemplo2.transformar(CONJUNTO, s -> -s);
        assertThat(real).containsExactly(-1, -4, -6, 5, -9);
    }

    @Test
    @DisplayName("Cuadrados")
    void cuadrados() {
        Ejemplo2 ejemplo2 = new Ejemplo2();
        List<Integer> real = ejemplo2.transformar(CONJUNTO, s -> s * s);
        assertThat(real).containsExactly(1, 16, 36, 25, 81);
    }

    @Test
    @DisplayName("Suma")
    void sumaReducida() {
        Ejemplo2 ejemplo2 = new Ejemplo2();
        Integer real = ejemplo2.transformarYSumar(CONJUNTO, s1 -> 10);
        assertThat(real).isEqualTo(CONJUNTO.size());
    }
}