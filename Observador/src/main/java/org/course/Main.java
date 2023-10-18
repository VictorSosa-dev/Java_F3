package org.course;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Sujeto sujeto = new Sujeto();
        ObservadorA observadorA = new ObservadorA(sujeto);
        ObservadorB observadorB = new ObservadorB(sujeto);

        sujeto.setEstado(10); // Notifica a los observadores sobre el cambio de estado
    }
}