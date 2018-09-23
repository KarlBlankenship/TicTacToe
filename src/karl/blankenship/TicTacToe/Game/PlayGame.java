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
    private boolean emptySquares; // May turn this into a method.
    private static Scanner keyboard; // Will hold player keyboard input.
    
    /**
     * Constructor.
     */
    public PlayGame() {  // NEED TO FINISH CONSTRUCTOR
        
        // Generate a list of square instances and set initial value.
        squares = new ArrayList();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square(Integer.toString(i)));   
        }
        
        // Set gameOver flag to false to start game.
        gameOver = false;
        
        //Select whether player or computer goes first randomly by boolean
        // flag such as true for player and false for computer.
        random = new Random();
        playerTurn = random.nextBoolean();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Psuedo Code of how I think the game should flow.
                    
        // Create a new instance of PlayGame class to begin the game.
        PlayGame game = new PlayGame();
       
        display("board");
        display("welcome");
        
        
        // Set an empty squares flag (or could use a counter since 9 turns is
        // the most.
        //boolean emptySquares = true;
        
        // While game is not over AND there are empty Squares.
        while (!gameOver && emptySquares()) {
            // If it is player turn
            if (playerTurn) {
                // Prompt player to type in a square by 
                display("board");
                int sq = getPlayerInput(3);
                // Apply response to the board.
                if (sq == -1) {
                    gameOver = true;
                    System.out.println("Sorry, You Lost.");
                }
                else
                    squares.get(sq).setContents("X");
                // Check to see if player won.
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
            else {
                display("Board");
                System.out.println("Computer is thinking...");
                Thread.sleep(2000);
                int csq = getComputerInput();
                squares.get(csq).setContents("O");
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
    
    private static boolean emptySquares() {
      
        for (int i = 1; i < 10; i++) {
            if (squares.get(i).squareAvailable())
                return true;
        }
        return false;
        
    }
    
    private static int getPlayerInput(int x) {
        keyboard = new Scanner(System.in);
                
        // Ask three times for a valid input and then game is over.
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
    
    private static int getComputerInput() {
        boolean found = false;
        int selection = 0;
        while (!found) {
            selection = random.nextInt(9) + 1;
            if (squares.get(selection).squareAvailable())
                found = true;   
        }
        return selection; 
    }
    
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
