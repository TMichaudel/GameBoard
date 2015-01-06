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
 * @author Thibaud
 */
public class Game {

    public static void main(String[] args) {
     ConnectFour board = new ConnectFour(0,0);
     Humain P1 = new Humain(1,board);
     Alea P2 = new Alea(2,board);
     Player[] players = new Player[2];
     players[0]=P1;
     players[1]=P2;
     play(board,players);
    }

    public static void play(GameBoard board, Player[] players) {
        int current = 0;
        Turn t;
        boolean validTurn;
        while (board.win() == null) {
            System.out.println(board.toString());
            validTurn = false;
            while (!validTurn) {
                try {
                    t = players[current].play();
                    board.play(t);
                    validTurn = true;
                } catch (InvalidTurnException ex) {                  
                }
            }
            current=(current+1) % 2;
        }
            System.out.println("Le joueur "+board.win().number+" a gagné");
    }


}
