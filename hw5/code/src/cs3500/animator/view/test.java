package cs3500.animator.view;

import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.animator.util.AnimationReader;
import cs3500.model.AnimationModel;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Ellipse;
import cs3500.model.Motion;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Size;
import java.io.FileNotFoundException;
import java.io.FileReader;
import cs3500.model.Shapes;

public class test {

  public static void main(String[] args) {

    /*
    Rectangle test = new Rectangle(new Position(0, 0), 100, 100,

            new Color(255, 0, 0), "R");
    Ellipse hello = new Ellipse(new Position(300, 300), 50, 50,
            new Color(0, 0, 255), "E");
    AnimationModelImpl imp = new AnimationModelImpl();

    imp.addShape(test);
    imp.addShape(hello);

    Motion motion = new Motion(0, 100, new Position(300, 300));
    ColorChange color = new ColorChange(0, 100, new Color(0, 255, 0));
    Size size = new Size(100, 200, 300, 400);


    imp.addAnimation("R", motion);
    imp.addAnimation("E", color);
    imp.addAnimation("R", size);
    imp.addAnimation("E", size);




    AnimationView animate = new AnimationView(imp, 1000, 1000,50);
    animate.Animate();

   // view.Animate();

   */


    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,

            new Color(255, 0, 0), "R");
    a.addShape(test);

    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, test, out, 700, 700, a);
    svgView.output();
    
  }

  }







