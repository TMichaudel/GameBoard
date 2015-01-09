package gameboard;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thibaud
 */
public class ChuckNoris extends Player {

    public ChuckNoris(int number, GameBoard board) {
        super(number, board);
    }

    @Override
    Turn play() {
        Scanner sc = new Scanner(System.in);
        Turn t;
        boolean validTurn = false;
        String x;
        String y;
        while (!validTurn) {
            try {
                System.out.println("Veuillez saisir les coordonnées de votre 1er coup ô Seigneur");
                x = sc.nextLine();
                y = sc.nextLine();
                Position Pos = Position.parse(x + "," + y);
                t = new Turn(Pos, this);
                board.play(t);
                validTurn = true;
            } catch (InvalidTurnException ex) {
            }
        }
        System.out.println("Veuillez saisir les coordonnées de votre 2nd coup ô Seigneur");
        x = sc.nextLine();
        y = sc.nextLine();
        Position Pos = Position.parse(x + "," + y);
        t = new Turn(Pos, this);
        return t;
    }
}
