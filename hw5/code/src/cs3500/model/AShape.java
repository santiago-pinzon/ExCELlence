package cs3500.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Represents an abstract class for shapes. The shapes which extend this class only differ in their
 * name and as a result, the majority of the code has been abstracted.
 */
public abstract class AShape implements Shapes {

  private HashMap<Integer, ArrayList<Animation>> actions;

  private LinkedHashMap<Integer, KeyFrame> keyframes;

  private ArrayList<Integer> keyPoints;
  protected Position center;
  protected int height;
  protected int width;
  protected Color color;
  protected String name;
  protected String desc;
  protected boolean visible;
  protected int startTime;
  protected int endTime;

  /**
   * Constructs an abstract shape.
   *
   * @param center the position of the shape
   * @param height the height of the shape
   * @param width the width of the shape
   * @param color the color of the shape
   * @param name the name of the shape
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

    this.keyframes = new LinkedHashMap<>();

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
    for (int i = 1; i < keyPoints.size(); i++) {
      output += this.getDescription(i);
    }

    return output;
  }

  @Override
  public String getDescription(int key) {
    String out = "motion\t" + this.name + "\t";
    out += keyframes.get(keyPoints.get(key)) + "\t\t";
    out += keyframes.get(keyPoints.get(key + 1)) + "\n";
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
    /*  if (keyPoints.size() > 0 && key < actions.get(keyPoints.get(keyPoints.size() - 1)).get(0)
          .getEndTime()) {
        throw new IllegalArgumentException("Start time for new animation (" + key + ") does not "
            + "match up with end time for previous animation: " + actions
            .get(keyPoints.get(keyPoints.size() - 1)).get(0)
            .getEndTime());
      }
      */
      keyPoints.add(key);
      Collections.sort(keyPoints);
    }

    if (!actions.containsKey(key)) {
      actions.put(key, new ArrayList<Animation>());
    }

    actions.get(key).add(animate);
  }

  @Override

  public void addKeyFrame2(Animation animate) {
    int key = animate.getStartTime();

    if (!keyPoints.contains(key)) {
    /*  if (keyPoints.size() > 0 && key < actions.get(keyPoints.get(keyPoints.size() - 1)).get(0)
          .getEndTime()) {
        throw new IllegalArgumentException("Start time for new animation (" + key + ") does not "
            + "match up with end time for previous animation: " + actions
            .get(keyPoints.get(keyPoints.size() - 1)).get(0)
            .getEndTime());
      }
      */
      keyPoints.add(key);
      Collections.sort(keyPoints);
    }

    if (!keyframes.containsKey(key)) {

    }

    actions.get(key).add(animate);
  }


  @Override
  public void addKeyFrame(int t, cs3500.model.KeyFrame key) {
    if (!keyPoints.contains(t)) {
      keyPoints.add(t);
      Collections.sort(keyPoints);
    }
    System.out.println("ADDING KEYFRAME");
    this.keyframes.put(t, key);
  }


  @Override
  public void removeKeyFrame(int t) {
    if (!this.keyPoints.contains(t)) {
      throw new IllegalArgumentException("This keypoint does not exist");
    } else {
      this.keyframes.remove(t);
    }
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
   *
   * @param tick the tick for the tweener.
   */
  public void getTweener(int tick) {
    int keyFrame = keyPoints.get(0);
    double ratio = 1.0;
    int i;
    for (i = 0; i < keyPoints.size(); i++) {
      if (keyPoints.get(i) > tick) {
        i--;
        break;
      } else {
        keyFrame = keyPoints.get(i);
      }
    }
    if (i > 0) {
      KeyFrame one = this.keyframes.get(keyFrame);
      if (i < keyPoints.size() - 1) {
        KeyFrame two = this.keyframes.get(keyPoints.get(i + 1));
        int difference = two.getKey() - one.getKey();
        int length = tick - one.getKey();
        ratio = (double) length / difference;
        //ratio += 1;
        this.setTweener(new KeyFrame(one, two, ratio));
      } else {
        this.setTweener(one);
      }
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

  @Override
  public void modifyKeyFrame(int t, int x, int y, int w, int h, int r, int g, int b) {
    this.removeKeyFrame(t);
    this.addKeyFrame(t, new KeyFrame(t, x, y, w, h, r, g, b));
  }

  @Override
  public void changeStartTime(int t) {
    this.startTime = t;
  }

  @Override
  public void changeEndTime(int t) {
    this.endTime = t;
  }

  @Override
  public boolean getVisibility() {
    return false;
  }


  public int getEnd() {
    return keyPoints.get(keyPoints.size() - 1);
  }

  public boolean containsKey(int t) {
    return this.keyPoints.contains(t);
  }

  public void setTweener(KeyFrame frame) {
    this.center = new Position(frame.getX(), frame.getY());
    this.width = frame.getW();
    this.height = frame.getH();
    this.color = new Color(frame.getR(), frame.getG(), frame.getB());
  }

  public ArrayList<Integer> getKeyPoints() {
    return this.keyPoints;
  }

}
