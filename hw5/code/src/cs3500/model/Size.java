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
   * @throws IllegalArgumentException if the endTime is <= the startTime or if height and width
   *            are negative
   */

  public Size(int startTime, int endTime, int height, int width) {
    super(startTime, endTime);
    if (height < 0) {
      throw new IllegalArgumentException("Cannot have a negative height");
    }
    if (width < 0) {
      throw new IllegalArgumentException("Cannot have a negative Width");
    }
    this.height = height;
    this.width = width;
  }


  @Override
  public void apply(Shapes shape) {
    shape.changeSize(height, width);
  }

  @Override
  public void applyTweener(int frame, Shapes s) {
    int length = this.endTime - this.startTime;
    double ratio = (double) frame / length * 1;

    int fromW = s.getWidth();
    int fromH = s.getHeight();


    int wDifference = width - fromW;
    int hDifference = height - fromH;


    fromW += wDifference * ratio;
    fromH += hDifference * ratio;


    s.changeSize(fromH, fromW);
  }

  @Override
  public Animation changeStartTime(int i) {
    return new Size(i, endTime, height, width);
  }

}

