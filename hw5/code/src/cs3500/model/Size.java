package cs3500.model;

/**
 * Represents the animation of shrinking/growing.
 */

public class Size extends AbstractAnimation {
  private int height;
  private int width;

  /**
   * Constructs Size with a given startTime, endTime, height and width.
   *
   * @param startTime the startTime of the animation
   * @param endTime   the endTime of the animation
   * @param height    the new height of the shape
   * @param width     the new width of the shape
   * @throws IllegalArgumentException if the endTime is <= the startTime
   */

  public Size(int startTime, int endTime, int height, int width) {
    super(startTime, endTime);
    this.height = height;
    this.width = width;
  }


  @Override
  public void apply(Shapes shape) {
    shape.changeSize(height, width);
  }
}
