/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import main.TresEnRaya;

/**
 *
 * @author Jordi Gisbert Ferriz
 */
public class Jugador {
    private Ficha ficha;
    private Simbolos simbolo;
    
    public Jugador(Ficha valor, Simbolos simbolo){
        this.ficha = valor;
        this.simbolo = simbolo;
    }
    
    public void cantarVictoria() {
        System.out.println("¡El jugador "+simbolo.obtenerSimbolo(this.ficha)+" es el ganador!");
    }
    
    public void ponerFicha(Tablero tablero) {
        do {
            System.out.println("Jugador con "+simbolo.obtenerSimbolo(this.ficha));
            Coordenada coordenada = recogerCoordenada();
            if (!tablero.isOcupada(coordenada)) {
                tablero.ponerFicha(coordenada, this.ficha);
                break;
            }else{
                System.out.println("¡Error! Coordenada ocupada en el tablero");
            }
        } while (true);
    }
    
    private Coordenada recogerCoordenada(){
        final int DIMENSIONES = Tablero.DIMENSIONES;
        do {
            int fila = pedirInt("Introduce Fila [1-"+DIMENSIONES+"]: ","¡Error! Debe introducir un número entero");
            int columna = pedirInt("Introduce Columna [1-"+DIMENSIONES+"]: ","¡Error! Debe introducir un número entero");
            Coordenada co = new Coordenada(fila, columna);
            if (co.isValida(DIMENSIONES))   return new Coordenada(fila, columna);
            System.out.println("¡Error! Introduce una coordenada válida");
        } while (true);
    }
    
    private static int pedirInt(String mensajePedida, String mensajeError){
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
