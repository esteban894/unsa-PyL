package hilos;

import utils.Buffer;

import java.util.Arrays;

public class Hilo extends Thread {
    String msj;
    Buffer buffer;

    public Hilo(String msj, Buffer buffer) {
        this.msj = msj;
        this.buffer = buffer;
    }

    public void run () {
        for (int i = 0; i < 50; i++) {
            buffer.write(msj+i);
        }
    }
}
