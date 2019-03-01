package cs3500.model;

public class test {
  public static void main(String[] args) {
    Rectangle test = new Rectangle(new Position(0, 0), 10, 10, new Color(255, 0, 0), "R");
    Ellipse hello = new Ellipse(new Position(5, 5), 20, 10, new Color(0, 0, 255), "E");

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

    System.out.println(imp.getAnimation());
  }

}
