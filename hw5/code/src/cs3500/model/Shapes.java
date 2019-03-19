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
   * positive amount the shape will grow
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


  String getDesc();

  java.awt.Color getActualColor();

  int getX();

  int getY();

  int getHeight();

  int getWidth();

  void getTweener(int tick);

  int getRed();

  int getBlue();

  int getGreen();

  Collection<ArrayList<Animation>> getAnimations();
}

