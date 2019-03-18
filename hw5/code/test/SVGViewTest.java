import org.junit.Test;

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

          new Color(255, 0, 0), "R");
    a.addShape(test);

  Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
  SVGView svgView = new SVGView(1, test, out, 500, 700, a);
    svgView.output();

   assertEquals("<svg width=\"500\" height=\"700\" " +
           "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
           "<rect id=\"sqr\" x=\"10\" y=\"10\" width=\"10\" height=\"10\" " +
           "fill=\"rgb(5,5,5)\" visibility=\"visible\">\n\n" +
           "\t<animate attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" " +
           "attributeName=\"x\" from=\"10\" to=\"15\" fill=\"freeze\" />\n" +
           "\t<animate attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" " +
           "attributeName=\"y\" from=\"10\" to=\"10\" fill=\"freeze\" />\n\n" +
           "</rect>\n\n" + "</svg>", out.toString());
}
}
