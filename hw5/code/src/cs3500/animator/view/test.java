package cs3500.animator.view;

import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Ellipse;
import cs3500.model.Motion;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Size;

public class test {

  public static void main(String[] args) {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10,
        new Color(255, 0, 0), "R");
    Ellipse hello = new Ellipse(new Position(5, 5), 20, 10,
        new Color(0, 0, 255), "E");

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

    StringBuilder out = new StringBuilder();

    TextView text = new TextView(imp, 200, 70, 360, 360, out);

    text.render();

    System.out.println(out.toString());
  }


}
