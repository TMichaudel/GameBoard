/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathieu
 */
public class Smart extends Stupid {

    public Smart(int number, GameBoard board) {
        super(number, board);
    }
    
    @Override
    Turn play() {
        Turn lastT = board.lastTurn();
        Turn t;
        int i,j;
        for (i=-1;i<2;i++){
            for (j=-1;j<2;j++){
                t = new Turn (new Position (lastT.position.x+i,lastT.position.y+j),this);
                try {
                board.play(t);
                if (board.win()==this){
                    board.cancel();
                    return t;
                }
                board.cancel();
            } catch (InvalidTurnException ex) {
                
            }
            }
        }
        return super.play(); 
    }
}
