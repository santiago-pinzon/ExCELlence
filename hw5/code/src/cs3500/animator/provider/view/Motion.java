package cs3500.animator.provider.view;

public class Motion implements cs3500.animator.model.IMotion {
  cs3500.model.KeyFrame start;
  cs3500.model.KeyFrame end;

  public Motion(cs3500.model.KeyFrame start, cs3500.model.KeyFrame end) {
    this.start = start;
    this.end = end;
  }

  /**
   * This is a method that gives a string representation of all information stored in Motion class.
   *
   * @return the String represents the model with the information stored with it.
   */
  @Override
  public String renderAsString() {
    throw new UnsupportedOperationException("This action is not supported");
  }

  /**
   * A method that takes a shape and applying the format of SVG to it.
   *
   * @param shape the Shape that needs to be handled
   * @param speed the speed of the animation
   * @return the String representation of the shape with SVG format.
   */
  @Override
  public String renderAsSVG(String shape, int speed) {
    throw new UnsupportedOperationException("This action is not supported");
  }

  /**
   * A method that get the ending of keyframe.
   *
   * @return the ending which is the last element in keyframe list
   */
  @Override
  public KeyFrame getEndKeyFrame() {
    return new KeyFrame(end);
  }

  public int getTickStart() {
    return start.getKey();
  }

  public int getTickEnd() {

    return end.getKey();
  }
}
