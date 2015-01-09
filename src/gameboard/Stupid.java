/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author mathieu
 */
public class Stupid extends Player {
    
    public Stupid (int number, GameBoard board) {
        super(number, board);
    }

    @Override
    Turn play() {
        Turn lastT = this.board.lastTurn();
        int count = 1;
        Position p = new Position(intValue(Math.random()*this.board.width),(intValue(Math.random()*this.board.width)));
        
        while (lastT.position.x!=p.x-1 && //horizontal
                lastT.position.x!=p.x+1 && 
                lastT.position.y!=p.y-1 && //vertical
                lastT.position.y!=p.y+1 && 
                (lastT.position.x!=p.x-1 || lastT.position.y != p.y-1) && //diagonale 1
                (lastT.position.x!=p.x+1 || lastT.position.y != p.y+1) &&
                (lastT.position.x!=p.x-1 || lastT.position.y != p.y+1) && //diagonale 2
                (lastT.position.x!=p.x+1 || lastT.position.y != p.y-1)){
            if (count == 10){//cas ou il n'y a rien a coté pour éviter qu'il tourne en boucle, il renvoit un coup au hasard
                Turn t = new Turn(p,this);
                return t;
            }
            p = new Position(intValue(Math.random()*this.board.width),(intValue(Math.random()*this.board.width)));
            count++;
        }
        Turn t = new Turn (p,this);
        return t;
    }
    
}
