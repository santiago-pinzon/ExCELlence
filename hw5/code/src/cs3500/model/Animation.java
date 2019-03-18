package cs3500.model;

/**
 * Interface for animations.
 */

public interface Animation {

  /**
   * Gets the startTime of the animation.
   *
   * @return the startTime of the animation.
   */

  int getStartTime();

  /**
   * Gets the endTime of the animation.
   *
   * @return the endTime of the animation.
   */

  int getEndTime();

  /**
   * Applies an animation to the given shape.
   *
   * @param shape the shape that is getting animated
   */

  void apply(Shapes shape);


  /**
   * Renders the animation. MORE HERE
   */
  void applyTweener(int frame, Shapes s);


}
