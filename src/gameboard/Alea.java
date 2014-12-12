/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameboard;

import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author p1310207
 */
public class Alea extends Player {

    public Alea(int number, GameBoard board) {
        super(number, board);
    }

    @Override
    Turn play() {
        Position p = new Position(intValue(Math.random()*this.board.width),(intValue(Math.random()*this.board.width)));
        Turn t = new Turn (p,this);
        return t;
    }
    
}
