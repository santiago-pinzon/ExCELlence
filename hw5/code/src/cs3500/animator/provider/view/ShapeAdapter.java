package cs3500.animator.provider.view;

import cs3500.model.Shapes;
import java.util.List;

public class ShapeAdapter implements Shape{
  Shapes s;

  public ShapeAdapter(Shapes s) {
    this.s = s;
  }


  /**
   * Add a motion to the current list of motions and sort them from start to end.
   *
   * @param m the motion to be added
   */
  @Override
  public void addMotion(Motion m) {
     m
  }

  /**
   * The getter that get the list of motions from the model.
   *
   * @return the motions in model
   */
  @Override
  public List<Motion> getMotion() {
    return null;
  }

  /**
   * The getter for the name of the shape.
   *
   * @return the name of the shape as a String
   */
  @Override
  public String getName() {
    return null;
  }

  /**
   * The getter for the type of the shape.
   *
   * @return the shape type represented as a string
   */
  @Override
  public String getType() {
    return null;
  }

  /**
   * The method that renders the model and giving a string with SVG format.
   *
   * @return the String represents the model applied with SVG format
   */
  @Override
  public String renderAsSVG(int speed) {
    return null;
  }

  /**
   * The method that add a keyframe into the current keyframe list by a legal order.
   *
   * @param k the keyframe that needs to be added
   */
  @Override
  public void addKeyFrame(KeyFrame k) {

  }

  /**
   * A getter to get the keyframes in this shape. 
   *
   * @return the keyframes
   */
  @Override
  public List<KeyFrame> getKeyFrame() {
    return null;
  }

  /**
   * Find the current keyframe with a tick in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  @Override
  public KeyFrame findThisKeyFrame(int tick) {
    return null;
  }

  /**
   * Find the next keyframe if it actually exist in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  @Override
  public KeyFrame findNextKeyFrame(int tick) {
    return null;
  }

  /**
   * Return a boolean to know whether the keyframe at that tick has next keyframe that exists.
   *
   * @param tick the tick of next keyframe
   * @return the boolean representing whether it exists
   */
  @Override
  public boolean hasNextKeyFrame(int tick) {
    return false;
  }

  /**
   * Return a boolean to know whether the keyframe at that tick has a keyframe that exists.
   *
   * @param tick the tick of this keyframe
   * @return the boolean representing whether it exists
   */
  @Override
  public boolean hasKeyFrame(int tick) {
    return false;
  }
}
