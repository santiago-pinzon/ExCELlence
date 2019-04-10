package cs3500.animator.provider.view;

import cs3500.model.Shapes;

import java.util.Collections;
import java.util.List;

public class ShapeAdapter implements Shape{
  Shapes s;
  List<Motion> motions;
  List<KeyFrame> keys;


  public ShapeAdapter(Shapes s) {
    this.s = s;
    this.motions = motions;
    this.keys = keys;
  }


  /**
   * Add a motion to the current list of motions and sort them from start to end.
   *
   * @param m the motion to be added
   */
  @Override
  public void addMotion(Motion m) {
    if (!motions.contains(m)) {
      motions.add(m);
    }
  }

  /**
   * The getter that get the list of motions from the model.
   *
   * @return the motions in model
   */
  @Override
  public List<Motion> getMotion() {
    return motions;
  }

  /**
   * The getter for the name of the shape.
   *
   * @return the name of the shape as a String
   */
  @Override
  public String getName() {
    return s.getName();
  }

  /**
   * The getter for the type of the shape.
   *
   * @return the shape type represented as a string
   */
  @Override
  public String getType() {
    return s.getDesc();
  }

  /**
   * The method that renders the model and giving a string with SVG format.
   *
   * @return the String represents the model applied with SVG format
   */
  @Override
  public String renderAsSVG(int speed) {
    throw new UnsupportedOperationException("This action is unsupported");
  }

  /**
   * The method that add a keyframe into the current keyframe list by a legal order.
   *
   * @param k the keyframe that needs to be added
   */
  @Override
  public void addKeyFrame(KeyFrame k) {
    if (!keys.contains(k)) {
      keys.add(k);
    }
  }

  /**
   * A getter to get the keyframes in this shape.
   *
   * @return the keyframes
   */
  @Override
  public List<KeyFrame> getKeyFrame() {
    return keys;
  }

  /**
   * Find the current keyframe with a tick in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  @Override
  public KeyFrame findThisKeyFrame(int tick) {
    for (int i = 0; i < keys.size() - 1; i ++){
      if (tick >= keys.get(i).getTick()){
        return keys.get(i);
      }
    }
    throw new IllegalArgumentException("No keyframe found");
  }


  /**
   * Find the next keyframe if it actually exist in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  @Override
  public KeyFrame findNextKeyFrame(int tick) {
    for (int i = 0; i < keys.size() - 1; i++) {
      if (tick <= keys.get(i).getTick()) {
        return keys.get(i);
      }
    }
    throw new IllegalArgumentException("Can't find next keyframe");
  }

  /**
   * Return a boolean to know whether the keyframe at that tick has next keyframe that exists.
   *
   * @param tick the tick of next keyframe
   * @return the boolean representing whether it exists
   */
  @Override
  public boolean hasNextKeyFrame(int tick) {
    return  tick < keys.get(keys.size() - 1).getTick();
  }

  /**
   * Return a boolean to know whether the keyframe at that tick has a keyframe that exists.
   *
   * @param tick the tick of this keyframe
   * @return the boolean representing whether it exists
   */
  @Override
  public boolean hasKeyFrame(int tick) {
    return tick > keys.get(0).getTick() && tick <= keys.get(keys.size() - 1).getTick();
  }
}
