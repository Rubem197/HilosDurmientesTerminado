import com.sun.tools.javac.Main;
import jdk.jfr.Percentage;

public class Ejercicio2 extends Thread {

    public static int numeroAdivinar;
    public static boolean acertado = false;


    @Override
    public void run() {
        int num = (int) (Math.random() * 100);
        int res = propuestaNumero(num);

        while (res == 0) {
            num = (int) (Math.random() * 100);
            res = propuestaNumero(num);
            if (res ==0 && !acertado){
                System.out.println("El "+ Thread.currentThread().getName() + " no encuentra el numero");

            }
            if (res ==1){
                System.out.println("El "+ Thread.currentThread().getName() + " ha encontrado el numero");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //interrumpir en cualquier caso
    }


    public static int propuestaNumero(int num) {
        int res = 0;

        if (num == numeroAdivinar) {
            res = 1;
            acertado = true;
        }
        if (acertado && res==0) {
            res = -1;
            //interrumpir hilo
        }
        return res;
    }


    public static void main(String[] args) {
        numeroAdivinar = (int) (Math.random() * 100);

        for (int i = 0; i < 10; i++) {
            Thread h1 = new Ejercicio2();
            h1.setName("hilo " + i);
            h1.start();
        }
    }
}
