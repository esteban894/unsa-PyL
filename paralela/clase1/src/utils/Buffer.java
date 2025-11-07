package utils;

public class Buffer {
    String[] buffer = new String[300];
    int size = 0;

    public synchronized void write(String msj) {
        buffer[size] = msj;
        size++;
    }

    public String read(int pos) {
        return buffer[pos];
    }
}
