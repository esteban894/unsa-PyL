package Hilos.parcial2023;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
    private BufferedImage imagen;
    private int[] hist;

    public Imagen(){
        loadImage();
    }

    public void loadImage() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try {
                BufferedImage originalImage = ImageIO.read(selectedFile);
                this.imagen = new BufferedImage(
                    originalImage.getWidth(),
                    originalImage.getHeight(),
                    BufferedImage.TYPE_BYTE_GRAY
                );
                
                Graphics g = this.imagen.getGraphics();
                g.drawImage(originalImage, 0, 0, null);
                g.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saltAndPepper(Double r) {
        for(int i=0; i < this.imagen.getWidth();i++){
            for(int j=0; j < this.imagen.getHeight();j++){
                if(Math.random()<r){
                    //romper el pixel
                    if(Math.random()<0.5){
                        this.imagen.setRGB(i, j, 0x00000);
                    } else {
                        this.imagen.setRGB(i, j, 0xFFFFF);
                    }
                }
            }
        }        
    }

    public void displayImage() {
        if (this.imagen != null) {
            JFrame frame = new JFrame("Imagen en escala de grises");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(this.imagen.getWidth(), this.imagen.getHeight());
            frame.add(new JLabel(new ImageIcon(this.imagen)));
            frame.pack();
            frame.setVisible(true);
        } else {
            System.out.println("No se ha cargado ninguna imagen.");
        }
    }

    public int[] getHistograma(){
        int histograma[] = newHistograma();
        Color color;
        int fila, columna;
        for(fila = 0; fila < this.imagen.getWidth(); fila++){
            for(columna = 0; columna < this.imagen.getHeight(); columna++){
                color = new Color(this.imagen.getRGB(fila,columna));
                //System.out.println("color: "+color+" pos: "+fila+","+columna+" rojo: "+color.getRed());
                histograma[color.getRed()]++;
            }
        }
        return histograma;
    }

    public int[] getHistograma1(){
        Hilos h1,h2;
        this.hist = newHistograma();
        h1 = new Hilos(this, 0, (imagen.getWidth()/2));
        h2 = new Hilos(this, imagen.getWidth()/2, imagen.getWidth());
        h1.start();
        h2.start();
        try{
            h1.join();
            h2.join();
        }catch(InterruptedException e){}
        return this.hist;
    }

    public int[] histograma(int ini,int fin){
        int fila, columna;
        int[] aux = newHistograma();
        Color color;
        for(columna = ini; columna < fin;columna++){
            for(fila=0;fila < imagen.getHeight();fila++){
                color = new Color(this.imagen.getRGB(columna,fila));
                //System.out.println("color: "+color+" pos: "+fila+","+columna+" rojo: "+color.getRed());
                aux[color.getRed()]++;
            }
        }
        return aux;
    }

    public synchronized void sumHist(int pos,int valor){
        this.hist[pos] = this.hist[pos] + valor;
    }

    private int[] newHistograma(){
        int histograma[] = new int[256];
        int i;
        for(i=0;i<=255;i++){
            histograma[i] = 0;
        }
        return histograma;
    }

    public void mostrarHistograma(){
        int histograma[] = getHistograma1();
        int i;
        for(i=0;i<=255;i++){
            System.out.println("Pixel: "+i+" Apariciones: "+histograma[i]);
        }
    }

    public void comparacionHistogramas(){
        long tiempoInicio, tiempoFin;
        int[] aux1, aux2;
        int i = 0;
        boolean b=true;
        tiempoInicio = System.currentTimeMillis();
        aux1 = getHistograma();
        tiempoFin = System.currentTimeMillis();
        System.out.println("tiempo sin hilos: "+(tiempoFin-tiempoInicio));
        tiempoInicio = System.currentTimeMillis();
        aux2 = getHistograma1();
        tiempoFin = System.currentTimeMillis();
        System.out.println("tiempo con hilos: "+(tiempoFin-tiempoInicio));
        while(i<=255){
            if(aux1[i]!=aux2[i]){
                b=false;
                System.out.println(i+"elementos: "+ aux1[i]+" , "+ aux2[i]);
            }
            i++;
        }
        if(b)
            System.out.println("son iguales");
        else
            System.out.println("son distintos");
    }
}