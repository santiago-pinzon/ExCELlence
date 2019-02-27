package cs3500.model;

public class ColorChange extends AbstractAnimation {
  Color color;

  public ColorChange(int startTime, int endTime, Color color) {
    super(startTime, endTime);
    this.color = color;
  }


  @Override
  public void apply(Shapes shape) {
    shape.changeColor(this.color);
  }
}
