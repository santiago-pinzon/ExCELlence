package cs3500.animator.provider.view;

import cs3500.model.Shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeAdapter implements Shape {

  Shapes s;
  List<Motion> motions;
  List<KeyFrame> keys;

  public ShapeAdapter(Shapes s) {
    this.s = s;
    this.motions = new ArrayList();

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
    if (!s.getKeyPoints().contains(k.getTick())) {
      s.addKeyFrame(k.getTick(), new cs3500.model.KeyFrame(k.getTick(), k.getPos().x, k.getPos().y
          , k.getHeight(), k.getWidth(), k.getCol().getRed(),
          k.getCol().getGreen(), k.getCol().getBlue()));
    }
  }

  /**
   * A getter to get the keyframes in this shape.
   *
   * @return the keyframes
   */
  @Override
  public List<KeyFrame> getKeyFrame() {
    keys = new ArrayList<>();
    for (cs3500.model.KeyFrame k : s.getKeyFrames().values()) {
      keys.add(new KeyFrame(k));
    }
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
    ArrayList<cs3500.model.KeyFrame> list = new ArrayList<>(s.getKeyFrames().values());
    KeyFrame key = new KeyFrame(new cs3500.model.KeyFrame(0, 0, 0, 0, 0, 0, 0, 0));

    for (int i = 0; i < list.size() - 1; i++) {
      if (tick < list.get(i + 1).getKey() && tick >= list.get(i).getKey()) {
        key = new KeyFrame(list.get(i));
      }
    }
    return key;
  }


  /**
   * Find the next keyframe if it actually exist in order to run the animation.
   *
   * @param tick the tick of that keyframe
   * @return the keyframe found (throw if can't)
   */
  @Override
  public KeyFrame findNextKeyFrame(int tick) {
    ArrayList<cs3500.model.KeyFrame> list = new ArrayList<>(s.getKeyFrames().values());
    KeyFrame key = new KeyFrame(new cs3500.model.KeyFrame(0, 0, 0, 0, 0, 0, 0, 0));

    for (int i = 0; i < list.size() - 1; i++) {
      if (tick < list.get(i + 1).getKey() && tick >= list.get(i).getKey()) {
        key = new KeyFrame(list.get(i + 1));
      }
    }
    return key;
  }

  /**
   * Return a boolean to know whether the keyframe at that tick has next keyframe that exists.
   *
   * @param tick the tick of next keyframe
   * @return the boolean representing whether it exists
   */
  @Override
  public boolean hasNextKeyFrame(int tick) {
    return tick < s.getKeyPoints().get(s.getKeyPoints().size() - 1);
  }

  /**
   * Return a boolean to know whether the keyframe at that tick has a keyframe that exists.
   *
   * @param tick the tick of this keyframe
   * @return the boolean representing whether it exists
   */
  @Override
  public boolean hasKeyFrame(int tick) {
    return tick >= s.getKeyPoints().get(0) && tick <= s.getKeyPoints()
        .get(s.getKeyPoints().size() - 1);
  }
}
