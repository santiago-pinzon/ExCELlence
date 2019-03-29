import static org.junit.Assert.assertEquals;

import cs3500.animator.view.TextView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Ellipse;
import cs3500.model.Motion;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Size;
import org.junit.Test;

//FIXME need to fix these tests..

/**
 * Tests for the text-based view.
 */
public class TestTextView {

  @Test (expected  = java.lang.IllegalArgumentException.class)
  public void testNullAppendable() {
    TextView text = new TextView(new AnimationModelImpl(), 2,2,10, 10,null);
  }

  @Test
  public void testOneAnimation() {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R", true);

    Size size = new Size(10, 15, 20, 21);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("R", size);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    String description = "canvas 0   0   100 100\n"
        + "shape R Rectangle\n"
        + "motion\tR\t10    0     0     10    10    255   0     0    "
        + "\t\t15    0     0     20    21    255   0     0    \n";

    textView.render();

    assertEquals(description, out.toString());
  }

  @Test
  public void testMovementAnimation() {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R", true);

    Motion motion = new Motion(10, 15, new Position(10,10));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("R", motion);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    String description = "canvas 0   0   100 100\n"
        + "shape R Rectangle\n"
        + "motion\tR\t10    0     0     10    10    255   0     0    \t"
        + "\t15    10    10    10    10    255   0     0    \n";

    textView.render();

    assertEquals(description, out.toString());
  }

  @Test
  public void testColorAnimation() {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R", true);

    ColorChange motion = new ColorChange(10, 15, new Color(100,100,100));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("R", motion);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    String description = "canvas 0   0   100 100\n"
        + "shape R Rectangle\n"
        + "motion\tR\t10    0     0     10    10    255   0     0    \t"
        + "\t15    0     0     10    10    100   100   100  \n";

    textView.render();

    assertEquals(description, out.toString());
  }

  @Test
  public void testOneAnimationEllipse() {
    Ellipse test = new Ellipse(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "E", true);

    Size size = new Size(10, 15, 20, 21);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("E", size);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    String description = "canvas 0   0   100 100\n"
        + "shape E Ellipse\n"
        + "motion\tE\t10    0     0     10    10    255   0     0    "
        + "\t\t15    0     0     20    21    255   0     0    \n";

    textView.render();

    assertEquals(description, out.toString());
  }

  @Test
  public void testMovementAnimationEllipse() {
    Ellipse test = new Ellipse(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "E", true);

    Motion motion = new Motion(10, 15, new Position(10,10));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("E", motion);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    String description = "canvas 0   0   100 100\n"
        + "shape E Ellipse\n"
        + "motion\tE\t10    0     0     10    10    255   0     0    \t"
        + "\t15    10    10    10    10    255   0     0    \n";

    textView.render();

    assertEquals(description, out.toString());
  }

  @Test
  public void testColorAnimationEllipse() {
    Ellipse test = new Ellipse(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "E", true);

    ColorChange motion = new ColorChange(10, 15, new Color(100,100,100));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("E", motion);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    String description = "canvas 0   0   100 100\n"
        + "shape E Ellipse\n"
        + "motion\tE\t10    0     0     10    10    255   0     0    \t"
        + "\t15    0     0     10    10    100   100   100  \n";

    textView.render();

    assertEquals(description, out.toString());
  }

  @Test
  public void testMoreThanOneAnimation() {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R", true);

    Size size = new Size(10, 15, 20, 21);
    Motion motion = new Motion(0, 10, new Position(5, 0));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("R", motion);
    imp.addAnimation("R", size);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    textView.render();

    String description = "canvas 0   0   100 100\n"
        + "shape R Rectangle\n"
        + "motion\tR\t0     0     0     10    10    255   0     0    \t\t"
        + "10    5     0     10    10    255   0     0    \n"
        + "motion\tR\t10    5     0     10    10    255   0     0    \t\t"
        + "15    5     0     20    21    255   0     0    \n";

    assertEquals(description, out.toString());
  }

  @Test
  public void testMoreThanOneAnimationEllipse() {
    Ellipse test = new Ellipse(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "E", true);

    Size size = new Size(10, 15, 20, 21);
    Motion motion = new Motion(0, 10, new Position(5, 0));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("E", motion);
    imp.addAnimation("E", size);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    textView.render();

    String description = "canvas 0   0   100 100\n"
        + "shape E Ellipse\n"
        + "motion\tE\t0     0     0     10    10    255   0     0    \t\t"
        + "10    5     0     10    10    255   0     0    \n"
        + "motion\tE\t10    5     0     10    10    255   0     0    \t\t"
        + "15    5     0     20    21    255   0     0    \n";

    assertEquals(description, out.toString());
  }

  @Test
  public void testMoreThanOneShapeAndAnimation() {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R", true);
    Ellipse hello = new Ellipse(new Position(5, 5), 20, 10,
        new Color(0, 0, 255), "E", true);

    Motion motion = new Motion(0, 10, new Position(5, 0));
    ColorChange color = new ColorChange(0, 10, new Color(0, 255, 0));
    Size size = new Size(10, 15, 20, 21);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);
    imp.addShape(hello);

    imp.addAnimation("R", motion);
    imp.addAnimation("E", color);
    imp.addAnimation("R", size);
    imp.addAnimation("E", size);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0,0, 100, 100, out);

    textView.render();

    String description = "canvas 0   0   100 100\n"
        + "shape R Rectangle\n"
        + "motion\tR\t0     0     0     10    10    255   0     0    \t\t"
        + "10    5     0     10    10    255   0     0    \n"
        + "motion\tR\t10    5     0     10    10    255   0     0    \t\t"
        + "15    5     0     20    21    255   0     0    \n"
        + "shape E Ellipse\n"
        + "motion\tE\t0     5     5     20    10    0     0     255  \t\t"
        + "10    5     5     20    10    0     255   0    \n"
        + "motion\tE\t10    5     5     20    10    0     255   0    \t\t"
        + "15    5     5     20    21    0     255   0    \n";

    assertEquals(description, out.toString());
  }
}
