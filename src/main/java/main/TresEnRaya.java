/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.util.Scanner;
import juego.Ficha;
import juego.Jugador;
import juego.Tablero;

/**
 *
 * @author Jordi Gisbert Ferriz
 */
public class TresEnRaya {
    public static Scanner teclado;
    private Tablero tablero;
    private Jugador[] jugadores;
    
    public TresEnRaya() {
        this.tablero = new Tablero();
        this.jugadores = new Jugador[2];
    }
    
    
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        boolean seguir = true;
        
        do {
            tresEnRaya.jugar();
            do {
                char siNo = Character.toUpperCase(tresEnRaya.pedirChar("¿Quieres volver a jugar? [S/N]:"));
                if (siNo=='S'||siNo=='N'){
                    if (siNo=='N')  seguir = false;
                    break;
                }else   System.out.println("¡Error! Debes introducir S o N");
            } while (true);
        } while (seguir);
        
    }
    
     private void jugar(){         
        this.jugadores[0] = new Jugador(Ficha.equis);
        this.jugadores[1] = new Jugador(Ficha.circulo);
        this.tablero.vaciar();
        
        System.out.println("Vamos a jugar al Tres en Raya\n");
        this.tablero.mostrar();
        System.out.println("");
        boolean finPartida = false;
        do {
            for (Jugador jugador : this.jugadores) {
                jugador.ponerFicha(this.tablero);
                this.tablero.mostrar();
                if (this.tablero.hayTresEnRaya()){
                    System.out.println("");
                    jugador.cantarVictoria();
                    finPartida=true;
                    break;
                }else{
                    if (this.tablero.estaLleno()){
                        System.out.println("\nLa partida ha finalizado en empate");
                        finPartida=true;
                        break;
                    }
                }
            }
        } while (!finPartida);
    }
     
     private char pedirChar(String mensajePedida){
        System.out.print(mensajePedida);
        return teclado.next().charAt(0);
    }
}
