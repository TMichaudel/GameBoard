/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thibaud
 */
public class Game {

    public static void main(String[] args) {
        System.out.println("Bonjour, choississez votre jeu : \n [0] Puissance 4 \n [1] Morpion");
        Scanner sc = new Scanner(System.in);
        String xx = sc.nextLine();
        int Mode = Integer.parseInt(xx);
        int J1, J2;
        Player P1;
        Player P2;
        GameBoard board;
        
        if (Mode == 0) {
            board = new ConnectFour(0, 0);
            System.out.println("Choississez l'identitez du Joueur 1 : \n [0] Humain \n [1] Ordinateur \n [2] Chuck Noris");
            xx = sc.nextLine();
            J1 = Integer.parseInt(xx);
            System.out.println("Choississez l'identitez du Joueur 2 : \n [0] Humain \n [1] Ordinateur \n [2] Chuck Noris");
            xx = sc.nextLine();
            J2 = Integer.parseInt(xx);
            
            switch (J1) {
            case 0:
                P1 = new Humain(1, board);
                break;
            case 1:
                P1 = new Alea(1, board);
                break;
            case 2:
                P1 = new ChuckNoris(1, board);
                break;
            default:
                P1 = new Humain(2, board);
                break;
        }

        switch (J2) {
            case 0:
                P2 = new Humain(2, board);
                break;
            case 1:
                P2 = new Alea(2, board);
                break;
            case 2:
                P2 = new ChuckNoris(1, board);
                break;
            default:
                P2 = new Humain(2, board);
                break;
        }
            
            
        } else {
            board = new TicTacToe(0, 0);
            System.out.println("Choississez l'identitez du Joueur 1 : \n [0] Humain \n [1] Stupid \n [2] Smart");
            xx = sc.nextLine();
            J1 = Integer.parseInt(xx);
            System.out.println("Choississez l'identitez du Joueur 2 : \n [0] Humain \n [1] Stupid \n [2] Smart");
            xx = sc.nextLine();
            J2 = Integer.parseInt(xx);
            
            switch (J1) {
            case 0:
                P1 = new Humain(1, board);
                break;
            case 1:
                P1 = new Stupid(1, board);
                break;
            case 2:
                P1 = new Smart(2, board);
                break;
            default:
                P1 = new Humain(2, board);
                break;
        }

        switch (J2) {
            case 0:
                P2 = new Humain(2, board);
                break;
            case 1:
                P2 = new Stupid(2, board);
                break;
            case 2:
                P2 = new Smart(2, board);
                break;
            default:
                P2 = new Humain(2, board);
                break;
        }
        }

        Player[] players = new Player[2];
        players[0] = P1;
        players[1] = P2;
        play(board, players);
    }

    public static void play(GameBoard board, Player[] players) {
        int current = 0;
        Turn t;
        boolean validTurn;
        while ((board.win() == null && board.full() != true)) {
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
            current = (current + 1) % 2;
        }
        System.out.println(board.toString());
        if (board.full() == true) {
            System.out.println("Egalité");
        } else {

            System.out.println("Le joueur " + board.win().number + " a gagné");
        }
    }

}
