package cs3500.animator.provider.view;

import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.Ellipse;
import cs3500.model.KeyFrame;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Shapes;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * This represents an adapter from our version of the animation model to that provided by the
 * providers.
 */
public class ModelAdapter implements Animation2DModel {

  private AnimationModelImpl in;

  /**
   * This adapter takes in an AnimationModelImpl to be adapted to the behavior desired by the
   * provider view.
   *
   * @param model The model to be adapted.
   */
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
    List<Motion> motions = new ArrayList();
    int end = this.in.getLength();
    for (Shapes s : this.in.getShapes()) {
      if (s.getKeyPoints().contains(end)) {
        motions
            .add(new Motion(s.getKeyFrames().get(s.getKeyPoints().get(s.getKeyPoints().size() - 2)),
                s.getKeyFrames().get(end)));
        return motions;
      }
    }
    return motions;
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
    return new Point(this.in.getX(), this.in.getY());
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

    for (Shapes s : old) {
      temp.add(new ShapeAdapter(s));
    }

    return temp;
  }

  /**
   * Add a shape into the current list by entering the shape name and the shape type.
   *
   * @param shape the name of the shape
   * @param type the type of the shape
   */
  @Override
  public void addShape(String shape, String type) {
    if (type.equals("ellipse")) {
      this.in.addShape(new Ellipse(new Position(0, 0), 0, 0,
          new Color(0, 0, 0), shape, false));
    }
    if (type.equals("rectangle")) {
      this.in.addShape(new Rectangle(new Position(0, 0), 0, 0,
          new Color(0, 0, 0), shape, false));
    } else {
      throw new IllegalArgumentException("Type of shape not recognized");
    }
  }

  /**
   * Delete a shape in the current list.
   *
   * @param shape the name of the shape  wanted to be deleted.
   */
  @Override
  public void deleteShape(String shape) {
    this.in.removeShape(shape);
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
    this.in.addKeyFrame(name, tick, new KeyFrame(tick, x, y, height, width, r, g, b));
  }

  /**
   * Delete a keyframe by entering the shape name and the keyframe string representation.
   *
   * @param shape the name of the shape
   * @param keyFrame the keyframe string representation that hold this shape
   */
  @Override
  public void deleteKeyFrame(String shape, String keyFrame) {
    Integer layer = this.in.getLayer(shape);
    Shapes s = this.in.getHash().get(layer).get(shape);
    KeyFrame k = s.findKeyFrame(keyFrame);
    if (k != null) {
      this.in.removeKeyFrame(shape, k.getKey());
    }
  }
}
