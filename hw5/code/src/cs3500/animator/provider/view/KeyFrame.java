package cs3500.animator.provider.view;

import java.awt.Color;
import java.awt.Point;

/**
 * This class represents an adapter between our version of a KeyFrame and that provided by the
 * provider.
 */
public class KeyFrame implements IKeyFrame {

  private cs3500.model.KeyFrame in;

  /**
   * This class holds an instance of our KeyFrame and adapts its behavior to that required by the
   * provider view.
   * @param in The KeyFrame to be adapted.
   */
  public KeyFrame(cs3500.model.KeyFrame in) {
    this.in = in;
  }

  /**
   * Gives a string representation that was used in showing the list of keyframe to user.
   *
   * @return the string representation of a keyframe.
   */
  @Override
  public String keyFrameView() {
    return this.in.getDescription();
  }

  /**
   * Getter to get the tick of the keyframe.
   *
   * @return the tick
   */
  @Override
  public int getTick() {
    return this.in.getKey();
  }

  /**
   * Getter to get the position of this keyframe.
   *
   * @return the position
   */
  @Override
  public Point getPos() {
    return new Point(this.in.getX(), this.in.getY());
  }

  /**
   * Getter to get the color of this keyframe.
   *
   * @return the color
   */
  @Override
  public Color getCol() {
    return new Color(this.in.getR(), this.in.getG(), this.in.getB());
  }

  /**
   * Getter to get the width of this keyframe.
   *
   * @return the width
   */
  @Override
  public int getWidth() {
    return this.in.getW();
  }

  /**
   * Getter to get the height of this keyframe.
   *
   * @return the height
   */
  @Override
  public int getHeight() {
    return this.in.getH();
  }

  @Override
  public int getRotate(){
    return this.in.getRotate();
  }
}
