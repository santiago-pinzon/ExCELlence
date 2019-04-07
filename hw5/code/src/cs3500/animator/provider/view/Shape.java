package cs3500.animator.provider.view;

import java.util.List;

/**
 * This is an interface of the Shape class, which stores all the required characteristics that were
 * needed by the Animation model and Motion class.
 */
public interface Shape {

  /**
   * Add a motion to the current list of motions and sort them from start to end.
   *
   * @param m the motion to be added
   */
  void addMotion(Motion m);


  /**
   * The getter that get the list of motions from the model.
   *
   * @return the motions in model
   */
  List<Motion> getMotion();


  /**
   * The getter for the name of the shape.
   *
   * @return the name of the shape as a String
   */
  String getName();

  /**
   * The getter for the type of the shape.
   *
   * @return the shape type represented as a string
   */
  String getType();

  /**
   * The method that renders the model and giving a string with SVG format.
   *
   * @return the String represents the model applied with SVG format
   */
  String renderAsSVG(int speed);


  /**
   * The method that add a keyframe into the current keyframe list by a legal order.
   *
   * @param k the keyframe that needs to be added
   */
  void addKeyFrame(KeyFrame k);

  /**
   * A getter to get the keyframes in this shape.
   *
   * @return the keyframes
   */
  List<KeyFrame> getKeyFrame();


  /**
   * Find the current keyframe with a tick in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  KeyFrame findThisKeyFrame(int tick);

  /**
   * Find the next keyframe if it actually exist in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  KeyFrame findNextKeyFrame(int tick);

  /**
   * Return a boolean to know whether the keyframe at that tick has next keyframe that exists.
   *
   * @param tick the tick of next keyframe
   * @return the boolean representing whether it exists
   */
  boolean hasNextKeyFrame(int tick);

  /**
   * Return a boolean to know whether the keyframe at that tick has a keyframe that exists.
   *
   * @param tick the tick of this keyframe
   * @return the boolean representing whether it exists
   */
  boolean hasKeyFrame(int tick);
}
