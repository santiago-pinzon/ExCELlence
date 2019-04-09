package cs3500.animator.model;

/**
 * This is the interface of ExCELence implementation, it stores all the information about a motion
 * in the model.
 */
public interface IMotion {


  /**
   * This is a method that gives a string representation of all information stored in Motion class.
   *
   * @return the String represents the model with the information stored with it.
   */
  String renderAsString();

  /**
   * A method that takes a shape and applying the format of SVG to it.
   *
   * @param shape the Shape that needs to be handled
   * @param speed the speed of the animation
   * @return the String representation of the shape with SVG format.
   */
  String renderAsSVG(String shape, int speed);


  /**
   * A method that get the ending of keyframe.
   *
   * @return the ending which is the last element in keyframe list
   */
  KeyFrame getEndKeyFrame();


}
