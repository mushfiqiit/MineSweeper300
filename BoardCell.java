import java.util.Random;

public class BoardCell {

   private final String COVER = "O";
   private char value;
   private boolean isShown;


   BoardCell(int mineOdds) {
      if (new Random().nextInt(mineOdds) == 0)
         value = 'X';
      else
         value = '0';

      isShown = false;
   }


   public char getValue() {
      return value;
   }

   
   /**
    * Returns the boolean of the field isShown.
    * 
    * @return True if the tiles value is revealed, false otherwise.
    */
   public boolean isShown() {
      return isShown;
   }


   /**
    * Determines what character should be printed based on if the value is shown
    * or not.
    * 
    * @return A String of what should be printed when this cell is called to be
    *         printed.
    */
   public String toString() {
      if (isShown)
         return Character.toString(value);
      else
         return COVER;
   }


}
