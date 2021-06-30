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
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JOptionPane;



public class TableroAvanzado extends Tablero{
    
   //el constructor sera el mismo
    public TableroAvanzado(int numeroCasillas, Jugador[] jugador, Casilla[] casilla, int numerojugadores) {
       super(numeroCasillas, jugador, casilla, numerojugadores);
    }
    
    /*
     * metodo que sobreescribe el padre
     * lo que se modifica en este metodo es que se agrega la condicion en caso
     * que la ficha caiga en una casilla que sea cambia tablero.
     */
    
    @Override
    public void parteLogicaJuego(){
        
        //---------------LOGICA DEL JUEGO   
        //condicion para arreglar lo que avanza la ficha en caso que se pase del numero total de casillas
        if((jugador[jugadorActual].getCasillaActual()+saltor)>=numeroCasillas)
        {
            saltor = numeroCasillas - jugador[jugadorActual].getCasillaActual(); 
        }


        //se muestran los datos al jugador 
        datos1.setText (datos1.getText() + "\nJugador   #"+jugadorActual+"  : " + jugador[jugadorActual].getNombre() + "\n");     
        datos1.setText (datos1.getText() + "  Estaba en: "+ jugador[jugadorActual].getCasillaActual() + "\n");
        datos1.setText (datos1.getText() + "  Dados    : "+ dador1 + "," + dador2 + " = " + (dador1+dador2)+ "\n");
        datos1.setText (datos1.getText() + "  Avanza a : " +(jugador[jugadorActual].getCasillaActual()+saltor)+ "\n");     
     
        
       jugador[jugadorActual].setCasillaActual(jugador[jugadorActual].getCasillaActual()+saltor);             
      
       while (true) {
      
              if (casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals("Simple") )
               {
                  datos1.setText (datos1.getText() + "  Cae en simple\n");               
                   break;
               }

           
              if ( casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals( "Pierde Turno") ){   //se le pone un turno perdido al jugador en la lista de turnos perdidos en la misma posicion
                  datos1.setText(datos1.getText() + "  Cae en Pierde Turno " + "\n");
                  jugador[jugadorActual].setTurnoPerdido(jugador[jugadorActual].getTurnoPerdido()+1);
                  break;
              }     
              if ( 
                  casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals("Escalera")
                  ||
                  casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals("Avanza")
                 )

               {// then if
                   datos1.setText(datos1.getText() + "  Cae en " + casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla() + "\n");           
                  
                   if (casilla[jugador[jugadorActual].getCasillaActual()].getMovimientoN()+jugador[jugadorActual].getCasillaActual()>=numeroCasillas){
                          jugador[jugadorActual].setCasillaActual(numeroCasillas);
                          datos1.setText(datos1.getText()+ " se mover\u00e1 a" + numeroCasillas + "\n") ;
                      }
                   else{
                       
                       jugador[jugadorActual].setCasillaActual( casilla[jugador[jugadorActual].getCasillaActual()].getMovimientoN()
                       +jugador[jugadorActual].getCasillaActual());
                       datos1.setText(datos1.getText()+ " se mover\u00e1 a" + jugador[jugadorActual].getCasillaActual() + "\n") ;
                       }

                 repaint(); 
                 continue;
                }  

               //concdicion para mover la serpiente
              if(casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals("Serpiente")){
                  datos1.setText(datos1.getText() + "  Cae en Serpiente " + "\n");          
                  if(jugador[jugadorActual].getCasillaActual()+casilla[jugador[jugadorActual].getCasillaActual()].getMovimientoN()<=1){
                          jugador[jugadorActual].setCasillaActual(1);
                          datos1.setText(datos1.getText()+ " se mover\u00e1 a" + 1 + "\n") ;
                      }
                  else{
                      jugador[jugadorActual].setCasillaActual(jugador[jugadorActual].getCasillaActual()+ casilla[jugador[jugadorActual].getCasillaActual()].getMovimientoN());
                      datos1.setText(datos1.getText()+ " se mover\u00e1 a " + jugador[jugadorActual].getCasillaActual() + "\n") ;
                      }
                      repaint();//se actualiza la posicion grafica de la ficha
                      continue;     
                  }
               if (casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals("Cambia Tablero")){
                  
                  datos1.setText(datos1.getText() + "cambia tablero\n ");
                  
                 
                  for (int cont = 1; cont<=(int)numeroCasillas;cont++){
                      casilla[cont].setTipoCasilla("Simple");
                  }

                  // se hacen 5 casillas aleatorias de PIERDE TURNO 
        
                   Random aleatorio = new Random();
                  for (int h = 1; h<=5;h++){
                      int variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;//variable de posicion
                       while(true){
                            if (variable_aleatoria == 1|| variable_aleatoria ==numeroCasillas){
                                variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }
                            break;
                        }
                        casilla[variable_aleatoria].setTipoCasilla("Pierde Turno");
                   }



                    for (int a=1;a<=5;a++){
                        int variable_aleatoria = aleatorio.nextInt((int)numeroCasillas)+1;
                        while(true)//ciclo para validar la posicion de las casillas
                        {   
                            if(variable_aleatoria==1||variable_aleatoria==numeroCasillas)
                            {
                                variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }
                            break;
                        }
                        casilla[variable_aleatoria].setTipoCasilla("Tira de Nuevo");
                    }
                    //creacion de CASILLAS CAMBIA TABLERO
                    for (int i =1;i<=5;i++)
                    {
                        int variable_aleatoria=aleatorio.nextInt((int)numeroCasillas)+1;
                        while(true)
                        {   
                            if(variable_aleatoria==1||variable_aleatoria==numeroCasillas)
                            {
                                variable_aleatoria = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }
                            break;
                        }
                        casilla[variable_aleatoria].setTipoCasilla("Cambia Tablero");//se hacen las casillas de cambia tablero

                    }


                
                    int variable_avanza;
                    for (int k = 1;k<=5;k++){
                        int variable_aleatoria2 = aleatorio.nextInt((int)(numeroCasillas))+1;//posicion de donde estara

                        do {
                                variable_avanza = aleatorio.nextInt(20)+1;
                                
                                if (( variable_aleatoria2 + variable_avanza ) >= (int) numeroCasillas){
                                    variable_aleatoria2 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                    continue;
                                }
                                
                                if (variable_aleatoria2 == 1){
                                    variable_aleatoria2 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                    continue;
                                }
                                //condicion para que la posicion final no sea en la casilla final
                                if((variable_aleatoria2)== numeroCasillas){
                                    variable_aleatoria2 = aleatorio.nextInt((int)numeroCasillas)+1;
                                    continue;
                                }
  
                                if (variable_avanza <= Math.sqrt((int)numeroCasillas)){
                                    continue;
                                }
                                break;
                        } while ( true ) ;
                        casilla[variable_aleatoria2].setTipoCasilla("Escalera");
                        casilla[variable_aleatoria2].setMovimientoN(variable_avanza);


                    }//cierra for de escalera

         
                    for (int l = 1;l<=5;l++){

                        int variable_aleatoria3 = aleatorio.nextInt((int)(numeroCasillas))+1;


                        do{

                            variable_avanza = aleatorio.nextInt(20)+1;
                            variable_avanza= -variable_avanza;
                            if ((variable_avanza+variable_aleatoria3)<=1){
                                variable_aleatoria3 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }    
                            if (casilla[variable_avanza+variable_aleatoria3].getTipoCasilla().equals("Escalera")){
                                variable_aleatoria3 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }
                            //condicionpara que lo que avanza no sea mayor que el numero de filas
                            if (-variable_avanza <= Math.sqrt((int)numeroCasillas))
                                continue;

                            if (variable_aleatoria3 == numeroCasillas){
                                variable_aleatoria3 = aleatorio.nextInt((int)numeroCasillas)+1;
                                continue;
                            }


                            break;
                        }
                        while(true);
                       
                        casilla[variable_aleatoria3].setTipoCasilla("Serpiente");
                        casilla[variable_aleatoria3].setMovimientoN(variable_avanza);

                    }

                   
                    for (int m = 1;m<=5;m++){
                        int variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;

                        do{
                            variable_avanza = aleatorio.nextInt(5)+1;
                            if ((variable_avanza+variable_aleatoria4) >(int)(numeroCasillas)){
                                variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }
                           
                             if (casilla[variable_avanza+variable_aleatoria4].getTipoCasilla().equals("Serpiente")){
                                 variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            }
                            if (variable_aleatoria4==1){
                                variable_aleatoria4 = aleatorio.nextInt((int)(numeroCasillas))+1;
                                continue;
                            } 
                            break; 

                        }while(true);
                            casilla[variable_aleatoria4].setTipoCasilla("Avanza");
                            casilla[variable_aleatoria4].setMovimientoN(variable_avanza);

                    }//cierra for
                    super.casillaActual=1;
                    super.posX = 0;
                    super.posY = tamanoPanelY-tamanoCasillaY;
                    super.anadirCasillas(filas, columnas);
                    
                    
            }         
            
                break;
            }
            if (dador1==1&&dador2==1){
                jugador[jugadorActual].setTurnoPerdido(jugador[jugadorActual].getTurnoPerdido()+1);
                datos1.setText(datos1.getText() + "pierde turno: saco 1 y 1"+ "\n");
            }
            
            repaint(); 
            if ( jugador[jugadorActual].getCasillaActual() == (int) numeroCasillas){
                datos1.setText(datos1.getText() +"\n="
                        + "====\nGANADOR " + " Jugador # "+ jugadorActual + "\n" +jugador[jugadorActual].getNombre());
                JOptionPane.showMessageDialog(null, "\n=====\nGANADOR " + " Jugador # "+ jugadorActual + "\n" +jugador[jugadorActual].getNombre());
                tirarDados.setEnabled(false);
            }
    
    }
    
    
    /*
     * metodo para cambiar las condiciones del control de turnos
     * es necesario para completar la fase 2, ya que en caso de que el jugador
     * saque dado 1 y 1, se le volvera a dar otro turno y tambien en caso que 
     * caiga en la casilla tira de nuevo.
     */
    
    
    public void controlDeTurnosAvanzado(){
        if ((dador1==6&&dador2==6)||(casilla[jugador[jugadorActual].getCasillaActual()].getTipoCasilla().equals("Tira de Nuevo"))){
               datos1.setText(datos1.getText() + " Tira de Nuevo\n  " );
        }
        else{
            controlDeTurnos();
        }
            
            
        
    }
    
    /*
     * se sobre escribe el metodo del boton porque cambian algunas condiciones 
     * en el tablero avanzado
     * tipo void, recibe actionevent
     */
    @Override
    public void actionPerformed(ActionEvent evento){
        String accion = evento.getActionCommand();
        if (accion.equals("tirar")){
            music(); 
            agregarDados();                                                     
            parteLogicaJuego();                                                                     
            controlDeTurnosAvanzado();      
            

        } 
        if(accion.equals("salir")){
           int confirmado = JOptionPane.showConfirmDialog(null,"¿Desea Salir del juego?");

           if (JOptionPane.OK_OPTION == confirmado)
               System.exit(0);

        }                                           
                                                        
     }
                                                
}