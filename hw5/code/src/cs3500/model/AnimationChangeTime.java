package cs3500.model;

public class AnimationChangeTime extends AbstractAnimation {

  public AnimationChangeTime(int startTime, int endTime) {
    super(startTime, endTime);
  }


  @Override
  public void apply(Shapes shape) {

  }

  @Override
  public void applyTweener(int frame, Shapes s) {

  }

  @Override
  public Animation changeStartTime(int i) {
    return new AnimationChangeTime(i, endTime);
  }
}
