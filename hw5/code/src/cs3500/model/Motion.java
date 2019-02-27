package cs3500.model;

public class Motion extends AbstractAnimation{
  Position to;


  public Motion(int startTime, int endTime, Position to) {
    super(startTime, endTime);

    this.to = to;
  }

  @Override
  public void apply(Shapes shape) {
    shape.changePosition(this.to);
  }


}
