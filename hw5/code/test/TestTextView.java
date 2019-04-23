import static org.junit.Assert.assertEquals;

import cs3500.animator.view.TextView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.Ellipse;
import cs3500.model.Position;
import cs3500.model.KeyFrame;
import cs3500.model.Rectangle;
import org.junit.Test;


/**
 * Tests for the text-based view.
 *//*
public class TestTextView {

  @Test(expected = java.lang.IllegalArgumentException.class)
  public void testNullAppendable() {
    TextView text = new TextView(new AnimationModelImpl(), 2, 2, 10, 10, null);
  }

  @Test
  public void testOneAnimation() {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R", true);

    KeyFrame one = new KeyFrame(10, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(15, 0, 0, 20, 21, 255, 0, 0);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addKeyFrame("R", 10, one);
    imp.addKeyFrame("R", 15, two);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    KeyFrame one = new KeyFrame(10, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(15, 10, 10, 10, 10, 255, 0, 0);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addKeyFrame("R", 10, one);
    imp.addKeyFrame("R", 15, two);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    KeyFrame one = new KeyFrame(10, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(15, 0, 0, 10, 10, 100, 100, 100);

    imp.addKeyFrame("R", 10, one);
    imp.addKeyFrame("R", 15, two);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    KeyFrame one = new KeyFrame(10, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(15, 0, 0, 20, 21, 255, 0, 0);

    imp.addKeyFrame("E", 10, one);
    imp.addKeyFrame("E", 15, two);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    KeyFrame one = new KeyFrame(10, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(15, 10, 10, 10, 10, 255, 0, 0);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addKeyFrame("E", 10, one);
    imp.addKeyFrame("E", 15, two);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    KeyFrame one = new KeyFrame(10, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(15, 0, 0, 10, 10, 100, 100, 100);

    imp.addKeyFrame("E", 10, one);
    imp.addKeyFrame("E", 15, two);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    KeyFrame one = new KeyFrame(0, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(10, 5, 0, 10, 10, 255, 0, 0);
    KeyFrame three = new KeyFrame(15, 5, 0, 20, 21, 255, 0, 0);

    imp.addKeyFrame("R", 0, one);
    imp.addKeyFrame("R", 10, two);
    imp.addKeyFrame("R", 15, three);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    KeyFrame one = new KeyFrame(0, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(10, 5, 0, 10, 10, 255, 0, 0);
    KeyFrame three = new KeyFrame(15, 5, 0, 20, 21, 255, 0, 0);

    imp.addKeyFrame("E", 0, one);
    imp.addKeyFrame("E", 10, two);
    imp.addKeyFrame("E", 15, three);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);
    imp.addShape(hello);

    KeyFrame one = new KeyFrame(0, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame two = new KeyFrame(10, 5, 0, 10, 10, 255, 0, 0);
    KeyFrame three = new KeyFrame(15, 5, 0, 20, 21, 255, 0, 0);

    KeyFrame four = new KeyFrame(0, 5, 5, 20, 10, 0, 0, 255);
    KeyFrame five = new KeyFrame(10, 5, 5, 20, 10, 0, 255, 0);
    KeyFrame six = new KeyFrame(15, 5, 5, 20, 21, 0, 255, 0);

    imp.addKeyFrame("R", 0, one);
    imp.addKeyFrame("R", 10, two);
    imp.addKeyFrame("R", 15, three);
    imp.addKeyFrame("E", 0, four);
    imp.addKeyFrame("E", 10, five);
    imp.addKeyFrame("E", 15, six);

    Appendable out = new StringBuilder();

    TextView textView = new TextView(imp, 0, 0, 100, 100, out);

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
*/