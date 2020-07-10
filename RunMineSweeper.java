/*
 * Project: MineSweeper300
 * Files: RunMineSweeper.java, GameBoard.java, BoardCell.java
 * 
 * Description: A text based minesweeper game displayed and played from the
 * console. Input is received via Scanner and output is created from print
 * statements.
 * 
 * Author: Alec Osmak
 * Email: osmak@wisc.edu
 * 
 * Date Started: July 7, 2020
 */

//import java.util.ArrayList;
import java.util.Scanner;

/**
 * Runs the minesweeper game. Creates the board and prompts the user for inputs.
 * 
 * @author Alec Osmak
 */
public class RunMineSweeper {

   private static final int[][] DIFFICULTY = {{9, 7}, {7, 10}, {6, 14}, {5,16}};
   private static final Scanner SCAN = new Scanner(System.in);
   private static GameBoard board;


   /**
    * Creates a game board to play on.
    * 
    * @throws IllegalArgumentException If an incorrect command is input.
    */
   private static void createBoard() throws IllegalArgumentException {
      System.out.print("Please enter difficulty.\n>> ");

      String difficulty = SCAN.nextLine().trim().toLowerCase();

      int difficultyNum;

      switch (difficulty) { // handles initial commands
         case "quit":
            SCAN.close();
            return;

         case "easy":
            difficultyNum = 0;
            break;

         case "medium":
            difficultyNum = 1;
            break;

         case "hard":
            difficultyNum = 2;
            break;

         case "ultra nightmare":
            difficultyNum = 3;
            break;
            
         default:
            throw new IllegalArgumentException("Incorrect input.");
      }

      board = new GameBoard(DIFFICULTY[difficultyNum][0],
            DIFFICULTY[difficultyNum][1]);
   }


   /**
    * Begins the program and prints welcome and farewell messages.
    * 
    * @param args The default input arguments.
    */
   public static void main(String[] args) {
      System.out.println("Welcome to MineSweeper300!\n");

      try {
         createBoard();
      } catch (IllegalArgumentException e) {
         System.out.println("Error: " + e.getMessage());
      }

      System.out.println(board);



      System.out.println("Goodbye");
   }


}
