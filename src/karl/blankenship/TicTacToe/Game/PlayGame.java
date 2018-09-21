/*
 * TicTacToe game written to advance my abilities in coding. The plan is to 
 * evolve this game as my capabilities increase.
 */
package karl.blankenship.TicTacToe.Game;

import java.util.Scanner;
import java.util.Random;

/**
 * This class contains the main method for playing the game.
 * @author Karl
 */
public class PlayGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Psuedo Code of how I think the game should flow.
            /*
                I am trying to figure out whether I should make each of the 
                9 possible squares its own object and add them all to a
                collection or should I create a Glid class that has fields
                for each of the 9 squares so I can use a single instance.
                I am going to try the Grid Class first.
        */
                    
        // Setup a keyboard system object for keyboard player square entry.
        Scanner keyboard = new Scanner(System.in); // input = keyboard.nextInt()

        // Set game over flag to false.
        boolean gameOver = false;
        
        // Create objects to represent squares. // NEED SQUARE CLASS.
        // Created a grid class
        Grid grid = new Grid();
        
        // Select whether player or computer goes first randomly by boolean
        // flag such as true for player and false for computer.
        Random random = new Random();
        boolean userTurn = random.nextBoolean();
        
        // Display instructions and grid
        grid.displayGrid();
        System.out.println("Please type the number of the square you"); 
        System.out.println("would like to select and hit <Enter>");   
        System.out.println("when prompted as your turn.");
        System.out.println("You are X's and 3 in a row wins!");
        
        // Set an empty squares flag (or could use a counter since 9 turns is
        // the most.
        boolean emptySquares = true;
        
        // While game is not over AND there are empty Squares.
            
            // If it is player turn
                // Prompt player to type in a square by 
                // number and hit enter (Eventually upgrade to a graphic 
                // where grid can be clicked with a mouse.
                
                // If input is valid.
                    
                    // If square is empty

                        // Update square object

                        // Display updated board.

                        // Change player flag so it is computers turn.

                        // Check/set empty squares flag

                        // Check to see if player won. 
                            // NEED A CHECK FOR WIN METHOD.

                        // If player wins, display message and 
                        //set game flag to over

                    // Else, square is already taken, Display message that 
                    // square is already taken.
                
                // Else, if input is not valid
                    //Display a message that input is not valid
                   
                
            // ELSE (if it is computer turn)
                // Display a message that computer is thinking.
                
                // Slight delay for effect.
                
                // Have computer randomly select an available square.
                // Eventually add a strategy for the computer to follow.
                // for now write a computer select method that can be updated.
                
                // Update the selected square instance.
                
                // Display updated board.
                
                // Change the player flag so it will become the players turn.
                
                // Check/set empty squares flag.
                
                // Check to see if Computer won using a win method.
                
                // If computer wins, display a message and set game flag to over
               
                
    }
    
}
