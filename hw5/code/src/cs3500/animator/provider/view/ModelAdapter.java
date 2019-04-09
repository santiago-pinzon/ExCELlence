package cs3500.animator.provider.view;

import cs3500.model.AnimationModelImpl;
import cs3500.model.Shapes;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ModelAdapter implements Animation2DModel {

  AnimationModelImpl in;

  public ModelAdapter(AnimationModelImpl model) {
    this.in = model;
  }

  /**
   * This method return all the motion details as a String representation.
   *
   * @return a String representation
   */
  @Override
  public String asText() {
    throw new UnsupportedOperationException("This action is unsupported");
  }

  /**
   * This method return all the motion details as a SVG format String representation.
   *
   * @param speed the speed of the animation
   * @return a String repsentation applied with SVG format
   */
  @Override
  public String asSVG(int speed) {
    throw new UnsupportedOperationException("This action is unsupported");
  }

  /**
   * This method return all the motions.
   *
   * @return all the motions
   */
  @Override
  public List<Motion> getMotion() {
    return null;
  }

  /**
   * The getter of the width of the canvas.
   *
   * @return a copy of width of canvas
   */
  @Override
  public int getWidth() {
    return in.getWidth();
  }

  /**
   * The getter of the height of the canvas.
   *
   * @return a copy of height of canvas
   */
  @Override
  public int getHeight() {
    return in.getHeight();
  }

  /**
   * The getter of the corner point of the canvas.
   *
   * @return a copy of the corner of the canvas
   */
  @Override
  public Point getCorner() {
    return new Point(this.in.getX(),this.in.getY());
  }

  /**
   * This method return all the shapes.
   *
   * @return all the shapes
   */
  @Override
  public List<Shape> getShape() {
    List<Shape> temp = new ArrayList<>();
    ArrayList<Shapes> old = this.in.getShapes();

    for(Shapes s: old) {
      temp.add(new ShapeAdapter(s));
    }
  }

  /**
   * Add a shape into the current list by entering the shape name and the shape type.
   *
   * @param shape the name of the shape
   * @param type the type of the shape
   */
  @Override
  public void addShape(String shape, String type) {

  }

  /**
   * Delete a shape in the current list.
   *
   * @param shape the name of the shape  wanted to be deleted.
   */
  @Override
  public void deleteShape(String shape) {

  }

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
  @Override
  public void addKeyFrame(String name, int tick, int x, int y, int r, int g, int b, int width,
      int height) {

  }

  /**
   * Delete a keyframe by entering the shape name and the keyframe string representation.
   *
   * @param shape the name of the shape
   * @param keyFrame the keyframe string representation that hold this shape
   */
  @Override
  public void deleteKeyFrame(String shape, String keyFrame) {

  }
}
