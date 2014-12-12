/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thibaud
 */
abstract class GameBoard implements Serializable {

    public final int length;
    public final int width;
    private int[][] board;
    private List<Turn> history;

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
            play(turn);
            x++;
        }
    }

    //toutes les cases à 0

    private void initialiser() {
        int i, j;
        for (i = 1; i <= length; i++) {
            for (j = 1; j <= width; j++) {
                board[i][j] = 0;
            }
        }
    }

    abstract void play(Turn turn);

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

    public String toString() {
        String strPlat;
        strPlat = "";
        int i, j;
        for (i = 1; i <= length; i++) {
            for (j = 1; j <= width; j++) {
                strPlat+=board[i][j];
            }
            strPlat = strPlat + "\n";
        }
        return strPlat;
    }
}
