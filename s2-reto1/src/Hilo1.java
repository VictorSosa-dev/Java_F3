public class Hilo1 implements Runnable{

    private String nombre;

    private int tiempo;

    public Hilo1(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i <= 10; i++){
                System.out.println("Hilo: " + nombre + " " + i);
                Thread.sleep(tiempo);
            }
        }catch(InterruptedException e){
            System.out.println("Error en el hilo: " + e);
        }
    }

}
