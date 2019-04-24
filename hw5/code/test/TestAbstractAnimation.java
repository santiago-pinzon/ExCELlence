import cs3500.model.Rectangle;
import org.junit.Test;

import cs3500.model.Animation;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Ellipse;
import cs3500.model.Motion;
import cs3500.model.Position;
import cs3500.model.Size;

import static org.junit.Assert.assertEquals;

/**
 * Testing abstract animation.
 */

public class TestAbstractAnimation {

  @Test(expected = IllegalArgumentException.class)
  public void testEndTimeLessThanStartTime() {
    Animation a = new Size(10, 3, 10, 10);
    assertEquals("end time cannot be less than or the same as the start time",
            a.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEndTimeEqualsStartTime() {
    Animation a = new Size(10, 10, 10, 10);
    assertEquals("end time cannot be less than or the same as the start time",
            a.toString());
  }

  @Test
  public void testGetStartTime() {
    Position p = new Position(3, 2);
    Animation a = new Motion(0, 5, p);
    assertEquals(0, a.getStartTime());
  }

  @Test
  public void testGetEndTime() {
    Color c = new Color(0, 0, 255);
    Animation a = new ColorChange(4, 10, c);
    assertEquals(10, a.getEndTime());
  }

  @Test
  public void testGetFullDescriptionOfRectangle() {
    Rectangle r = new Rectangle(new Position(0, 0), 10, 10,
            new Color(255, 0, 0), "R", true);
    Motion motion = new Motion(0, 10, new Position(5, 0));
    r.addAction(motion);
    assertEquals("shape R Rectangle\n\n" +
            "motion\tR\t0     0     0     10    10    255   0     0" +
            "    \t\t10    5     0     10    10    255   0     0    \n", r.getFullDescription());
  }

  @Test
  public void testGetDescriptionOfRectangle() {
    Rectangle r = new Rectangle(new Position(0, 0), 10, 10,
            new Color(255, 0, 0), "R", true);
    Motion motion = new Motion(0, 10, new Position(5, 0));
    r.addAction(motion);
    assertEquals("motion\tR\t0     0     0     10    10    255   0     0" +
            "    \t\t10    5     0     10    10    255   0     0    \n", r.getDescription(0));
  }

  @Test
  public void testGetFullDescriptionOfEllipse() {
    Ellipse r = new Ellipse(new Position(0, 0), 10, 10,
            new Color(255, 0, 0), "E", true);
    Motion motion = new Motion(0, 10, new Position(5, 0));
    ColorChange c = new ColorChange(0, 10, new Color(0, 255, 0));
    r.addAction(motion);
    r.addAction(c);
    assertEquals("shape E Ellipse\n\n" +
            "motion\tE\t0     0     0     10    10    255   0     0" +
            "    \t\t10    5     0     10    10    0     255   0    \n", r.getFullDescription());
  }

  @Test
  public void testGetDescriptionOfEllipse() {
    Ellipse r = new Ellipse(new Position(0, 0), 10, 10,
            new Color(255, 0, 0), "E", true);
    Motion motion = new Motion(0, 10, new Position(5, 0));
    r.addAction(motion);
    assertEquals("motion\tE\t0     0     0     10    10    255   0     0" +
            "    \t\t10    5     0     10    10    255   0     0    \n", r.getDescription(0));
  }

  @Test
  public void testGetFullDescriptionOfNewEllipse() {
    Ellipse r = new Ellipse(new Position(0, 0), 10, 10,
            new Color(255, 0, 0), "E", true);
    Motion motion = new Motion(0, 10, new Position(5, 0));
    ColorChange c = new ColorChange(0, 10, new Color(0, 255, 0));

    Size size = new Size(10, 15, 20, 21);
    r.addAction(motion);
    r.addAction(c);
    r.addAction(size);
    assertEquals("shape E Ellipse\n\n" +
                    "motion\tE\t0     0     0     10    10    255   0     0" +
                    "    \t\t10    5     0     10    10    0     255   0    \n" +
                    "motion\tE\t10    5     0     10    10    0     255   0" +
                    "    \t\t15    5     0     20    21    0     255   0    \n"
            , r.getFullDescription());
  }


}
