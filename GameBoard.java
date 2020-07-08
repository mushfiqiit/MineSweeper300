import java.util.ArrayList;

/**
 * 
 * 
 * @author Alec Osmak
 */
public class GameBoard {

   private ArrayList<ArrayList<BoardCell>> TILELIST;
   private int numMines;


   /**
    * 
    * 
    * @param odds
    * @param size
    */
   public GameBoard(int odds, int size) {
      TILELIST = new ArrayList<ArrayList<BoardCell>>();

      // fills in the board with tiles
      for (int x = 0; x < size + 2; x++) {
         TILELIST.add(new ArrayList<BoardCell>());

         for (int y = 0; y < size + 2; y++) {
            if (x == 0 || x == size + 1 || y == size + 1) // makes a null border
               TILELIST.get(x).add(null);
            else
               TILELIST.get(x).add(new BoardCell(odds));
         }
      }
   }


   public char choose(int x, int y) {
      return 0;

   }


   public int getNumMines() {
      return numMines;
   }


   public String toString() {

      return TILELIST.toString();

   }


}
