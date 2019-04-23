package cs3500.animator.provider.view;

import java.awt.Point;
import java.util.List;

/**
 * This is the interface of ExCELence implementation. It stores all the information necessary to
 * construct a view of the animation.
 */
public interface Animation2DModel {

  /**
   * This method return all the motion details as a String representation.
   *
   * @return a String representation
   */
  String asText();

  /**
   * This mehtod return all the motion details as a SVG format String representation.
   *
   * @param speed the speed of the animation
   * @return a String repsentation applied with SVG format
   */
  String asSVG(int speed);

  /**
   * This method return all the motions.
   *
   * @return all the motions
   */
  List<Motion> getMotion();


  /**
   * The getter of the width of the canvas.
   *
   * @return a copy of width of canvas
   */
  int getWidth();

  /**
   * The getter of the height of the canvas.
   *
   * @return a copy of height of canvas
   */
  int getHeight();

  /**
   * The getter of the corner point of the canvas.
   *
   * @return a copy of the corner of the canvas
   */
  Point getCorner();

  /**
   * This method return all the shapes.
   *
   * @return all the shapes
   */
  List<Shape> getShape();


  /**
   * Add a shape into the current list by entering the shape name and the shape type.
   *
   * @param shape the name of the shape
   * @param type the type of the shape
   */
  void addShape(String shape, String type);


  /**
   * Delete a shape in the current list.
   *
   * @param shape the name of the shape  wanted to be deleted.
   */
  void deleteShape(String shape);

  /**
   * Add a keyframe to the existing list of keyframes.
   *
   * @param name the name of the shape that hold this keyframe.
   * @param tick the tick of this keyframe
   * @param x the x of this keyframe
   * @param y the y of this keyframe
   * @param r the r of this keyframe
   * @param g the g of this keyframe
   * @param b the b of this keyframe
   * @param width the width of this keyframe
   * @param height the height of this keyframe
   */
  void addKeyFrame(String name, int tick, int x, int y, int r, int g, int b, int width,
      int height, int rotate);

  /**
   * Delete a keyframe by entering the shape name and the keyframe string representation.
   *
   * @param shape the name of the shape
   * @param keyFrame the keyframe string representation that hold this shape
   */
  void deleteKeyFrame(String shape, String keyFrame);


}
