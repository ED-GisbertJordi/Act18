/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.util.Scanner;
import juego.Coordenada;
import juego.Ficha;
import juego.Tablero;

/**
 *
 * @author Jordi Gisbert Ferriz
 */
public class TresEnRaya {
    
    private static Scanner teclado;
    
    
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        
        Tablero ta = new Tablero();
        ta.mostrar();
        ta.ponerFicha(new Coordenada(1, 1), Ficha.circulo);
        ta.ponerFicha(new Coordenada(1, 2), Ficha.circulo);
        ta.ponerFicha(new Coordenada(1, 3), Ficha.circulo);
        ta.mostrar();
        
        System.out.print(ta.hayTresEnRaya());
    }
}
