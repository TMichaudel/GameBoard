package gameboard;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thibaud
 */
public class TicTacToe extends GameBoard {

    public TicTacToe(int longu, int largu) {
        super(3, 3);
    }

    public TicTacToe(int longu, int largu, List<Turn> history) {
        super(3, 3, history);
    }
    
    public enum Cell {

        vide("☺"), rouge("✕"), jaune("○");
        String draw;

        private Cell(String draw) {
            this.draw = draw;
        }
    };

    @Override
    void play(Turn turn) throws InvalidTurnException {
        if ((turn.position.x < 0) || (turn.position.x >= this.length) || (turn.position.y < 0) || (turn.position.y >= this.width)) {
            throw new InvalidTurnException("Bounds");
        } else if (this.board[turn.position.x][turn.position.y] != 0) {
            throw new InvalidTurnException("Taken");
        } else {
            this.board[turn.position.x][turn.position.y] = turn.player.number;
            this.history.add(turn);

        }
    }

    @Override
    void cancel() {
        Turn turn = this.lastTurn();
        if(turn!=null) {
        this.board[turn.position.x][turn.position.y] = 0;
        history.remove(history.size()-1);
        }
    }

    @Override
    Player win() {
        Turn turn = this.lastTurn();
        
         //Si aucun coup n'a été joué, on ne fait pas de vérification
        if (turn==null) {
            return null;
        }
                
        int num = turn.player.number;
        Position pos = turn.position;


        //verif horizontale
        int cpt = 1;
        int i = 1;
        while (smartBoard(pos.x - i, pos.y) == num) {
            cpt++;
            i++;
        }
        i = 1;
        while (smartBoard(pos.x + i, pos.y) == num) {
            cpt++;
            i++;
        }
        if (cpt >= 3) {
            return turn.player;
        }

        //verif verticale
        cpt = 1;
        i = 1;
        while (smartBoard(pos.x, pos.y - i) == num) {
            cpt++;
            i++;
        }
        i = 1;
        while (smartBoard(pos.x, pos.y + i) == num) {
            cpt++;
            i++;
        }
        if (cpt >= 3) {
            return turn.player;
        }

        //verif diagonale 1
        cpt = 1;
        i = 1;
        while (smartBoard(pos.x - i, pos.y - i) == num) {
            cpt++;
            i++;
        }
        i = 1;
        while (smartBoard(pos.x + i, pos.y + i) == num) {
            cpt++;
            i++;
        }
        if (cpt >= 3) {
            return turn.player;
        }

        //verif diagonale 2
        cpt = 1;
        i = 1;
        while (smartBoard(pos.x - i, pos.y + i) == num) {
            cpt++;
            i++;
        }
        i = 1;
        while (smartBoard(pos.x + i, pos.y - i) == num) {
            cpt++;
            i++;
        }
        if (cpt >= 3) {
            return turn.player;
        }

        return null;
        }
        
    @Override
    public String toString() {
        int[][] board = board();
        String strPlat;
        strPlat = "";
        int i, j;
        strPlat+= "  0☺1☺2 \n";
        for (i = 0; i < width; i++) {
            strPlat +=width-i-1+" ";
            for (j = 0; j < length; j++) {
                strPlat += TicTacToe.Cell.values()[board[j][width-i-1]].draw+" ";
            }
            strPlat = strPlat + "\n";
        }
        return strPlat;
    }
}
