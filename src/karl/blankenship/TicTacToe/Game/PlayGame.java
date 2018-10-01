/*
 * TicTacToe game written to advance my abilities in coding. The plan is to 
 * evolve this game as my capabilities increase.
 */
package karl.blankenship.TicTacToe.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * This class contains the main method for playing the game.
 * @author Karl
 */
public class PlayGame {

    private static List<Square> squares; // Will hold a list of Square objects.
    private static boolean gameOver; // Flag for game to determine when it is over.
    private static Random random; // For generating random numbers.
    private static boolean playerTurn; // Flag for knowing when it is players turn.
    private static Scanner keyboard; // Will hold player keyboard input.
    
    /**
     * Constructor.
     */
    public PlayGame() {
        
        // Generate a list of square instances and set initial value.
        // Zero object is created but not used.
        squares = new ArrayList();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square(Integer.toString(i)));   
        }
        
        // Set gameOver flag to false to start game.
        gameOver = false;
        
        // Select whether player or computer goes first randomly by boolean
        random = new Random();
        playerTurn = random.nextBoolean();
    }
    
    /**
     * Main method.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
                            
        // Create a new instance of PlayGame class to build the game.
        PlayGame game = new PlayGame();
       
        // Display the initial game board with a welcome message and
        // instructions.
        display("board");
        display("welcome");        
      
        // While game is not over AND there are empty Squares.
        while (!gameOver && emptySquares()) {
            
            if (playerTurn) {
              
                // Retrieve the players input.
                // Player has three attempts to enter a correct square.
                int sq = getPlayerInput(3);
                
                // Once three invalid attempts have been made, game over.
                if (sq == -1) {
                    gameOver = true;
                    System.out.println("Sorry, You Lost.");
                }
                else // if the input was valid, the object is set to X.
                    squares.get(sq).setContents("X");
               
                // Check to see if the input resulted in a win.
                // If player won, display and end game.
                // Else, set the turn to the computer.
                if (checkForWin("X")) {
                    display("board");
                    System.out.println("Congrats! You win!");
                    gameOver = true;
                }
                else {
                    playerTurn = false;
                    display("board");
                }
            }    
            // Computers turn to select a square.
            else { 
                // Notify the player that the computer is working on a pick.
                System.out.println("Computer is thinking...");
                Thread.sleep(1000);
                // Retrieve the computers input and set the object to O.
                // The computer should always return a valid square.
                int csq = getComputerInput();
                squares.get(csq).setContents("O");
                // Check for win, display output and set flags as appropriate.
                if (checkForWin("O")) {
                    display("board");
                    System.out.println("The computer has won.");
                    gameOver = true;
                }
                else {
                    playerTurn = true;
                    display("board");
                }
            }      
        }            
    }
    
    /**
     * display method for displaying various messages or instructions.
     * @param selection 
     */
    private static void display(String selection) {
        
        if (selection.equals("board")) {
            System.out.println("Game:");

            System.out.println("   |   |   ");

            System.out.println(" " + squares.get(1).getContents() + " | " + 
                    squares.get(2).getContents() + " | " + 
                    squares.get(3).getContents() + " ");

            System.out.println("---+---+---");

            System.out.println(" " + squares.get(4).getContents() + " | " + 
                    squares.get(5).getContents() + " | " + 
                    squares.get(6).getContents() + " ");

            System.out.println("---+---+---");

            System.out.println(" " + squares.get(7).getContents() + " | " + 
                    squares.get(8).getContents() + " | " + 
                    squares.get(9).getContents() + " ");

            System.out.println("   |   |   ");    
        }
        
        if (selection.equals("welcome")) {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Please type the number of the square you"); 
            System.out.println("would like to select and hit <Enter>");   
            System.out.println("when prompted as your turn.");
            System.out.println("You are X's and 3 in a row wins!");
        }
        
        if (selection.equals("player")) {
            System.out.println("Players Turn:");
            System.out.println("Please type a square number " + 
                        "and hit <enter>");
        }   
    }
    
    /**
     * emptySquares method checks the array for unassigned squares.
     * @return false if grid is full, true if any squares are available.
     */
    private static boolean emptySquares() {
      
        for (int i = 1; i < 10; i++) {
            if (squares.get(i).squareAvailable())
                return true;
        }
        return false;
        
    }
    
    /**
     * getPlayerInput prompts player to enter an integer and validates the
     * input.
     * @param x is the number of attempts a player gets to pick a valid input.
     * @return the input square integer or -1 if failed to enter correctly.
     */
    private static int getPlayerInput(int x) {
        keyboard = new Scanner(System.in);
                
        // Ask x times for a valid input and then game is over.
        while (x > 0) {
        
            display("player");
        
            int input = keyboard.nextInt();

            if (input > 0 && input < 10 && squares.get(input).squareAvailable())
                return input;

            else {
                System.out.println("Please try again.");
                x = x - 1;
            }
            
        }
        return -1;  // to kill game
    }
    
    /**
     * getComputerInput will generate the computer input.
     * The computer will first look for a winning selection.
     * The computer will next look for a blocking selection.
     * At this point the computer will then select a random square
     *  while I think about how to look for or block possible splits.
     * @return integer corresponding to the the selected square.
     */
    private static int getComputerInput() {
        boolean found = false;
        int selection = 0;
        int i = 1;
        
        // Check to see if there is a square that will win for O and 
        // select it for the win.
        while (!found && i < 10) {
                // If there is an available square that will result ina win,
                // return that index and set found flag to true.
                if (squares.get(i).squareAvailable()) {
                    squares.get(i).setContents("O");
                    if (checkForWin("O")) {
                        selection = i;
                        squares.get(i).setContents(Integer.toString(i));
                        found = true;
                    }
                    else {
                        squares.get(i).setContents(Integer.toString(i));   
                    }
                } 
            i++;
        }
        
        // Check to see if there is any square that will win for X and
        // select it for O to block the X win.
        i = 1; // Reset the loop counter.
        while (!found && i < 10) {
            if (squares.get(i).squareAvailable()) {
                squares.get(i).setContents("X");
                if (checkForWin("X")) {
                    selection = i;
                    squares.get(i).setContents(Integer.toString(i));
                    found = true;
                }
                else
                    squares.get(i).setContents(Integer.toString(i));
            }
            i++;
        }
        
        // If neither a win or block move was found, pick a random space for
        // now until further strategy is added.
        while (!found) {
            int x = random.nextInt(9) + 1;
            if (squares.get(x).squareAvailable()) {
                selection = x;
                found = true;
            }
        }
        
        return selection;    
    }
   
    /**
     * checkForWin will check all 8 possible winning combinations to determine
     * whether there are three in a row. 
     * I would like to find a smarter way to do this is the future.
     * @param input X or O
     * @return true if three in a row, false otherwise.
     */
    private static boolean checkForWin(String input) {
        if ((squares.get(1).getContents().equals(input) &&
                squares.get(2).getContents().equals(input) &&
                    squares.get(3).getContents().equals(input)) ||
            (squares.get(4).getContents().equals(input) &&
                squares.get(5).getContents().equals(input) &&
                    squares.get(6).getContents().equals(input)) ||  
            (squares.get(7).getContents().equals(input) &&
                squares.get(8).getContents().equals(input) &&
                    squares.get(9).getContents().equals(input)) ||    
            (squares.get(1).getContents().equals(input) &&
                squares.get(4).getContents().equals(input) &&
                    squares.get(7).getContents().equals(input)) ||    
            (squares.get(2).getContents().equals(input) &&
                squares.get(5).getContents().equals(input) &&
                    squares.get(8).getContents().equals(input)) ||
            (squares.get(3).getContents().equals(input) &&
                squares.get(6).getContents().equals(input) &&
                    squares.get(9).getContents().equals(input)) ||
            (squares.get(1).getContents().equals(input) &&
                squares.get(5).getContents().equals(input) &&
                    squares.get(9).getContents().equals(input)) ||
            (squares.get(7).getContents().equals(input) &&
                squares.get(5).getContents().equals(input) &&
                    squares.get(3).getContents().equals(input)))
            return true;
        else
            return false;
    } 
}
