/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameboard;

import java.io.Serializable;

/**
 *
 * @author Thibaud
 */
public class Turn implements Serializable {
    public Position position;
    public Player player;
    
    public Turn(Position position, Player player){
        this.player = player;
        this.position = position;
    }
    
    public String toString(){
        return "le joueur " + player.toString() + " a joue " + position.toString();
    }
}
