package cs3500.animator.provider.view;

import java.awt.Color;
import java.awt.Point;

public class KeyFrame implements IKeyFrame {

  /**
   * Gives a string representation that was used in showing the list of keyframe to user.
   *
   * @return the string representation of a keyframe.
   */
  @Override
  public String keyFrameView() {
    return null;
  }

  /**
   * Getter to get the tick of the keyframe.
   *
   * @return the tick
   */
  @Override
  public int getTick() {
    return 0;
  }

  /**
   * Getter to get the position of this keyframe.
   *
   * @return the position
   */
  @Override
  public Point getPos() {
    return null;
  }

  /**
   * Getter to get the color of this keyframe.
   *
   * @return the color
   */
  @Override
  public Color getCol() {
    return null;
  }

  /**
   * Getter to get the width of this keyframe.
   *
   * @return the width
   */
  @Override
  public int getWidth() {
    return 0;
  }

  /**
   * Getter to get the height of this keyframe.
   *
   * @return the height
   */
  @Override
  public int getHeight() {
    return 0;
  }
}
