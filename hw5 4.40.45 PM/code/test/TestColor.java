import org.junit.Test;

import cs3500.model.Color;

import static org.junit.Assert.assertEquals;

/**
 * Testing color.
 */

public class TestColor {

  @Test(expected = IllegalArgumentException.class)
  public void testRLessThan0() {
    Color fake = new Color(-20, 5, 3);
    assertEquals("Invalid color", fake.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRLessGreaterThan255() {
    Color fake = new Color(2000, 5, 3);
    assertEquals("Invalid color", fake.toString());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testGLessThan0() {
    Color fake = new Color(20, -5, 3);
    assertEquals("Invalid color", fake.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGLessGreaterThan255() {
    Color fake = new Color(20, 500, 3);
    assertEquals("Invalid color", fake.toString());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testBLessThan0() {
    Color fake = new Color(20, 5, -3);
    assertEquals("Invalid color", fake.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBLessGreaterThan255() {
    Color fake = new Color(20, 5, 300);
    assertEquals("Invalid color", fake.toString());
  }

  @Test
  public void testRedToString() {
    Color red = new Color(255, 0, 0);
    assertEquals("255   0     0    ", red.toString());
  }

  @Test
  public void testGreenToString() {
    Color red = new Color(0, 255, 0);
    assertEquals("0     255   0    ", red.toString());
  }

  @Test
  public void testBlueToString() {
    Color red = new Color(0, 0, 255);
    assertEquals("0     0     255  ", red.toString());
  }


}
