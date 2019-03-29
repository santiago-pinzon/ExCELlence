package cs3500.animator.util;

import cs3500.model.AnimationModel;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Ellipse;
import cs3500.model.Motion;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Shapes;
import cs3500.model.Size;
import java.util.LinkedHashMap;

/**
 * Represents an AnimationBuilder which is capable of taking a formatted imput file and
 * converting it to an animation model.
 */
public class AnimationBuilderImpl implements AnimationBuilder<AnimationModel> {

  private int x;
  private int y;
  private int width;
  private int height;
  LinkedHashMap<String, Shapes> listOfShapes = new LinkedHashMap<>();
  LinkedHashMap<String, String> shapesToBeInstantiated = new LinkedHashMap<>();
  private int animationLength;


  /**
   * Constructs a final document.
   *
   * @return the newly constructed document
   */
  @Override
  public AnimationModel build() {
    return new AnimationModelImpl(this.listOfShapes, this.height, this.width, this.x, this.y);
  }

  /**
   * Specify the bounding box to be used for the animation.
   *
   * @param x The leftmost x value
   * @param y The topmost y value
   * @param width The width of the bounding box
   * @param height The height of the bounding box
   * @return This {@link AnimationBuilder}
   */
  @Override
  public AnimationBuilder setBounds(int x, int y, int width, int height) {
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
    return this;
  }

  /**
   * Adds a new shape to the growing document.
   *
   * @param name The unique name of the shape to be added. No shape with this name should already
   *        exist.
   * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
   *        shapes is unspecified, but should include "ellipse" and "rectangle" as a minimum.
   * @return This {@link AnimationBuilder}
   */
  @Override
  public AnimationBuilder declareShape(String name, String type) {
    shapesToBeInstantiated.put(name, type);
    return this;
  }

  /**
   * Adds a transformation to the growing document.
   *
   * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
   * @param t1 The start time of this transformation
   * @param x1 The initial x-position of the shape
   * @param y1 The initial y-position of the shape
   * @param w1 The initial width of the shape
   * @param h1 The initial height of the shape
   * @param r1 The initial red color-value of the shape
   * @param g1 The initial green color-value of the shape
   * @param b1 The initial blue color-value of the shape
   * @param t2 The end time of this transformation
   * @param x2 The final x-position of the shape
   * @param y2 The final y-position of the shape
   * @param w2 The final width of the shape
   * @param h2 The final height of the shape
   * @param r2 The final red color-value of the shape
   * @param g2 The final green color-value of the shape
   * @param b2 The final blue color-value of the shape
   * @return This {@link AnimationBuilder}
   */
  @Override
  public AnimationBuilder addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1,
      int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2,
      boolean visible) {
    if (listOfShapes.get(name) == null) {
      String type = shapesToBeInstantiated.get(name);

      switch (type) {
        case "ellipse":
          Ellipse e = new Ellipse(new Position(x1, y1), h1, w1, new Color(r1, g1, b1),
              name, visible);
          listOfShapes.put(name, e);
          if (t1 != t2) {
            this.addAnimation(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
          }
          break;
        case "rectangle":
          Rectangle r = new Rectangle(new Position(x1, y1), h1, w1, new Color(r1,g1,b1),
              name, visible);
          listOfShapes.put(name, r);
          if (t1 != t2) {
            this.addAnimation(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
          }
          break;
        default:
          throw new IllegalArgumentException("This shape is not valid");
      }
    }
    else {
      this.addAnimation(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
    }
    return this;
  }

  /**
   * Adds an animation to the specific shape. This checks the arguments to determine which type
   * of motion it is and adds it to the desired shape
   * @param name the name of the shape
   * @param t1 The start time of this transformation
   * @param x1 The initial x-position of the shape
   * @param y1 The initial y-position of the shape
   * @param w1 The initial width of the shape
   * @param h1 The initial height of the shape
   * @param r1 The initial red color-value of the shape
   * @param g1 The initial green color-value of the shape
   * @param b1 The initial blue color-value of the shape
   * @param t2 The end time of this transformation
   * @param x2 The final x-position of the shape
   * @param y2 The final y-position of the shape
   * @param w2 The final width of the shape
   * @param h2 The final height of the shape
   * @param r2 The final red color-value of the shape
   * @param g2 The final green color-value of the shape
   * @param b2 The final blue color-value of the shape
   */
  private void addAnimation(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
      int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    if (x1 != x2 || y1 != y2) {
      //System.out.println("ADDING NEW MOTION " + name + " T1: " + t1 + " T2: " + t2);
      this.listOfShapes.get(name).addAction(new Motion(t1, t2, new Position(x2, y2)));
    }
    else if (w1 != w2 || h1 != h2) {
      //System.out.println("ADDING NEW HEIGHT " + name + " T1: " + t1 + " T2: " + t2);
      this.listOfShapes.get(name).addAction(new Size(t1, t2, h2, w2));
    }
    else if (r1 != r2 || g1 != g2 || b1 != b2) {
      //System.out.println("ADDING NEW COLOR " + name + " T1: " + t1 + " T2: " + t2);
      this.listOfShapes.get(name).addAction(new ColorChange(t1, t2, new Color(r2, g2, b2)));
    }
    else {
      //System.out.println("ADDING NEW PAUSE " + name + " T1: " + t1 + " T2: " + t2);
      this.listOfShapes.get(name).addAction(new Motion(t1, t2, new Position(x2, y2)));
    }
  }

  /**
   * Adds an individual keyframe to the growing document.
   *
   * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
   * @param t The time for this keyframe
   * @param x The x-position of the shape
   * @param y The y-position of the shape
   * @param w The width of the shape
   * @param h The height of the shape
   * @param r The red color-value of the shape
   * @param g The green color-value of the shape
   * @param b The blue color-value of the shape
   * @return This {@link AnimationBuilder}
   */
  @Override
  public AnimationBuilder addKeyframe(String name, int t, int x, int y, int w, int h, int r, int g,
      int b) {
    if (animationLength < t){
      this.animationLength = t;
    }
    for (Shapes s : listOfShapes.values()){
      if (s.getName().equals(name)){
        s.addKeyFrame(t, x, y, w, h, r, g, b);
        this.addMotion(s.getName(), t, s.getX(), s.getY(), s.getWidth(), s.getHeight(), s.getRed(), s.getGreen(), s.getBlue(),
                t, x, y, w, h, r, g, b, true);

      } 

      }

    return this;
  }


  @Override
  public LinkedHashMap<String, Shapes> getHash() {
    return listOfShapes;
  }
}
