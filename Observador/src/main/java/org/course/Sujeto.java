package org.course;


import java.util.ArrayList;
import java.util.List;

// Sujeto (Subject) que será observado por los observadores
public class Sujeto {
    private List<Observador> observadores = new ArrayList<>();

    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        notificarTodosObservadores();
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void notificarTodosObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }


}
