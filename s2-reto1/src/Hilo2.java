public class Hilo2 implements Runnable{

    private String nombre;

    private int tiempo;

    public Hilo2(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @Override
    public void run(){
        try{
            while(true){
                System.out.println("Hilo: " + nombre + " Sigo en ejecución");
                Thread.sleep(tiempo);
            }

        }catch(InterruptedException e){
            System.out.println("Error en el hilo: " + e);
        }
    }

}
