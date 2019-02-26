import org.junit.Test;

import cs3500.model.*;

import static org.junit.Assert.assertEquals;

public class TestShapes {

  @Test
  public void testChangeSizeMakeLarger(){
    Position p = new Position(10, 10);
    Color c = new Color(255, 0, 0);
    Shapes r = new Rectangle(p, 20, 25, c, "R");
    Shapes newr = new Rectangle(p, 30, 25, c, "R");
    r.changeSize(30, 25);

    assertEquals(newr.getDescription(), r.getDescription());
  }







}
