/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thibaud
 */
abstract class GameBoard implements Serializable {

    public final int length;
    public final int width;
    protected int[][] board;
    protected List<Turn> history;

    public GameBoard(int longu, int largu) {
        length = longu;
        width = largu;
        board = new int[length + 1][width + 1];
        history = new ArrayList<Turn>();
        initialiser();
    }

    public GameBoard(int longu, int largu, List<Turn> history) {
        length = longu;
        width = largu;
        board = new int[length + 1][width + 1];
        this.history = new ArrayList<Turn>();
        initialiser();
        int i, j, x = 0;
        Turn turn;
        for (i = 0; i < history.size(); i++) {
            turn = history.get(x);
            try {
                play(turn);
            } catch (InvalidTurnException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
            x++;
        }
    }

    //toutes les cases à 0
    private void initialiser() {
        int i, j;
        for (i = 0; i < width; i++) {
            for (j = 0; j < length; j++) {
                board[i][j] = 0;
            }
        }
    }

    abstract void play(Turn turn) throws InvalidTurnException;

    abstract void cancel();

    public Turn lastTurn() {
        Turn t;
        if (!history.isEmpty()) {
            t = history.get(history.size() - 1);
            return t;
        } else {
            return null;
        }
    }

    abstract Player win();

    public int[][] board() {
        return board;
    }

    public boolean full() {
        int i, j;
        for (i = 0; i < width; i++) {
            for (j = 0; j < length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String strPlat;
        strPlat = "";
        int i, j;
        for (i = 0; i < length; i++) {
            for (j = 0; j < width; j++) {
                strPlat += board[i][j];
            }
            strPlat = strPlat + "\n";
        }
        return strPlat;
    }
}
