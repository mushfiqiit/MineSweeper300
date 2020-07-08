import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MineSweeperTest {

   @Test
   public void firstTest() {
      BoardCell cell = new BoardCell(2);
      assert(cell.getValue()==1);
   }
   
}
