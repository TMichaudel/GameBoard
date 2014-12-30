/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameboard;

/**
 *
 * @author Thibaud
 */
public class InvalidTurnException extends Exception{
      public InvalidTurnException(String str){
          if(str=="Bounds") {
              System.out.println("Le coup n'est pas dans les bornes du plateau");
          }
          else if(str=="Taken") {
              System.out.println("La place est déjà occupée");
          }
          else if(str=="Gravite") {
              System.out.println("La gravité n'est pas respectée");
          }
    
  }  
}
