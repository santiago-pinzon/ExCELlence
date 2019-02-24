package cs3500.model;

public abstract class AShape implements Shapes{
  protected Position center;
  protected int height;
  protected int width;
  protected Color color;
  protected String name;

  public AShape(Position center, int height, int width, Color color, String name) {
    if (height <= 0) {
      throw new IllegalArgumentException("Height cannot be negative");
    }
    if (width <= 0) {
      throw new IllegalArgumentException("Width cannot be negative");
    }
    this.center = center;
    this.height = height;
    this.width = width;
    this.color = color;
    this.name = name;
  }


  @Override
  public void changeSize(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public void changePosition(Position p) {
    this.center = p;
  }

  @Override
  public void changeColor(Color c) {
    this.color = color;
  }

  @Override
  public String getDescription() {
    return  this.center.toString() + "\t" + this.height + "\t" + this.width + "\t" + this.color.toString();
  }

  public String getName(){
    return this.name;
  }

  @Override
  public void getImage(){
    //this method is empty because we don't know how to render the images yet
  }
}
