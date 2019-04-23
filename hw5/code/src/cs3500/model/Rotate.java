package cs3500.model;

public class Rotate extends AbstractAnimation {

  private int angle;

  public Rotate(int startTime, int endTime, int angle) {
    super(startTime, endTime);
    this.angle = angle;
  }

  @Override
  public void apply(Shapes shape) {
    shape.rotateShape(angle);

  }

  @Override
  public void applyTweener(int frame, Shapes s) {
    int length = this.endTime - this.startTime;
    double ratio = (double) frame / length;

    int fromR = s.getRotation(); 

    int rDifference = angle - fromR;

    fromR += rDifference * ratio;

    s.rotateShape(fromR);
  }
}
