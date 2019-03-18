package cs3500.model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;

/**
 * Represents an abstract class for shapes.
 */

public abstract class AShape implements Shapes {

  public HashMap<Integer, ArrayList<Animation>> actions;
  public ArrayList<Integer> keyPoints;
  protected Position center;
  protected int height;
  protected int width;
  protected Color color;
  protected String name;
  protected String desc;
  private List<Animation> animations;

  /**
   * Constructs an abstract shape.
   *
   * @param center the position of the shape
   * @param height the height of the shape
   * @param width the width of the shape
   * @param color the color of the shape
   * @param name the name of the shape
   * @throws IllegalArgumentException if the height is <= 0
   * @throws IllegalArgumentException if the width is <= 0
   */

  public AShape(Position center, int height, int width, Color color, String name) {
    if (height <= 0) {
      throw new IllegalArgumentException("Height cannot be negative");
    }
    if (width <= 0) {
      throw new IllegalArgumentException("Width cannot be negative");
    }
    this.center = center;
    this.height = height;
    this.width = width;
    this.color = color;
    this.name = name;
    this.actions = new HashMap<>();
    this.keyPoints = new ArrayList<>();
  }


  @Override
  public void changeSize(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public void changePosition(Position p) {
    this.center = p;
  }

  @Override
  public void changeColor(Color c) {
    this.color = c;
  }

  @Override
  public String getFullDescription() {
    String output = "shape " + this.name + " " + this.desc + "\n";
    for (int key : keyPoints) {
      output += this.getDescription(key);
    }

    return output;
  }

  @Override
  public String getDescription(int key) {
    String out = "motion\t" + this.name + "\t";

    out += String.format("%-5s %s %-5s %-5s %s", key, this.center.toString(), this.height,
        this.width, this.color.toString()) + "\t\t";
    this.performActions(key);
    out += String.format("%-5s %s %-5s %-5s %s", actions.get(key).get(0).getEndTime(),
        this.center.toString(), this.height, this.width, this.color.toString()) + "\n";

    return out;
  }

  @Override
  public String getName() {
    return this.name;
  }


  @Override
  public void addAction(Animation animate) {
    int key = animate.getStartTime();

    if (!keyPoints.contains(key)) {
      if (keyPoints.size() > 0 && key < actions.get(keyPoints.get(keyPoints.size() - 1)).get(0)
          .getEndTime()) {
        throw new IllegalArgumentException("Start time for new animation (" + key +") does not "
            + "match up with end time for previous animation: " + actions.get(keyPoints.get(keyPoints.size() - 1)).get(0)
            .getEndTime());
      }
      keyPoints.add(key);
      Collections.sort(keyPoints);
    }

    if (!actions.containsKey(key)) {
      actions.put(key, new ArrayList<Animation>());
    }

    actions.get(key).add(animate);
  }

  @Override
  public void performActions(int key) {
    for (Animation a : actions.get(key)) {
      a.apply(this);
    }
  }

  public String getDesc() {
    return desc;
  }

  public java.awt.Color getActualColor() {
    return new java.awt.Color(this.color.r, this.color.g, this.color.b);
  }

  public int getX() {
    return this.center.getX();
  }

  public int getY() {
    return this.center.getY();
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

<<<<<<< HEAD






  public void getTweener(int tick) {
    int keyFrame = 0;
    ArrayList<Animation> animations;
    for(int i = 0; i < keyPoints.size(); i++) {
      if(keyPoints.get(i) > tick) {
        break;
      }
      else {
        keyFrame = keyPoints.get(i);
      }
    }
    animations = this.actions.get(keyFrame);
=======
  public void getTweener(int tick) {
    int keyFrame = keyPoints.get(0);
    ArrayList<Animation> toBeDone;
    for (int i = 0; i < keyPoints.size(); i++) {
      if (keyPoints.get(i) > tick) {
        break;
      } else {
        keyFrame = keyPoints.get(i);
      }
    }
    toBeDone = this.actions.get(keyFrame);

    for (Animation a : toBeDone) {
      // send in the number of ticks after the start of the animation
      a.applyTweener(tick - a.getStartTime(), this);
    }
  }

>>>>>>> 5d896be15ca16b7e9caeb413827e0f182beeea17

  public int getRed() {
    return color.r;
  }

  public int getBlue() {
    return color.b;
  }

  public int getGreen() {
    return color.g;
  }

  @Override
  public List<Animation> getAnimations() {
    return animations;
  }


}

