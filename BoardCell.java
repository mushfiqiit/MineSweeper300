import java.util.Random;

/**
 * This class represents a single cell on the minesweeper board. The cell holds
 * the value of being a mine or not and is also able to change if it is hidden
 * to the user or not.
 * 
 * @author Alec Osmak
 */
public class BoardCell {

   private final String COVER = "O";
   private char value;
   private boolean isShown;


   /**
    * Creates a new cell for the board.
    * 
    * @param mineOdds The odds of their being a mine on this cell. 1 in mineOdds
    *                 chance of being a mine.
    * @throws IllegalArgumentException If the odds for a mine are incorrect.
    */
   BoardCell(int mineOdds) throws IllegalArgumentException {
      if (mineOdds < 1)
         throw new IllegalArgumentException(
               "Odds must be greater than or equal to 1.");

      if (new Random().nextInt(mineOdds) == 0)
         value = 'X';
      else
         value = '0';

      isShown = false;
   }


   /**
    * Determines if the cell contains a mine or not.
    * 
    * @return True if the cell contains a mine, false otherwise.
    */
   public boolean isMine() {
      return value == 'X';
   }


   /**
    * Sets this cell's value.
    * 
    * @param value The new value to have.
    * @throws SecurityException        When the value of a mine is trying to be
    *                                  changed.
    * @throws IllegalArgumentException When the new value is out of bounds.
    */
   public void setValue(char value)
         throws SecurityException, IllegalArgumentException {

      if (this.value == 'X')
         throw new SecurityException("Cannot change a mine.");

      if (value < '0' || value > '8')
         throw new IllegalArgumentException("Value must be between 0 and 8.");

      this.value = value;
   }


   /**
    * Returns the boolean of the field isShown.
    * 
    * @return True if the s value is revealed, false otherwise.
    */
   public boolean isShown() {
      return isShown;
   }


   /**
    * Changes the cell to being shown to the user.
    */
   public void show() {
      isShown = true;
   }


   /**
    * Determines what character should be printed based on if the value is shown
    * or not.
    * 
    * @return A String of what should be printed when this cell is called to be
    *         printed. The cell's value if it is shown, COVER if not.
    */
   public String toString() {
      if (isShown) {
         if (value == '0')
            return " ";

         return Character.toString(value);

      } else
         return COVER;
   }


}
