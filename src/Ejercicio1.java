public class Ejercicio1 extends Thread {

    public static void main(String[] args) {

        Ejercicio1 hilo0 = new Ejercicio1();
        Ejercicio1 hilo1 = new Ejercicio1();
        Ejercicio1 hilo2 = new Ejercicio1();
        Ejercicio1 hilo3 = new Ejercicio1();
        Ejercicio1 hilo4 = new Ejercicio1();



        hilo0.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

    }

    @Override
    public void run() {

        int numAleatorio;


        while (true){

            System.out.println("Soy el hilo " + this.getName()+  " y estoy trabajando");

            try {
                    numAleatorio=(int) (Math.random()*10000);
                    Thread.sleep(numAleatorio);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}