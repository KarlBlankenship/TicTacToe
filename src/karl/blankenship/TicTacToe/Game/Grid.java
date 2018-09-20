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
    
    private String convertToString(Boolean x) {
        
        if (Boolean.TRUE.equals(x)) 
            return "X";
        else if (Boolean.FALSE.equals(x)) 
            return "O";
        else
         return " ";
        
    }
    
    public void displayGrid() {
        System.out.println("Game:");
        System.out.println("   |   |   ");
        System.out.println(" " + convertToString(topLeft) + " | " + 
                convertToString(topMiddle) + " | " + 
                convertToString(topRight) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + convertToString(middleLeft) + " | " + 
                convertToString(center) + " | " + 
                convertToString(middleRight) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + convertToString(bottomLeft) + " | " + 
                convertToString(bottomMiddle) + " | " + 
                convertToString(bottomRight) + " ");
        System.out.println("   |   |   ");
    }
    
    
}
