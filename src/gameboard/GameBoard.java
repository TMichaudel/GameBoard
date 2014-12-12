/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameboard;

import java.util.ArrayList;

/**
 *
 * @author Thibaud
 */
abstract class GameBoard {

    final int length;
    final int width;
    int[][] xboard;
    ArrayList<Turn> xhistory;

    public GameBoard(int longu, int largu) {
        length = longu;
        width = largu;
        xboard = new int[length + 1][width + 1];
        xhistory = new ArrayList<Turn>();
        initialiser();
    }

    public GameBoard(int longu, int largu, ArrayList<Turn> history) {
        length = longu;
        width = largu;
        xboard = new int[length + 1][width + 1];
        xhistory = new ArrayList<Turn>();
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
                xboard[i][j] = 0;
            }
        }
    }

    abstract void play(Turn turn);
    
    abstract void cancel();
    
    public Turn lastTurn() {
        Turn t;
        if (!xhistory.isEmpty()) {
            t = xhistory.get(xhistory.size() - 1);
            return t;
        } else {
            return null;
        }
    }

    abstract Player win();
    
    public int[][] board() {
        return xboard;
    }
    
     public String toString() {
        String strPlat;
        strPlat = "";
        int i, j;
        for (i = 1; i <= length; i++) {
            for (j = 1; j <= width; j++) {
                if (xboard[j][i] == 0) {
                    strPlat = strPlat + "◌ ";
                } else if (xboard[j][i] == 1) {
                    strPlat = strPlat + "● ";

                } else {
                    strPlat = strPlat + "○ ";
                }
            }
            strPlat = strPlat + "\n";
        }
        return strPlat;
    }
}
