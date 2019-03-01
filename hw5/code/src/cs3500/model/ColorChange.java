package cs3500.model;

/**
 * Represents the animation of changing a color.
 */

public class ColorChange extends AbstractAnimation {
  Color color;

  /**
   * Constructs a colorChange with a given startTime, endTime and color.
   *
   * @param startTime the startTime of the animation
   * @param endTime   the endTime of the animation
   * @param color     the color that the shape is being changed to
   * @throws IllegalArgumentException if the endTime is <= the startTime
   */

  public ColorChange(int startTime, int endTime, Color color) {
    super(startTime, endTime);
    this.color = color;
  }


  @Override
  public void apply(Shapes shape) {
    shape.changeColor(this.color);
  }
}
