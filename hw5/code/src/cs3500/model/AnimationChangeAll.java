package cs3500.model;

public class AnimationChangeAll extends AbstractAnimation {

  private int w;
  private int h;
  private Position p;
  private Color c;

  public AnimationChangeAll(int startTime, int endTime, int w, int h, Position p, Color c){
    super(startTime, endTime);
    this.w = w;
    this.h = h;
    this.p = p;
    this.c = c;
  }
  @Override
  public void apply(Shapes shape) {

  }

  @Override
  public void applyTweener(int frame, Shapes s) {

  }

  @Override
  public Animation changeStartTime(int i) {
    return new AnimationChangeAll(i, endTime, w, h, p, c);
  }
}
