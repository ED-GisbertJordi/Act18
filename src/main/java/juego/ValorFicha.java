/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author Jordi Gisbert Ferriz
 */
public enum  ValorFicha {
    
    equis{
        @Override
        public String toString() {
            return "X";
        }
    },
    circulo {
        @Override
        public String toString() {
            return "O";
        }
    }
}
