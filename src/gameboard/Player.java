/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameboard;

/**
 *
 * @author Thibaud
 */
abstract class Player {
    final int number;
    final GameBoard board;
    
    public Player (int number, GameBoard board){
        this.board = board;
        this.number = number;
    }
    
    abstract Turn play();
}
