package cs3500.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Represents an abstract class for shapes. The shapes which extend this class only differ in
 * their name and as a result, the majority of the code has been abstracted.
 */
public abstract class AShape implements Shapes {

  private HashMap<Integer, ArrayList<Animation>> actions;
  private ArrayList<Integer> keyPoints;
  protected Position center;
  protected int height;
  protected int width;
  protected Color color;
  protected String name;
  protected String desc;
  protected boolean visible;

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

  public AShape(Position center, int height, int width, Color color, String name, boolean visible) {
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
    this.visible = visible;
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
        throw new IllegalArgumentException("Start time for new animation (" + key + ") does not "
            + "match up with end time for previous animation: " + actions
            .get(keyPoints.get(keyPoints.size() - 1)).get(0)
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
    return new java.awt.Color(this.color.getR(), this.color.getG(), this.color.getB());
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


  /**
   * gets the tweener state for the shape at the desired tick.
   * @param tick the tick for the tweener.
   */
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


  public int getRed() {
    return color.getR();
  }

  public int getBlue() {
    return color.getB();
  }

  public int getGreen() {
    return color.getG();
  }

  @Override
  public Collection<ArrayList<Animation>> getAnimations() {

    return this.actions.values();
  }

  @Override
  public boolean isVisible() {
    return this.visible;
  }


}

