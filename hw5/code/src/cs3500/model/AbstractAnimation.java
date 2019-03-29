package cs3500.model;

/**
 * Abstract class for animations. An animation holds the final state for any shape that contains it.
 * It then calculates "tweeners" based on how much of the animation has progressed.
 */
public abstract class AbstractAnimation implements Animation {
  protected int startTime;
  protected int endTime;


  /**
   * Constructs the Animation.
   *
   * @param startTime the startTime of the animation
   * @param endTime   the endTime of the animation
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


  /**
   * Returns the start point for the animation.
   *
   * @return the starting point.
   */
  @Override
  public int getStartTime() {
    return startTime;
  }


  /**
   * Returns the end time for the animation.
   *
   * @return the end time.
   */
  @Override
  public int getEndTime() {
    return endTime;
  }


  /**
   * Applies the animation to the shape.
   *
   * @param shape the shape that is getting animated.
   */
  @Override
  public abstract void apply(Shapes shape);

  /**
   * Calculates the tweener for the shape at a certain frame.
   *
   * @param frame the frame of the animation, scaled to where 0 is the first frame of the
   *              animation.
   * @param s     the shape upon which the tweener should be applied
   */
  @Override
  public abstract void applyTweener(int frame, Shapes s);


}
