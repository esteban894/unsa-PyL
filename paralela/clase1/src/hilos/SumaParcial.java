package hilos;

import utils.Matriz;

public class SumaParcial extends Thread {
    private Matriz matriz;
    private int colIni, colFin;
    public long acum;

    public SumaParcial(Matriz matriz, int colIni, int colFin) {
        this.matriz = matriz;
        this.colIni = colIni;
        this.colFin = colFin;
        this.acum = 0;
    }

    public void run() {
        for (int i = 0; i < matriz.getFilas(); i++) {
            for (int j = colIni; j < colFin; j++) {
                this.acum += matriz.getMatriz()[i][j];
            }
        }
    }
}
