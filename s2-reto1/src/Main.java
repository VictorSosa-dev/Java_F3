// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /**
         * Deberás desarrollar una pequeña aplicación que mediante 2 hilos (uno de usuario y uno daemon) realice un par de tareas:
         *
         * En el hilo de usuario deberás imprimir los números del 1 al 10 cada segundo.
         * En el hilo daemon solo deberás imprimir cada medio segundo la frase "Sigo en ejecución".
         * Recuerda que debes instanciar e iniciar los objetos necesarios para cada hilo desde el método
         * main de tu aplicación y la lógica principal de cada hilo está ubicada en el método run de tu clase hilo.
         */

        Hilo1 hilo1 = new Hilo1("usuario", 1000);
        Thread t1 = new Thread(hilo1);
        Hilo2 hilo2 = new Hilo2("daemon", 500);
        Thread t2 = new Thread(hilo2);

        t1.start();
        t2.setDaemon(true);
        t2.start();


    }
}