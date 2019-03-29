package cs3500.model;

/**
 * Interface for animations. Each animation represents one kind of change that can occur. eg:
 * motion, size change, color change.
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
   * Calculates the "tweener" value for an animation given a shape. This is done by calculating the
   * difference between the before and after of the shape, and then scales it to how much of the
   * animation has occurred.
   *
   * @param frame the frame of the animation, scaled to where 0 is the first frame of the animation
   * @param s     the shape upon which the tweener should be applied
   */
  void applyTweener(int frame, Shapes s);


}
