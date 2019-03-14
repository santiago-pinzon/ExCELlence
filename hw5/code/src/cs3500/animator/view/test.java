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
    Rectangle test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R");
    Ellipse hello = new Ellipse(new Position(300, 300), 50, 50,
        new Color(0, 0, 255), "E");

    Motion motion = new Motion(0, 100, new Position(600, 600));
    ColorChange color = new ColorChange(0, 100, new Color(0, 255, 0));
    Size size = new Size(100, 150, 300, 400);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);
    imp.addShape(hello);

    imp.addAnimation("R", motion);
    imp.addAnimation("E", color);
    imp.addAnimation("R", size);
    imp.addAnimation("E", size);

    AnimationView animate = new AnimationView(imp, 500, 500,100);
    animate.Animate();
  }


}
