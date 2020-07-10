import java.util.ArrayList;

/**
 * This class represents an entire game board to be played on. Each GameBoard is
 * composed of ArrayLists of BoardCells.
 * 
 * @author Alec Osmak
 */
public class GameBoard {

   private ArrayList<ArrayList<BoardCell>> cellList;
   private int totalMines;
   private int size;


   /**
    * Creates a new GameBoard by putting BoardCells into ArrayLists.
    * 
    * @param mineOdds The chances that any given tile has a mine in it
    * @param size     The length of each side of the game board.
    * @throws IllegalArgumentException If the size is incorrect or if creating a
    *                                  BoardCell throws one.
    */
   public GameBoard(int mineOdds, int size) throws IllegalArgumentException {
      if (size < 1)
         throw new IllegalArgumentException("Size must be greater than zero.");

      this.size = size;

      cellList = new ArrayList<ArrayList<BoardCell>>();

      // fills in the board with tiles
      for (int x = 0; x < size + 2; x++) {
         cellList.add(new ArrayList<BoardCell>());

         for (int y = 0; y < size + 2; y++) {
            if (x == 0 || x == size + 1 || y == 0 || y == size + 1) {
               cellList.get(x).add(null); // makes a null border around board

            } else {
               BoardCell cell = new BoardCell(mineOdds);
               cellList.get(x).add(cell);

               if (cell.isMine())
                  totalMines++;
            }
         }
      }
   }


   /**
    * Finds and returns a particular BoardCell from x-y coordinates.
    * 
    * @param x The x-coordinate of the cell chosen.
    * @param y The y-coordinate of the cell chosen.
    * @return The BoardCell that was selected with the coordinates.
    * @throws ArrayIndexOutOfBoundsException If the input coordinates are not on
    *                                        the board.
    */
   public BoardCell chooseCell(int x, int y)
         throws ArrayIndexOutOfBoundsException {
      if (x < 1 || x > size || y < 1 || y > size)
         throw new ArrayIndexOutOfBoundsException("Coordinates not on board.");

      return cellList.get(x).get(y);
   }


   /**
    * Gets how many mine cells are on the board.
    * 
    * @return The total number of mines on the board.
    */
   public int getNumMines() {
      return totalMines;
   }


   /**
    * Returns how long each side of the game board is.
    * 
    * @return The length of each side of the board.
    */
   public int getSize() {
      return size;
   }


   /**
    * Turns the data from the game board into a printable board the the user can
    * see and understand.
    * 
    * @return A string representation of this game board.
    */
   public String toString() {
      String board = "";

      for (int y = size; y > 0; y--) {
         for (int x = 1; x <= size; x++) {

            board = board.concat(cellList.get(x).get(y).toString());
         }

         board = board.concat("\n");
      }

      return board;
   }


}
