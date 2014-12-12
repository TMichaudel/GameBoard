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
public class Position {
    int x;
    int y;
    
    public Position( int a, int b) {
        this.x=a;
        this.y=b;
    }
    
    public String toString() {
        return "x="+x+"/ny="+y;
    }
    
    public static Position parse(String str) {
        String[] coos=str.split(",");
        int x = Integer.parseInt(coos[0]);
        int y = Integer.parseInt(coos[1]);
        return new Position(x,y);
    }
}
