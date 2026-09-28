public class Productor implements Runnable {
    private Buffer buffer;
    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                buffer.producir(i);
                Thread.sleep((long) Math.random() * 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
