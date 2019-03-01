import org.junit.Test;

import cs3500.model.*;


import static org.junit.Assert.assertEquals;

public class AnimationModelImplTest {

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeWithSameName(){
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "R");
    Rectangle test1 = new Rectangle(new Position(0,0), 10, 10,new Color(0,255,0), "R");
    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);
    imp.addShape(test1);
    assertEquals("There already exists a shape with this name", imp.getAnimation());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testShapeNotInListOfShapes(){
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "M");

    Motion motion = new Motion(0, 10, new Position(5,0));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("R", motion);

    assertEquals("This shape does not exist", imp.getAnimation());
  }

  @Test
  public void testGetAnimationForJustRectangle(){
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "R");

    Size size = new Size(10, 15, 20,21);
    Motion motion = new Motion(0, 10, new Position(5,0));

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);

    imp.addAnimation("R", motion);
    imp.addAnimation("R", size);

    assertEquals("shape R Rectangle\n\n" +
            "motion\tR\t0     0     0     10    10    255   0     0"+
            "    \t\t10    5     0     10    10    255   0     0    \n" +
            "motion\tR\t10    5     0     10    10    255   0     0"+
            "    \t\t15    5     0     20    21    255   0     0    \n\n", imp.getAnimation());

  }

  @Test
  public void testGetAnimationForJustEllipse(){
    Ellipse hello = new Ellipse(new Position(5,5), 20,10,new Color(0,0,255), "E");

    ColorChange color = new ColorChange(0,10, new Color(0,255,0));
    Size size = new Size(10, 15, 20,21);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(hello);

    imp.addAnimation("E", color);
    imp.addAnimation("E", size);

   assertEquals("shape E Ellipse\n\n" +
            "motion\tE\t0     5     5     20    10    0     0     255"+
            "  \t\t10    5     5     20    10    0     255   0    \n" +
            "motion\tE\t10    5     5     20    10    0     255   0"+
            "    \t\t15    5     5     20    21    0     255   0    \n\n", imp.getAnimation());
  }


  @Test
  public void testGetAnimationsForRectangleAndEllipse(){
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "R");
    Ellipse hello = new Ellipse(new Position(5,5), 20,10,new Color(0,0,255), "E");

    Motion motion = new Motion(0, 10, new Position(5,0));
    ColorChange color = new ColorChange(0,10, new Color(0,255,0));
    Size size = new Size(10, 15, 20,21);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);
    imp.addShape(hello);

    imp.addAnimation("R", motion);
    imp.addAnimation("E", color);
    imp.addAnimation("R", size);
    imp.addAnimation("E", size);

    assertEquals("shape R Rectangle\n\n" +
            "motion\tR\t0     0     0     10    10    255   0     0"+
            "    \t\t10    5     0     10    10    255   0     0    \n" +
            "motion\tR\t10    5     0     10    10    255   0     0"+
            "    \t\t15    5     0     20    21    255   0     0    \n\n" +
            "shape E Ellipse\n\n" +
            "motion\tE\t0     5     5     20    10    0     0     255"+
            "  \t\t10    5     5     20    10    0     255   0    \n" +
            "motion\tE\t10    5     5     20    10    0     255   0"+
            "    \t\t15    5     5     20    21    0     255   0    \n\n", imp.getAnimation());
  }


  @Test
  public void testNoAnimation(){
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "R");
    Ellipse hello = new Ellipse(new Position(5,5), 20,10,new Color(0,0,255), "E");

    Motion motion = new Motion(0, 10, new Position(5,0));
    ColorChange color = new ColorChange(0,10, new Color(0,255,0));
    Size size = new Size(10, 15, 20,21);

    AnimationModelImpl imp = new AnimationModelImpl();
    imp.addShape(test);
    imp.addShape(hello);

    assertEquals("shape R Rectangle\n\n\n" +
            "shape E Ellipse\n\n\n", imp.getAnimation());
  }

  @Test
  public void testNothingAdded(){
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "R");
    Ellipse hello = new Ellipse(new Position(5,5), 20,10,new Color(0,0,255), "E");

    Motion motion = new Motion(0, 10, new Position(5,0));
    ColorChange color = new ColorChange(0,10, new Color(0,255,0));
    Size size = new Size(10, 15, 20,21);

    AnimationModelImpl imp = new AnimationModelImpl();

    assertEquals("", imp.getAnimation());
  }

}
