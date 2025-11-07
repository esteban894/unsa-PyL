import hilos.Hilo;
import utils.Buffer;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Hilo h1 = new Hilo("Hola", buffer);
        Hilo h2 = new Hilo("Chau", buffer);

        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {}

        for (int i = 0; i < 100; i++) {
            System.out.println(buffer.read(i));
        }
    }
}