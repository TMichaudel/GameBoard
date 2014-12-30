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
            //GameBoard board = new GameBoard(5,5);
        //Player p1 = new Player(1,board);

    }

    public static void play(GameBoard board, Player[] players) {
        int current = 0;
        Turn t;
        boolean validTurn;
        while (board.win() == null) {
            validTurn = false;
            while (!validTurn) {
                try {
                    t = players[current].play();
                    board.play(t);
                    validTurn = true;
                } catch (InvalidTurnException ex) {                  
                }
            }
            current=current+1 % 2;
        }
            System.out.println("Le joueur "+board.win().number+" a gagné");
    }


}
