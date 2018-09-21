/*
 * TicTacToe game written to advance my abilities in coding. The plan is to 
 * evolve this game as my capabilities increase.
 */
package karl.blankenship.TicTacToe.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This class contains the main method for playing the game.
 * @author Karl
 */
public class PlayGame {

    private List<Square> squares; // Will hold a list of Square objects.
    private boolean gameOver; // Flag for game to determine when it is over.
    private Random random; // For generating random numbers.
    private boolean playerTurn; // Flag for knowing when it is players turn.
    private boolean emptySquares; // May turn this into a method.
    
    /**
     * Constructor.
     */
    public PlayGame() {  // NEED TO FINISH CONSTRUCTOR
        
        // Generate list of squares.
        squares = new ArrayList();
        for (int i = 0; i < 9; i++) {
            squares.add(new Square(Integer.toString(i+1)));
        }
        
    }
    
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
                    
        //TEst area
        PlayGame game = new PlayGame();
        for (int x = 0; x < 9; x++) {
            System.out.println("Square: " + game.squares.get(x).getContents());
        }

        

        // Setup a keyboard system object for keyboard player square entry.
        Scanner keyboard = new Scanner(System.in); // 

        // Set game over flag to false.
        
        
        // Create objects to represent squares. // NEED SQUARE CLASS.
        // Created a grid class
        //Grid grid = new Grid();
        
        // Select whether player or computer goes first randomly by boolean
        // flag such as true for player and false for computer.
        //Random random = new Random();
        //boolean playerTurn = random.nextBoolean();
        
        // Display instructions and grid
        //grid.displayGrid();
        //System.out.println("Please type the number of the square you"); 
        //System.out.println("would like to select and hit <Enter>");   
        //System.out.println("when prompted as your turn.");
        //System.out.println("You are X's and 3 in a row wins!");
        

        
        System.out.println("hello");
        
        // Set an empty squares flag (or could use a counter since 9 turns is
        // the most.
        //boolean emptySquares = true;
        
        // While game is not over AND there are empty Squares.
    /*    while (!gameOver && emptySquares) {
            // If it is player turn
            if (playerTurn) {
                // Prompt player to type in a square by 
                grid.displayGrid();
                System.out.println("Players Turn:");
                System.out.println("Please type a square number " + 
                        "and hit <enter>");
                // number and hit enter (Eventually upgrade to a graphic 
                // where grid can be clicked with a mouse.)
                
                // Read input.
                String input = keyboard.nextLine();
   
                // If input is valid.
                if (input.equals("1") ||
                    input.equals("2") ||
                    input.equals("3") ||
                    input.equals("4") ||
                    input.equals("5") ||
                    input.equals("6") ||
                    input.equals("7") ||
                    input.equals("8") ||
                    input.equals("9")) {
                    
                    // If square is empty
                    if

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
                }
                // Else, if input is not valid
                    //Display a message that input is not valid
            }       
                
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
         */       
    }
    
}
