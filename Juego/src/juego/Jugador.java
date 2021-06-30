/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author USUARIO
 */
public class Jugador {
    
    //atributos jugador
    private String nombre;
    private Object colorFicha;
    private int casillaActual;
    private int turnoPerdido;
   
    
    //constructor que no recibe nada
    public Jugador(){
        this.casillaActual = 1;
        this.turnoPerdido =0; 
    }
    

    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getColorFicha() {
        return colorFicha;
    }

    public void setColorFicha(Object colorFicha) {
        this.colorFicha = colorFicha;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public int getTurnoPerdido() {
        return turnoPerdido;
    }

    public void setTurnoPerdido(int turnoPerdido) {
        this.turnoPerdido = turnoPerdido;
    }
    
}//cierra clase