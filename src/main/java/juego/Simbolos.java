/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Random;
import main.TresEnRaya;

/**
 *
 * @author Usuario
 */
public class Simbolos {
    private char[][] packs;
//    private char[][] packs = {{'X','O'},{'€','$'},{'#','@'},{'+','-'}};
    private int seleccionado;
    
    public Simbolos() {
        this.packs = new char[][]{{'X','O'},{'€','$'},{'#','@'},{'+','-'}};
    }
    
    public char obtenerSimbolo(Ficha ficha){
        return (ficha.equals(Ficha.equis))? this.packs[this.seleccionado-1][0] : this.packs[this.seleccionado-1][1];
    }
    
    public void seleccionar(){
        System.out.print("Vamos a seleccionar los iconos con los que jugar");
        for (int y = 0; y < this.packs.length; y++) {
            System.out.print("\n"+(y+1)+")");
            for (int x = 0; x < this.packs[y].length; x++) {
                System.out.print(" "+this.packs[y][x]);
            }
        }
        System.out.println("\n"+(this.packs.length+1)+") Aleatorio");
        do {
            int op = pedirInt("Selecciona una opción [1-"+(this.packs.length+1)+"]: ", "Debe introducir un entero.");
            if (enRango(op, 1, this.packs.length+1)) {
                this.seleccionado = op;
                if (this.seleccionado==this.packs.length+1)    this.seleccionado = intAleatorio(1, this.packs.length);
                break;
            }else{
                System.out.println("Debe introducir un valor dentro del rango establecido.");
            }
        } while (true);
        
        
    }
    
    private static int intAleatorio(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    private boolean enRango(int a, int min, int max){
        return (a>=min&&a<=max);
    }
    
    private int pedirInt(String mensajePedida, String mensajeError){
        do{
            System.out.print(mensajePedida);
            if(TresEnRaya.teclado.hasNextInt()){
                return TresEnRaya.teclado.nextInt();
            }else{
                System.out.println(mensajeError);
            }
            TresEnRaya.teclado.next();
        }while(true);
    }
    
}
