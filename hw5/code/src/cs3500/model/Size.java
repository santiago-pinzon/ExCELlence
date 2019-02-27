package cs3500.model;

public class Size extends AbstractAnimation {
  private int height;
  private int width;

  public Size(int startTime, int endTime, int height, int width) {
    super(startTime, endTime);
    this.height = height;
    this.width = width;
  }


  @Override
  public void apply(Shapes shape) {
    shape.changeSize(height, width);
  }
}
