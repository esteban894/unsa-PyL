package hilos;

public class Chau extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Chau " + i);
        }
    }
}
