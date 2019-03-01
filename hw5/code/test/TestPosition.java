import org.junit.Test;

import cs3500.model.Position;

import static org.junit.Assert.assertEquals;

public class TestPosition {
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeXPosition() {
    Position p = new Position(-2, 3);
    assertEquals("X cannot be negative", p.getX());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeYPosition() {
    Position p = new Position(3, -2);
    assertEquals("Y cannot be negative", p.getY());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothValuesNegative() {
    Position p = new Position(-3, -3);
    assertEquals("X cannot be negative", p.getX());
  }

  @Test
  public void testGetX() {
    Position p = new Position(3, 2);
    assertEquals(3, p.getX());
  }

  @Test
  public void testGetY() {
    Position p = new Position(3, 2);
    assertEquals(2, p.getY());
  }

  @Test
  public void testGetToString() {
    Position p = new Position(3, 3);
    assertEquals("3     3    ", p.toString());
  }

}
