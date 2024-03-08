/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author Jordi Gisbert Ferriz
 */
public class Ficha {
    private ValorFicha valor;
    private Coordenada coordenada;
    
    public Ficha(ValorFicha valor){
        this.valor = valor;
    }
    
    public Ficha(ValorFicha valor, Coordenada coordenada){
        this.valor = valor;
        this.coordenada = coordenada;
    }
}
