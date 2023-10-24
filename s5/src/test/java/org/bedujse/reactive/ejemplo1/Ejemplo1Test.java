package org.bedujse.reactive.ejemplo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Ejemplo1Test {

    @Test
    @DisplayName("Suma los elementos y regresa Single")
    void sumaElementos() {
        Ejemplo1.sumarSingle()
                .subscribe(s -> assertThat(s).isEqualTo(21));
    }

    @Test
    @DisplayName("Suma los elementos y regresa valor (bloqueante)")
    void sumaElementosBloqueante() {
        assertThat(Ejemplo1.sumar()).isEqualTo(21);
    }


    @Test
    @DisplayName("Elevar al cubo y sumar solo los mayores a 50")
    void cubosFiltrados() {
        Ejemplo1.cubosFiltrados()
                .subscribe(s -> assertThat(s).isEqualTo(405));
    }
}