package org.course;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EchoClassTest {

    @Test
    @DisplayName("Eco de un string (generic explicito)")
    void echoString() {
        String string = "Hola";
        String echo = EchoClass.<String>echo(string);
        assertEquals(string, echo);
    }

    @Test
    @DisplayName("Eco de un string (generic implicito)")
    void echoInteger() {
        Integer num = 1233;
        Integer echo = EchoClass.echo(num);
        assertEquals(num, echo);
    }

}