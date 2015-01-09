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
        boolean v = false;
        Turn t;
        int res;
        for (res=0; res<8;res++){
            switch (res){
                case 1: t= new Turn (new Position (lastT.position.x+1,lastT.position.y), this);
                    break;
                case 2: t= new Turn (new Position (lastT.position.x-1,lastT.position.y), this);
                    break;
                case 3: t= new Turn (new Position (lastT.position.x,lastT.position.y+1), this);
                    break;
                case 4: t= new Turn (new Position (lastT.position.x,lastT.position.y-1), this);
                    break;
                case 5: t= new Turn (new Position (lastT.position.x-1,lastT.position.y-1), this);
                    break;
                case 6: t= new Turn (new Position (lastT.position.x-1,lastT.position.y+1), this);
                    break;
                case 7: t= new Turn (new Position (lastT.position.x+1,lastT.position.y-1), this);
                    break;
                case 8: t= new Turn (new Position (lastT.position.x+1,lastT.position.y+1), this);
                    break;
                default : t = null;
                    break;
            }
            try {
                board.play(t);
                if (board.win()==this){
                board.cancel();
                return t;
                }
            } catch (InvalidTurnException ex) {
                Logger.getLogger(Smart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return super.play(); 
    }
}
