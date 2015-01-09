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

    public Stupid(int number, GameBoard board) {
        super(number, board);
    }

    @Override
    Turn play() {
        Turn lastT = this.board.lastTurn();
        if (lastT == null) {
            Turn t = new Turn(new Position(intValue(Math.random() * this.board.width), (intValue(Math.random() * this.board.width))), this);
            return t;
        } else {
            int i, j;
            boolean caselibre = false;
            for (i = -1; i < 2; i++) {
                for (j = -1; j < 2; j++) {
                    if (board.smartBoard2(i + lastT.position.x, j + lastT.position.y) == 0) {
                        caselibre = true;
                    }
                }
            }
            if (caselibre = true) {

                Position p = new Position(intValue(Math.random() * this.board.width), (intValue(Math.random() * this.board.width)));
                Position p1 = null;
                boolean ok = false;
                while (!ok) {
                    for (i = -1; i < 2; i++) {
                        for (j = -1; j < 2; j++) {
                            if ((lastT.position.x == p.x + i) && (lastT.position.y == p.y + j)) {
                                p1 = p;
                                ok = true;
                            }
                        }
                    }
                    p = new Position(intValue(Math.random() * this.board.width), (intValue(Math.random() * this.board.width)));
                }
                Turn t = new Turn(p1, this);
                return t;
            } else {
                Turn t = new Turn(new Position(intValue(Math.random() * this.board.width), (intValue(Math.random() * this.board.width))), this);
                return t;
            }
        }
    }

}
