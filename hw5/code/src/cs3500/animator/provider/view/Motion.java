package cs3500.animator.provider.view;

public class Motion implements cs3500.animator.model.IMotion {

  /**
   * This is a method that gives a string representation of all information stored in Motion class.
   *
   * @return the String represents the model with the information stored with it.
   */
  @Override
  public String renderAsString() {
    return null;
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
    return null;
  }

  /**
   * A method that get the ending of keyframe.
   *
   * @return the ending which is the last element in keyframe list
   */
  @Override
  public KeyFrame getEndKeyFrame() {
    return null;
  }

  public int getTickStart() {
    return 0;
  }

  public int getTickEnd() {
    return 0;
  }
}
