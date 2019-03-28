
import org.junit.Test;


import cs3500.animator.view.SVGView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Motion;
import cs3500.model.Size;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Ellipse;
import cs3500.model.Shapes;


import static org.junit.Assert.assertEquals;

/**
 * tests for the SVG view.
 */
public class SVGViewTest {

  @Test(expected = IllegalArgumentException.class)
  public void testSVGViewNullArrayListOfShapes() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();
    assertEquals("Cannot be null", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGViewNullAppendable() {
    StringBuffer out = null;
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();
    assertEquals("Cannot be null", out.toString());
  }


  @Test
  public void testSVGViewCreateShape() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShapesToArray(test);

    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" version=\"1.1\" " +
        "xmlns=\"http://www.w3.org/2000/svg\">\n" +
        "\n" +
        "<rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n" +
        "\n" +
        "\n" +
        "</rect>\n" +
        "\n" +
        "</svg>", out.toString());
  }


  @Test
  public void testSVGViewMoveEllipse() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    a.addShape(test);
    a.addShapesToArray(test);

    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("E", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cx\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cy\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</ellipse>\n\n" + "</svg>", out.toString());


  }


  @Test
  public void testSVGViewMoveRect() {

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
        "attributeName=\"x\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</rect>\n\n" + "</svg>", out.toString());

  }

  @Test
  public void testResizeRect() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShapesToArray(test);

    Size size = new Size(0, 100, 200, 200);
    a.addAnimation("R", size);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"width\" from=\"100\" to=\"200\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"height\" from=\"100\" to=\"200\" fill=\"freeze\" />\n\n" +
        "</rect>\n\n" + "</svg>", out.toString());

  }

  @Test
  public void testRecolorEllipse() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    a.addShape(test);
    a.addShapesToArray(test);

    ColorChange change = new ColorChange(0, 100, new Color(0, 0, 255));
    a.addAnimation("E", change);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeName = \"fill\" attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n\n" +
        "</ellipse>\n\n" + "</svg>", out.toString());


  }

  @Test
  public void testMoreThanOneAnimation() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    a.addShape(test);
    a.addShapesToArray(test);

    ColorChange change = new ColorChange(0, 100, new Color(0, 0, 255));
    a.addAnimation("E", change);
    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("E", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeName = \"fill\" attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cx\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cy\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</ellipse>\n\n" + "</svg>", out.toString());
  }

  @Test
  public void testMoreThanOneAnimationAndMoreThanOneShape() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    Shapes hello = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShape(hello);
    a.addShapesToArray(test);
    a.addShapesToArray(hello);

    ColorChange change = new ColorChange(0, 100, new Color(0, 0, 255));
    a.addAnimation("E", change);
    Motion motion = new Motion(0, 100, new Position(300, 300));

    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeName = \"fill\" attributeType=\"xml\" begin=\"0ms\" " +
        "dur=\"100ms\" " +
        "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n\n" +
        "</ellipse><rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"x\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"y\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</rect>\n\n" + "</svg>", out.toString());
  }


}


import org.junit.Test;


import cs3500.animator.view.SVGView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Motion;
import cs3500.model.Size;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Ellipse;
import cs3500.model.Shapes;


import static org.junit.Assert.assertEquals;

/**
 * tests for the SVG view.
 */
public class SVGViewTest {

  @Test(expected = IllegalArgumentException.class)
  public void testSVGViewNullArrayListOfShapes() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();
    assertEquals("Cannot be null", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGViewNullAppendable() {
    StringBuffer out = null;
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();
    assertEquals("Cannot be null", out.toString());
  }


  @Test
  public void testSVGViewCreateShape() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShapesToArray(test);

    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" version=\"1.1\" " +
        "xmlns=\"http://www.w3.org/2000/svg\">\n" +
        "\n" +
        "<rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n" +
        "\n" +
        "\n" +
        "</rect>\n" +
        "\n" +
        "</svg>", out.toString());
  }


  @Test
  public void testSVGViewMoveEllipse() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    a.addShape(test);
    a.addShapesToArray(test);

    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("E", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cx\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cy\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</ellipse>\n\n" + "</svg>", out.toString());


  }


  @Test
  public void testSVGViewMoveRect() {

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
        "attributeName=\"x\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</rect>\n\n" + "</svg>", out.toString());

  }

  @Test
  public void testResizeRect() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShapesToArray(test);

    Size size = new Size(0, 100, 200, 200);
    a.addAnimation("R", size);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"width\" from=\"100\" to=\"200\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"height\" from=\"100\" to=\"200\" fill=\"freeze\" />\n\n" +
        "</rect>\n\n" + "</svg>", out.toString());

  }

  @Test
  public void testRecolorEllipse() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    a.addShape(test);
    a.addShapesToArray(test);

    ColorChange change = new ColorChange(0, 100, new Color(0, 0, 255));
    a.addAnimation("E", change);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeName = \"fill\" attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n\n" +
        "</ellipse>\n\n" + "</svg>", out.toString());


  }

  @Test
  public void testMoreThanOneAnimation() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    a.addShape(test);
    a.addShapesToArray(test);

    ColorChange change = new ColorChange(0, 100, new Color(0, 0, 255));
    a.addAnimation("E", change);
    Motion motion = new Motion(0, 100, new Position(300, 300));
    a.addAnimation("E", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeName = \"fill\" attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cx\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"cy\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</ellipse>\n\n" + "</svg>", out.toString());
  }

  @Test
  public void testMoreThanOneAnimationAndMoreThanOneShape() {
    StringBuffer out = new StringBuffer();
    AnimationModelImpl a = new AnimationModelImpl();
    Shapes test = new Ellipse(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "E", true);
    Shapes hello = new Rectangle(new Position(0, 0), 100, 100,
        new Color(255, 0, 0), "R", true);
    a.addShape(test);
    a.addShape(hello);
    a.addShapesToArray(test);
    a.addShapesToArray(hello);

    ColorChange change = new ColorChange(0, 100, new Color(0, 0, 255));
    a.addAnimation("E", change);
    Motion motion = new Motion(0, 100, new Position(300, 300));

    a.addAnimation("R", motion);
    SVGView svgView = new SVGView(1, a.getShapes(), out, 500, 700, a);
    svgView.output();

    assertEquals("<svg width=\"500\" height=\"700\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n" +
        "<ellipse id=\"E\" cx=\"0\" cy=\"0\" rx=\"100\" ry=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeName = \"fill\" attributeType=\"xml\" begin=\"0ms\" " +
        "dur=\"100ms\" " +
        "from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" fill=\"freeze\" />\n\n" +
        "</ellipse><rect id=\"R\" x=\"0\" y=\"0\" width=\"100\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\">\n\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"x\" from=\"0\" to=\"300\" fill=\"freeze\" />\n" +
        "\t<animate attributeType=\"xml\" begin=\"0ms\" dur=\"100ms\" " +
        "attributeName=\"y\" from=\"0\" to=\"300\" fill=\"freeze\" />\n\n" +
        "</rect>\n\n" + "</svg>", out.toString());
  }


}
