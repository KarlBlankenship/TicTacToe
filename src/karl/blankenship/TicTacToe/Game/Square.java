/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karl.blankenship.TicTacToe.Game;

/**
 * This Class will represent a square in the TicTacToe grid. Each square will
 * contain a value or square number or X or O. Can add a get status method to
 * tell if it has been selected or not. 
 * @author Karl
 */
public class Square {
    
    private String contents; // Will hold square number or X or O

    public Square(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean squareAvailable() {
        if (contents.equals("X") || contents.equals("O"))
            return false;
        else
            return true;
    }
}
