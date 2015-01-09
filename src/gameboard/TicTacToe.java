package gameboard;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thibaud
 */
public class TicTacToe extends GameBoard {

    public TicTacToe(int longu, int largu) {
        super(3, 3);
    }

    public TicTacToe(int longu, int largu, List<Turn> history) {
        super(3, 3, history);
    }

    @Override
    void play(Turn turn) throws InvalidTurnException {
        if ((turn.position.x < 0) || (turn.position.x > this.length) || (turn.position.y < 0) || (turn.position.y > this.width)) {
            throw new InvalidTurnException("Bounds");
        } else if (this.board[turn.position.x][turn.position.y] != 0) {
            throw new InvalidTurnException("Taken");
        } else {
            this.board[turn.position.x][turn.position.y] = turn.player.number;
            this.history.add(turn);

        }
    }

    @Override
    void cancel() {
        Turn turn = this.lastTurn();
        this.board[turn.position.x][turn.position.y] = 0;
        history.remove(history.size());
    }

    @Override
    Player win() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
