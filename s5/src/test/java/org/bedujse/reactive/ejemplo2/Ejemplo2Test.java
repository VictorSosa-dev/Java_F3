package org.bedujse.reactive.ejemplo2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Ejemplo2Test {

    @Test
    @DisplayName("Suma los elementos y regresa Single")
    void sumaElementos() {
        Ejemplo2.sumarSingle()
                .subscribe(s -> assertThat(s).isEqualTo(21));
    }

    @Test
    @DisplayName("Suma los elementos y regresa valor (bloqueante)")
    void sumaElementosBloqueante() {
        assertThat(Ejemplo2.sumar()).isEqualTo(21);
    }

    @Test
    @DisplayName("Elevar al cubo y sumar los menores a 50")
    void elevarAlCuboYSumarMenoresA50() {
        Ejemplo2.elevarAlCuboYSumarMenoresA50()
                .subscribe(s -> assertThat(s).isEqualTo(36));
    }

}