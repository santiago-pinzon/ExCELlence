package cs3500.animator.model;

import cs3500.animator.util.AnimationBuilder;
import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class which is an implmentation of the 2DAnimation model. The model store all the
 * information that needed for the animation to run and for user to control and view.
 */
public final class Animation2DModelImpl implements Animation2DModel {

  // the list of shapes in this animation
  private List<Shape> shapes;
  // the corner of the JFrame window
  private Point corner;
  // the width of the JFrame window
  private int width;
  // the height of the JFrame window
  private int height;


  /**
   * The constructor of the animation model implementation.
   *
   * @param corner the topLeft corner of the window
   * @param width the width of the window
   * @param height the height of the window
   * @param shapes the shapes in animation
   */
  public Animation2DModelImpl(Point corner, int width, int height,
      List<Shape> shapes) {
    this.shapes = shapes;
    this.corner = corner;
    this.width = width;
    this.height = height;
  }

  public Animation2DModelImpl() {
    this.shapes = new ArrayList<>();

  }


  /**
   * This is the builder of the animation that takes the input from file and construct it into the
   * model.
   */
  public static final class Builder implements AnimationBuilder<Animation2DModel> {

    private List<Shape> shapes = new ArrayList<>();
    private Point corner;
    private int width;
    private int height;

    @Override
    public Animation2DModelImpl build() {
      return new Animation2DModelImpl(corner, width, height, shapes);
    }

    @Override
    public AnimationBuilder<Animation2DModel> setBounds(int x, int y, int width, int height) {
      this.corner = new Point(x, y);
      this.width = width;
      this.height = height;
      return this;
    }

    @Override
    public AnimationBuilder<Animation2DModel> declareShape(String name, String type) {
      if (type.equalsIgnoreCase("rectangle")) {

        this.shapes.add(new Rectangle(name));
      } else if (type.equalsIgnoreCase("ellipse")) {
        this.shapes.add(new Ellipse(name));
      }

      return this;
    }

    @Override
    public AnimationBuilder<Animation2DModel> addMotion(String name, int t1, int x1, int y1,
        int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {
      for (Shape s : this.shapes) {
        if (s.getName().equals(name)) {
          s.addMotion(
              new Motion(t1, new Point(x1, y1), w1, h1, new Color(r1, g1, b1), t2, new Point(x2,
                  y2), w2, h2, new Color(r2, g2, b2)));
        }
      }
      return this;
    }

    @Override
    public AnimationBuilder<Animation2DModel> addKeyframe(String name,
        int t, int x, int y, int w, int h, int r, int g, int b) {
      for (Shape s : shapes) {
        if (s.getName().equals(name)) {
          s.addKeyFrame(new KeyFrame(t, new Point(x, y), new Color(r, g, b), w, h));
        }
      }
      return this;
    }

  }


  /**
   * Return a String represents all the current information in this model in a visible way.
   *
   * @return The String representation of an example representation.
   */
  @Override
  public String asText() {
    String tmp = "";
    if (!this.shapes.isEmpty()) {

      for (Shape s : shapes) {
        for (int i = 0; i < s.getMotion().size(); i++) {
          if (s.getType().equalsIgnoreCase("rectangle")) {
            if (i != 0) {
              tmp += "Motion" + " " + s.getName() + " ";
              tmp += s.getMotion().get(i).renderAsString();
            } else {
              tmp += "shape " + s.getName() + " rectangle" + "\n";
              tmp += "Motion " + s.getName() + " " + s.getMotion().get(i).renderAsString();
            }

          }
          if (s.getType().equalsIgnoreCase("ellipse")) {
            if (i != 0) {
              tmp += "Motion" + " " + s.getName() + " ";
              tmp += s.getMotion().get(i).renderAsString();
            } else {
              tmp += "shape " + s.getName() + " ellipse" + "\n";
              tmp += "Motion " + s.getName() + " " + s.getMotion().get(i).renderAsString();
            }

          }
        }
      }
    }

    return tmp;
  }

  @Override
  public String asSVG(int speed) {
    String tmp = "";
    tmp += "<svg width=\"" + (this.width + 200) + "\" height=\"" + (this.height + 200)
        + "\" version=\"1.1\"\nxmlns=\"http://www.w3.org/2000/svg\">\n\n";

    for (Shape s : this.shapes) {

      tmp += s.renderAsSVG(speed);

    }
    tmp += "</svg>";
    return tmp;
  }


  /**
   * This method gives the motion list that restored in this model.
   *
   * @return a list of motions
   */
  @Override
  public List<Motion> getMotion() {
    List<Motion> motions = new ArrayList<>();
    for (Shape s : shapes) {
      for (Motion m : s.getMotion()) {
        motions.add(m);
      }
    }
    return motions;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * This method gives the shape list that restored in this model.
   *
   * @return a list of shapes
   */
  @Override
  public List<Shape> getShape() {
    return this.shapes;
  }


  /**
   * This method add a shape at the end of the shape list.
   */
  @Override
  public void addShape(String shape, String type) {
    if (type.equals("ellipse")) {
      this.shapes.add(new Ellipse(shape));
    }
    if (type.equals("rectangle")) {
      this.shapes.add(new Rectangle(shape));
    }

  }


  @Override
  public void deleteShape(String shape) {
    for (Shape s : this.shapes) {
      if (s.getName().equals(shape)) {
        shapes.remove(s);
      }
    }
  }


  @Override
  public Point getCorner() {
    return this.corner;
  }


  @Override
  public void addKeyFrame(String name, int tick, int x, int y, int r, int g, int b, int width,
      int height) {
    for (Shape s : this.shapes) {

      if (s.getName().equals(name)) {

        s.addKeyFrame(new KeyFrame(tick, new Point(x, y), new Color(r, g, b), width, height));

        return;
      }
    }


  }

  @Override
  public void deleteKeyFrame(String shape, String keyFrame) {
    for (Shape s : this.shapes) {
      if (s.getName().equals(shape)) {
        for (KeyFrame k : s.getKeyFrame()) {
          if (k.keyFrameView().equals(keyFrame)) {
            s.getKeyFrame().remove(k);
          }

        }
      }
    }
  }


}





