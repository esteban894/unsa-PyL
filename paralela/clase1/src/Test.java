import hilos.SumaParcial;
import utils.Matriz;

public class Test {
    public static void main(String[] args) {
        long tiempoIni, tiempoFin;

        Matriz m1 = new Matriz(12530, 3123);
//        tiempoIni = System.currentTimeMillis();
//        int rdo = m1.sumaTotal();
//        tiempoFin = System.currentTimeMillis();
//        System.out.println("Resultado: " + rdo);
//        System.out.println("Tiempo: " + (tiempoFin - tiempoIni) + "ms");0

        SumaParcial h1 = new SumaParcial(m1, 0, (m1.getCols()/2));
        SumaParcial h2 = new SumaParcial(m1, (m1.getCols()/2), m1.getCols());

        tiempoIni = System.currentTimeMillis();
        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tiempoFin = System.currentTimeMillis();

        float acum = h1.acum + h2.acum;
        System.out.println("Tiempo: " + (tiempoFin - tiempoIni) + "ms");
        System.out.println("Resultado: " + (int)acum);

        System.out.println("Suma total secuencial: " + m1.sumaTotal());
    }
}
