import org.junit.Test;

import cs3500.model.*;


import static org.junit.Assert.assertEquals;

public class TestColor {

  @Test
  public void testRedToString(){
    Color red = new Color(255, 0, 0);
    assertEquals("255   0     0    ", red.toString());
  }

  @Test
  public void testGreenToString(){
    Color red = new Color(0, 255, 0);
    assertEquals("0     255   0    ", red.toString());
  }

  @Test
  public void testBlueToString(){
    Color red = new Color(0, 0, 255);
    assertEquals("0     0     255  ", red.toString());
  }



}
