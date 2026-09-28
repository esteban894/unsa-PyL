import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private final Queue<Integer> buffer;
    private final int capacidadMaxima;

    public Buffer(int capacidad) {
        this.buffer = new LinkedList<>();
        this.capacidadMaxima = capacidad;
    }

    public synchronized void producir(int valor) throws InterruptedException {
        // mientras el buffer está lleno, el productor debe esperar
        while (buffer.size() == capacidadMaxima) {
            System.out.println("Buffer lleno. Productor espera...");
            wait(); // el hilo productor libera el monitor y entra en estado de espera
        }

        // produce el elemento
        buffer.add(valor);
        System.out.println("Producido: " + valor + " | tamaño actual: " + buffer.size());

        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer vacío. Consumidor espera...");
            wait();
        }

        int valor = buffer.remove();
        System.out.println("Consumido: " + valor + " | Tamaño actual: " + buffer.size());

        notifyAll();

        return valor;
    }
}
