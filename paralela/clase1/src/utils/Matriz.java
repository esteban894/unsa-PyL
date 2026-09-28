package utils;

public class Matriz {
    private int filas;
    private int cols;
    private int[][] matriz;

    public Matriz(int filas, int cols) {
        this.filas = filas;
        this.cols = cols;
        this.matriz = new int[this.filas][this.cols];

        generarMatriz(this.filas, this.cols);
    }

    public void generarMatriz(int filas, int cols) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                matriz[i][j] = (int) (Math.random() * 100) + 1;
            }
        }
    }

    public void show() {
        for (int[] fila : this.matriz) {
            for (int elem: fila) {
                System.out.printf("%02d ",elem);
            }
            System.out.println();
        }
    }

    public long sumaTotal() {
        long sum = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matriz[i][j];
            }
        }
        return sum;
    }

    public int getFilas() {
        return filas;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
