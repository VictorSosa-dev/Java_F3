package com.bakend.javase2.async;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReceptorSolicitudes implements Runnable {

    private boolean enEjecucion = false;
    private Queue<Object> listaSolicitudes = new LinkedList<>();
    //NotificadorInscripcion = EventHandler
    private final NotificadorInscripcion worker;

    public ReceptorSolicitudes(NotificadorInscripcion worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        try{
            while(enEjecucion || !listaSolicitudes.isEmpty()){
                Object evento = listaSolicitudes.poll();

                if(evento == null){
                    System.out.println("No hay eventos pendientes, esperando 1s...");
                    TimeUnit.SECONDS.sleep(1);
                }
                worker.notificar((SolicitudEstudiante) evento);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            enEjecucion = false;
            e.printStackTrace();
        }
    }

    //Agregar tareas a la lista
    public void agregarSolicitudes(SolicitudEstudiante solicitud){
        listaSolicitudes.add(solicitud);
    }
    //Iniciar el hilo
    public void start() {
        this.enEjecucion = true;
        new Thread(this).start();
    }

    //Detener el hilo
    public void stop() {
        this.enEjecucion = false;
    }

    //Estado del hilo
    public boolean isEnEjecucion(){
        return enEjecucion;
    }
}
