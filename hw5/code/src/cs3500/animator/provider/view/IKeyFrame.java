package cs3500.animator.model;

import java.awt.Color;
import java.awt.Point;

/**
 * The Keyframe interface. It's a interface of the keyframe type that runs the animation in tick
 * separated way. It has the same effect of motions and was used when constructing and modifying the
 * animation.
 */
public interface IKeyFrame {

  /**
   * Gives a string representation that was used in showing the list of keyframe to user.
   *
   * @return the string representation of a keyframe.
   */
  String keyFrameView();


  /**
   * Getter to get the tick of the keyframe.
   *
   * @return the tick
   */
  int getTick();

  /**
   * Getter to get the position of this keyframe.
   *
   * @return the position
   */
  Point getPos();

  /**
   * Getter to get the color of this keyframe.
   *
   * @return the color
   */
  Color getCol();

  /**
   * Getter to get the width of this keyframe.
   *
   * @return the width
   */
  int getWidth();

  /**
   * Getter to get the height of this keyframe.
   *
   * @return the height
   */
  int getHeight();

}
