import cs3500.model.Rectangle;
import org.junit.Test;

import cs3500.model.Color;
import cs3500.model.Ellipse;
import cs3500.model.Position;
import cs3500.model.Shapes;

import static org.junit.Assert.assertEquals;

/**
 * Testing shapes.
 */

public class TestShapes {

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleWith0Height() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, 0, 3, c, "Rectangle", true);
    assertEquals("Height cannot be negative", s.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleWithNegativeHeight() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, -2, 3, c, "Rectangle", true);
    assertEquals("Height cannot be negative", s.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleWith0Width() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, 2, 0, c, "Rectangle", true);
    assertEquals("Width cannot be negative", s.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleWithNegativeWidth() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, 2, -3, c, "Rectangle", true);
    assertEquals("Width cannot be negative", s.getName());
  }

  @Test
  public void testGetNameForRectangle() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, 2, 3, c, "Rectangle", true);
    assertEquals("Rectangle", s.getName());
  }

  @Test
  public void testGetNameForEllipse() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, 2, 3, c, "Ellipse", true);
    assertEquals("Ellipse", s.getName());
  }

  @Test
  public void testGetDescriptionForRectangle() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Rectangle(p, 2, 3, c, "Rectangle", true);
    assertEquals("shape Rectangle Rectangle\n\n", s.getFullDescription());
  }

  @Test
  public void testGetDescriptionForEllipse() {
    Position p = new Position(3, 3);
    Color c = new Color(255, 0, 0);
    Shapes s = new Ellipse(p, 2, 3, c, "Ellipse", true);
    assertEquals("shape Ellipse Ellipse\n\n", s.getFullDescription());
  }


}









