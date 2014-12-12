/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.util.Scanner;

/**
 *
 * @author Thibaud
 */
public class Humain extends Player {

    public Humain(int number, GameBoard board) {
        super(number, board);
    }

    @Override
    Turn play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir les coordonnées de votre coup");
        String x = sc.nextLine();
        String y = sc.nextLine();
        Position Pos =  Position.parse(x+","+y);
        Turn t = new Turn(Pos, this);
        return t;
    }

}
