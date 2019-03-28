package cs3500.model;

public class AnimationVisible implements Animation{
  private final int t;

  public AnimationVisible(int t){
    this.t = t;
  }

  @Override
  public int getStartTime() {
    return t;
  }

  @Override
  public int getEndTime() {
    return t;
  }

  void start(Shapes s, int tick){
    if (s == null) {
      throw new IllegalArgumentException("s is null");
    }
    if (tick == t){
      s.getVisibility();
    }
  }

  @Override
  public void apply(Shapes shape) {

  }

  @Override
  public void applyTweener(int frame, Shapes s) {

  }

  @Override
  public Animation changeStartTime(int i) {
    return null;
  }
}
