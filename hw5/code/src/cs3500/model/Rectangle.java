package cs3500.model;

public class Rectangle extends AShape {

  public Rectangle(Position center, int height, int width, Color color, String name) {
    super(center, height, width, color, name);
    this.desc = "Rectangle";
  }


  @Override
  public void getImage() {
    //this method is empty because we don't know how to render the images yet
  }

}
