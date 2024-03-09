/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

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
        return (ficha.equals(Ficha.equis))? packs[this.seleccionado][0] : packs[this.seleccionado][1];
    }
    
    public void seleccionar(){
        System.out.print("Vamos a seleccionar los iconos con los que jugar");
        for (int y = 0; y < packs.length; y++) {
            System.out.print("\n"+(y+1)+")");
            for (int x = 0; x < packs[y].length; x++) {
                System.out.print(" "+packs[y][x]);
            }
        }
        System.out.println("\n"+(packs.length+1)+") Aleatorio");
        do {
            int op = pedirInt("Selecciona una opción [1-"+(packs.length+1)+"]: ", "Debe introducir un entero.");
            if (enRango(op, 1, packs.length+1)) {
                this.seleccionado = op;
            }else{
                System.out.println("Debe introducir un valor dentro del rango establecido.");
            }
        } while (true);
        
        
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
