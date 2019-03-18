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

  @Override
  public void applyTweener(int frame, Shapes s) {
    int length = this.endTime - this.startTime;
    double ratio = (double) frame/length * 1;

    int fromX = s.getX();
    int fromY = s.getY();

    int xDifference = to.getX() - fromX;
    int yDifference = to.getY() - fromY;

    fromX += xDifference * ratio;
    fromY += yDifference * ratio;

    s.changePosition(new Position(fromX, fromY));

  }

  }

