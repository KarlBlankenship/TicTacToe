/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karl.blankenship.TicTacToe.Game;

/**
 * The Grid class will hold the status of the 9 squares and have methods for
 * determining whether a selection is available, whether the grid is full and
 * whether there is a winning player.
 * @author Karl
 */
public class Grid {
    
    // Each square is a boolean field of either null, true (X) or false (O).
    private Boolean topLeft;
    private Boolean topMiddle;
    private Boolean topRight;
    private Boolean middleLeft;
    private Boolean center;
    private Boolean middleRight;
    private Boolean bottomLeft;
    private Boolean bottomMiddle;
    private Boolean bottomRight;
    
    private String convertToString(Boolean x, String square) {
        
        if (Boolean.TRUE.equals(x)) 
            return "X";
        else if (Boolean.FALSE.equals(x)) 
            return "O";
        else
            return square;
        
    }
    
    public void displayGrid() {
        // NEED TO SOMEHOW PUT SQUARE NUMBERS IN GRID INSTEAD OF SPACES
        
        System.out.println("Game:");
        System.out.println("   |   |   ");
        System.out.println(" " + convertToString(topLeft, "1") + " | " + 
                convertToString(topMiddle, "2") + " | " + 
                convertToString(topRight, "3") + " ");
        System.out.println("---+---+---");
        System.out.println(" " + convertToString(middleLeft, "4") + " | " + 
                convertToString(center, "5") + " | " + 
                convertToString(middleRight, "6") + " ");
        System.out.println("---+---+---");
        System.out.println(" " + convertToString(bottomLeft, "7") + " | " + 
                convertToString(bottomMiddle, "8") + " | " + 
                convertToString(bottomRight, "9") + " ");
        System.out.println("   |   |   ");
    }
    
    public void isEmpty(String number) {
       
    }
    
    
}
