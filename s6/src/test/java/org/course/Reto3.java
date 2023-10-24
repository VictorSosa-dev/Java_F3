package org.course;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Reto3 {
    @Test
    @DisplayName("Problemático")
    void reto(){
        List<? extends Number> numberList;

        List<Integer> integerList = List.of(1,2,3);

        numberList = integerList;

        assertNotNull(numberList);
    }
}
