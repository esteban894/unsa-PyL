package Hilos.parcial2023;

public class Test {
    
    public static void main(String[] args) {
        long tiempoInicio, tiempoFin;
        Imagen img = new Imagen();
//        img.displayImage();
        tiempoInicio = System.currentTimeMillis();
        img.mostrarHistograma();
        tiempoFin = System.currentTimeMillis();
        System.out.println("tiempo: "+(tiempoFin-tiempoInicio)+" ms");
        img.comparacionHistogramas();
    }

}
