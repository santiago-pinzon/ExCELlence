package cs3500.model;

/**
 * Represents the animation of changing a color.
 */

public class ColorChange extends AbstractAnimation {

  private Color color;

  /**
   * Constructs a colorChange with a given startTime, endTime and color.
   *
   * @param startTime the startTime of the animation
   * @param endTime the endTime of the animation
   * @param color the color that the shape is being changed to
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

  @Override
  public void applyTweener(int frame, Shapes s) {
    int length = this.endTime - this.startTime;
    double ratio = (double) frame / length;

    int fromR = s.getActualColor().getRed();
    int fromG = s.getActualColor().getGreen();
    int fromB = s.getActualColor().getBlue();

    int rDifference = color.getR() - fromR;
    int gDifference = color.getG() - fromG;
    int bDifference = color.getB() - fromB;

    fromR += rDifference * ratio;
    fromG += gDifference * ratio;
    fromB += bDifference * ratio;

    s.changeColor(new Color(fromR, fromG, fromB));
  }

}

