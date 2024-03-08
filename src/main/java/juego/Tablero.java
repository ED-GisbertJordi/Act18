/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author Jordi Gisbert Ferriz
 */
public class Tablero {
    private final int DIMENSIONES = 3; 
    private Ficha[][] casillas = new Ficha[DIMENSIONES][DIMENSIONES];

    
    public Tablero() {
        vaciar();
    }
    
    public int getDimensiones(){
        return this.DIMENSIONES;
    }
    
    
    public boolean estaLleno(){
        int contador = 0;
        for (Ficha[] casilla : this.casillas) {
            for (Ficha casilla1 : casilla) {
                if (!casilla1.equals(Ficha.vacia))    contador++;
            }
        }
        return contador==this.DIMENSIONES*this.DIMENSIONES;
    }
    
    public void vaciar(){
        for (int y = 0; y < this.casillas.length; y++) {
            for (int x = 0; x < this.casillas[y].length; x++) {
                this.casillas[y][x] = Ficha.vacia;
            }
        }
    }
    
    public void ponerFicha(Coordenada coordenada, Ficha ficha){
        this.casillas[coordenada.getFila()-1][coordenada.getColumna()-1] = ficha;
    }
    
    public boolean isOcupada(Coordenada coordenada){
        return (!this.casillas[coordenada.getFila()-1][coordenada.getColumna()-1].equals(Ficha.vacia));
    }
    
    
    public boolean hayTresEnRaya(){
        return (hayTresEnRaya(Ficha.circulo) || hayTresEnRaya(Ficha.equis));
    }
    
    private boolean hayTresEnRaya(Ficha ficha){
        /* Filas ///////////////////////////////////////////////////////////////////////////////////////////////////*/
        for (Ficha[] fila : this.casillas) {
            int coincidencias = 0;
            for (Ficha casilla : fila) {
                if (casilla.equals(ficha))  coincidencias++;
            }
            if (coincidencias==this.DIMENSIONES) return true;
        }
        
        /* Columnas //////////////////////////////////////////////////////////////////////////////////////////*/
        for (int x = 0; x < this.DIMENSIONES; x++) {
            int coincidencias = 0;
            for (int y = 0; y < this.DIMENSIONES; y++) {
                if (this.casillas[y][x].equals(ficha)) {
                    coincidencias++;
                }
            }
            if (coincidencias == this.DIMENSIONES)   return true;
        }
        
        /* Diagonal Normal ////////////////////////////////////////////////////////////////////////////////*/
        int coincidencias = 0;
        for (int i = 0; i < this.DIMENSIONES; i++) {
            if (this.casillas[i][i].equals(ficha))  coincidencias++;
        }
        if (coincidencias == this.DIMENSIONES)   return true;
        
        /* Diagonal Invertida /////////////////////////////////////////////////////////////////////////////*/
        coincidencias = 0;
        int x = this.DIMENSIONES-1;
        for (int y = 0; y < this.DIMENSIONES; y++) {
            if (this.casillas[y][x].equals(ficha))  coincidencias++;
            x--;
        }
        return coincidencias == this.DIMENSIONES;
    }
    
    
    
    
    
    public void mostrar(){
        System.out.print(" _|");
        for (int i = 1; i <= this.casillas.length; i++) {
            System.out.print(i+"|");
        }
        for (int y = 0; y < this.casillas.length; y++) {
            System.out.print("\n|"+(y+1)+"|");
            for (Ficha casilla : this.casillas[y]) {
                System.out.print(casilla + "|");
            }
        }
        System.out.println("");
    }
    
}
