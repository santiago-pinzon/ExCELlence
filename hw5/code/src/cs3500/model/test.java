package cs3500.model;

public class test {
  public static void main(String[] args) {
    Rectangle test = new Rectangle(new Position(0,0), 10, 10,new Color(255,0,0), "R");

    Motion motion = new Motion(0, 10, new Position(5,0));
    ColorChange color = new ColorChange(0,10, new Color(0,255,0));

    Size size = new Size(10, 15, 20,21);

    test.addAction(motion);
    test.addAction(color);
    test.addAction(size);

    System.out.println(test.getFullDescription());
  }

}
