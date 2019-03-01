package cs3500.model;

/**
 * Represents the animation of moving.
 */

public class Motion extends AbstractAnimation {
  Position to;

  /**
   * Constructs a Motion with a given startTime, endTime and Position.
   *
   * @param startTime represents the startTime of the animation
   * @param endTime   represents the endTime of the animation
   * @param to        represents the position being moved to
   * @throws IllegalArgumentException if the endTime is <= the startTime
   */

  public Motion(int startTime, int endTime, Position to) {
    super(startTime, endTime);

    this.to = to;
  }

  @Override
  public void apply(Shapes shape) {
    shape.changePosition(this.to);
  }


}
