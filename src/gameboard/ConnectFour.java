/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameboard;

import java.util.List;

/**
 *
 * @author p1310207
 */
public class ConnectFour extends GameBoard {
    
    public enum Cell {
    vide("◌"), rouge("●"), jaune("○");
    String draw;
    private Cell(String draw){
        this.draw=draw;
    }
    };
    
    public ConnectFour(int longu, int largu) {
        super(longu, largu);
    }

    public ConnectFour(int longu, int largu, List<Turn> history) {
        super(longu, largu, history);
    }

    @Override
    void play(Turn turn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void cancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Player win() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
