import org.junit.Test;

import java.util.ArrayList;

import cs3500.animator.view.SVGView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.Motion;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Shapes;


import static org.junit.Assert.assertEquals;

public class SVGViewTest {


  @Test
  public void test1() {

  StringBuffer out = new StringBuffer();
  AnimationModelImpl a = new AnimationModelImpl();
  Shapes test = new Rectangle(new Position(0, 0), 100, 100,

          new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShapesToArray(test);



  Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
  SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

   assertEquals("<svg width=\"500\" height=\"700\" " +
           "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
           "<rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
           "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
           "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
           "attributeName=\"x\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
           "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
           "attributeName=\"y\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
           "</rect>\n\n" + "</svg>", out.toString());

}
}
