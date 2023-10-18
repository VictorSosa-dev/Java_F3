package org.course;

public class ObservadorB implements Observador{

    private  Sujeto sujeto;

    public ObservadorB(Sujeto sujeto){
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }
    @Override
    public void actualizar() {
        System.out.println("Observador A ha sido notificado: " + sujeto.getEstado());
    }
}
