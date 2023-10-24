package org.course;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimitedConverterTest {

    @Test
    @DisplayName("Con enteros")
    void integers() {
        Integer numero1 = 3;
        Integer numero2 = 4;
        LimitedConverter<Integer> limitedConverter = new LimitedConverter<>();
        assertTrue(limitedConverter.esMayorQue(numero2, numero1));
    }

    @Test
    @DisplayName("Con doubles")
    void doubles() {
        Double numero1 = 3.0;
        Double numero2 = 4.0;
        LimitedConverter<Double> limitedConverter = new LimitedConverter<>();
        assertTrue(limitedConverter.esMayorQue(numero2, numero1));
    }

}