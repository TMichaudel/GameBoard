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
public class Turn {
    private Position position;
    private Player player;
    
    public Turn(Position position, Player player){
        this.player = player;
        this.position = position;
    }
    
    public String toString(){
        return "le joueur " + player.toString() + " a joue " + position.toString();
    }
}
