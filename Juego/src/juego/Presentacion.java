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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Presentacion{

    //atributos que el usuario tiene que ingresar
    private final String nivelDificultad;
    private Object numeroJugadores;
    private Object numeroCasillas;
    
    //constructor
    public Presentacion(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("presentacion.png"));
        JLabel presentacion = new JLabel(imagen);
        presentacion.setSize(500, 500);
        presentacion.setVisible(true);
        Object seleccion = JOptionPane.showInputDialog(null,"Elija un dificultad","Selector de dificultad",
        JOptionPane.QUESTION_MESSAGE,imagen,  
        new Object[] { "Nivel facil", "Nivel avanzado" },"Nivel avanzado");
        while(seleccion == null){
            JOptionPane.showMessageDialog(null,"Por favor escoja una dificultad");
             seleccion = JOptionPane.showInputDialog(null,"Elija un dificultad","Selector de dificultad",
        JOptionPane.QUESTION_MESSAGE,imagen,  
        new Object[] { "Nivel facil", "Nivel avanzado" },"Nivel avanzado");
            
        }
        this.nivelDificultad= seleccion.toString();
    }
   
    public String getNivelDificultad() {
        return nivelDificultad;
    }
    public Object getNumeroCasillas() {
        return numeroCasillas;
    }
    public Object getNumeroJugadores() {
        return numeroJugadores;
    }    
    /*
     * metodo para pedir el numero de casillas y jugadores al usuario
     * tipo void, no regresa nada ni recibe nada
     */
    public void pedirDatosUsuario(){
        //condicion si escoge el nivel facil
        if (nivelDificultad.equals("Nivel facil"))
        {
             (this.numeroCasillas) = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de Casillas",   ""
             + "Casillas",   JOptionPane.QUESTION_MESSAGE,null,  
            new Object[] {25,36, 49, 64 },64);

            while(numeroCasillas == null){//ciclo para forzar al usuario a que ingrese los datos
                JOptionPane.showMessageDialog(null,"Por favor escoja un numero de casillas");
                numeroCasillas = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de Casillas",  
                        "Casillas",   JOptionPane.QUESTION_MESSAGE,null,  
                new Object[] {25,36, 49, 64 },64);
            }
        }//cierra if nivel facil  
        
    
        if (nivelDificultad.equals("Nivel avanzado"))
        {
             numeroCasillas = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de Casillas",   
                     "Casillas",   JOptionPane.QUESTION_MESSAGE,null,
            new Object[] {81,100, 121},81);

            while(numeroCasillas == null){//ciclo para forzar al usuario a que ingrese los datos
                JOptionPane.showMessageDialog(null,"Por favor escoja un numero de casillas");
                numeroCasillas = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de Casillas",  
                        "Casillas",   JOptionPane.QUESTION_MESSAGE,null,  
                new Object[] {81,100, 121},81);
            }
        }
               
 
        numeroJugadores = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de jugadores",   
                "Jugadores",   JOptionPane.QUESTION_MESSAGE,null,  
        new Object[] { "contra computadora", 2, 3,4 },   "");
        while(numeroJugadores == null){//programacion defensiva
            JOptionPane.showMessageDialog(null,"Por favor escoja un numero de jugadores");
            numeroJugadores = JOptionPane.showInputDialog(null, "Seleccione el n\u00famero de jugadores",   
                    "Jugadores",   JOptionPane.QUESTION_MESSAGE,null,  
            new Object[] { "contra computadora", 2, 3,4 },   "");
        }
 
        if (numeroJugadores.equals("contra computadora")){
            numeroJugadores = 1;
        }
    }
}