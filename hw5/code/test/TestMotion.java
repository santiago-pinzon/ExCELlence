import org.junit.Test;

import cs3500.model.*;


import static org.junit.Assert.assertEquals;

public class TestMotion {

  @Test
  public void testGetDescriptionChangeSize(){
    Position p = new Position(10, 10);
    Color c = new Color(255, 0, 0);
    Shapes r = new Rectangle(p, 20, 25, c, "R");


    Motion m = new Motion(r, 1, 10, p, 30, 25, c);

    String output = "motion\tR\t1\t10\t10\t20\t25\t255\t0\t0\t\t10\t10\t10\t30\t25\t255\t0\t0";

    assertEquals(output, m.getDescription());
  }
}
