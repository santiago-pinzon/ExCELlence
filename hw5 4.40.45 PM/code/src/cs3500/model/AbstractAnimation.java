package cs3500.model;

/**
 * Abstract class for animations.
 */


public abstract class AbstractAnimation implements Animation {

  protected int startTime;
  protected int endTime;


  /**
   * Constructs the Animation.
   *
   * @param startTime the startTime of the animation
   * @param endTime the endTime of the animation
   * @throws IllegalArgumentException if the endTime is <= the startTime
   */

  public AbstractAnimation(int startTime, int endTime) {
    if (endTime < startTime) {
      throw new IllegalArgumentException("end time cannot be less than or the "
              + "same as the start time");
    }
    this.startTime = startTime;
    this.endTime = endTime;
  }



  @Override
  public int getStartTime() {
    return startTime;
  }


  @Override
  public int getEndTime() {
    return endTime;
  }


  @Override
  public abstract void apply(Shapes shape);

  @Override
  public abstract void applyTweener(int frame, Shapes s);


}
