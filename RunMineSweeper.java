/*
 * Project: MineSweeper300
 * Files: RunMineSweeper.java, GameBoard.java, BoardCell.java
 * 
 * Author: Alec Osmak
 * Email: osmak@wisc.edu
 * 
 * Date Started: July 7, 2020
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Alec Osmak
 */
public class RunMineSweeper {

   private static final int[][] DIFFICULTY = {{10, 8}, {8, 12}, {6, 14}};
   private static final Scanner SCAN = new Scanner(System.in);
   private static GameBoard board;


   /**
    * 
    * @throws IllegalArgumentException
    */
   private static void createBoard() throws IllegalArgumentException {
      System.out.print("Please enter difficulty.\n>> ");

      String difficulty = SCAN.nextLine().trim().toLowerCase();

      int difficultyNum;

      switch (difficulty) {
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

         default:
            throw new IllegalArgumentException("Incorrect input.");
      }

      board = new GameBoard(DIFFICULTY[difficultyNum][0],
            DIFFICULTY[difficultyNum][1]);
   }


   /**
    * 
    * @param args
    */
   public static void main(String[] args) {
      System.out.println("Welcome to MineSweeper300!\n");

      try {
         createBoard();
      } catch (IllegalArgumentException e) {
         System.out.println("Error: " + e.getMessage());
      }



   }


}
