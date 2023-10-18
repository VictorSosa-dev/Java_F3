package org.course;

public class ObservadorA implements Observador{

    private  Sujeto sujeto;

    public ObservadorA(Sujeto sujeto){
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }
    @Override
    public void actualizar() {
        System.out.println("Observador A ha sido notificado: " + sujeto.getEstado());
    }
}
