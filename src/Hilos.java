import java.util.Random;

public class Hilos extends Thread {
    private final String texto;

    public Hilos(String texto) {
        this.texto = texto;
    }

    public static void main(String[] args) {
        Thread hilo1 = new Thread(new Hilos("Jose Maria"));
        Thread hilo2 = new Thread(new Hilos("Jaime"));

        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Hilo principal terminado");
    }

    @Override
    public void run() {
        System.out.printf("Hilo de %s\n", this.texto);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int pausa = random.nextInt(491 - 10);
            System.out.printf("Hilo de %s,pausa de %d milisegundos\n", this.texto, pausa);
            try {
                Thread.sleep(pausa);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.printf("Hilo %s terminado \n", this.texto);
    }
}
