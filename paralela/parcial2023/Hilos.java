package Hilos.parcial2023;

public class Hilos extends Thread{
    private Imagen imagen;
    private int ini, fin;

    public Hilos(Imagen imagen,int ini, int fin){
        this.imagen = imagen;
        this.ini = ini;
        this.fin = fin;
    }

    public void run(){
        int[] aux = new int[256];
        int i;
        aux = this.imagen.histograma(this.ini, this.fin);
        for(i=0;i<=255;i++){
            imagen.sumHist(i, aux[i]);
        }
    }
    
}
