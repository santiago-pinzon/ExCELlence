package cs3500.model;


import java.util.ArrayList;
import java.util.Collection;

/**
 * The interface for shapes.
 */

public interface Shapes {

  /**
   * Makes the shape shrink/grow by the given amount.
   *
   * @param height the amount the shape will shrink by if negative amount, the shape will shrink, if
   *               positive amount the shape will grow
   */
  void changeSize(int height, int width);

  /**
   * Changes the position of the shape.
   *
   * @param p the new position for the shape.
   */
  void changePosition(Position p);

  /**
   * Changes the color of the shape.
   *
   * @param c the new color for the shape
   */
  void changeColor(Color c);

  /**
   * Gets the full description of the shape, including actions and the name.
   *
   * @return the description of the shape
   */
  String getFullDescription();

  /**
   * Gets the description of only the actions of the shape.
   *
   * @param key represents the animation
   * @return the description of the actions of the shape.
   */
  String getDescription(int key);

  /**
   * Gets the name of the shape.
   *
   * @return the name of the shape
   */
  String getName();


  /**
   * Adds the action to the animation.
   *
   * @param animate the animation being added on
   */
  void addAction(Animation animate);

  /**
   * Performs the animation.
   *
   * @param key a singular animation.
   */
  void performActions(int key);


  /**
   * Gets the description of the shape.
   *
   * @return the description of the shape
   */

  String getDesc();

  /**
   * Creates a color using the r, g, b values from this shapes color.
   *
   * @return the color of the shape
   */
  java.awt.Color getActualColor();

  /**
   * Gets the x value of the shape.
   *
   * @return the x value of the shape
   */

  int getX();

  /**
   * Gets the y value of the shape.
   *
   * @return the y value of the shape
   */
  int getY();


  /**
   * Gets the height of the shape.
   *
   * @return the height of the shape
   */
  int getHeight();


  /**
   * Gets the width of the shape.
   *
   * @return the width of the shape
   */
  int getWidth();

  /**
   * gets the tweener state for the shape at the desired tick.
   *
   * @param tick the tick for the tweener.
   */

  void getTweener(int tick);

  /**
   * Gets the red value of the shape.
   *
   * @return the red value of the shape
   */
  int getRed();

  /**
   * Gets the blue value of the shape.
   *
   * @return the blue value of the shape
   */

  int getBlue();

  /**
   * Gets the green value of the shape.
   *
   * @return the green value of the shape
   */
  int getGreen();

  /**
   * Gets the animations of the shape.
   *
   * @return the values of the shapes animations.
   */
  Collection<ArrayList<Animation>> getAnimations();

  /**
   * Checks to see if the shape is visible.
   *
   * @return true if the shape is visible
   */
  boolean isVisible();


  /**
   * Adds a keyFrame to the shape.
   *
   * @param t   a singular keyFrame
   * @param key the keyFrame being added
   */
  void addKeyFrame(int t, KeyFrame key);

  /**
   * Removes a keyFrame to the shape.
   *
   * @param t a singular keyFrame
   */

  void removeKeyFrame(int t);


  /**
   * Modifies a keyFrame.
   *
   * @param t time of the keyFrame
   * @param x x value of the keyFrame
   * @param y y value of the keyFrame
   * @param w width of the keyFrame
   * @param h height of the keyFrame
   * @param r red value of the keyFrame
   * @param g green value of the keyFrame
   * @param b blue value of the keyFrame
   */
  void modifyKeyFrame(int t, int x, int y, int w, int h, int r, int g, int b);


  /**
   * Gets the number of key points.
   *
   * @return the number of keypoints
   */
  int getEnd();


  /**
   * sets the tweener state for the shape at the desired frame.
   *
   * @param frame the keyFrame for the tweener.
   */
  void setTweener(KeyFrame frame);

  /**
   * Gets the key points of the shape.
   * @return an arraylist of the key points of the shape
   */
  ArrayList<Integer> getKeyPoints();

}

