package cs3500.animator.provider.view;

/**
 * This class is an adapter class to hold the place of the Motion Class defined in the provider
 * code. It serves very little purpose outside of holding two keyFrames which represent the start
 * and end states of an animation.
 */
public class Motion implements cs3500.animator.model.IMotion {
  private cs3500.model.KeyFrame start;
  private cs3500.model.KeyFrame end;

  /**
   * This class takes in two keyFrames to represent the initial and end states of the Motion.
   * @param start The start KeyFrame.
   * @param end The end KeyFrame.
   */
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
