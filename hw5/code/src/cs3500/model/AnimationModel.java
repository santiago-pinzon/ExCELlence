package cs3500.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Interface for the Animation Model.
 */

public interface AnimationModel {

  /**
   * Adds the given shape to the list of shapes.
   *
   * @param shape the shape being added to the list of shapes.
   * @throws IllegalArgumentException if a shape is already in the list of shapes with that shapes
   *                                  name.
   */

  public void addShape(Shapes shape);

  /**
   * Adds an animation to the given shape.
   *
   * @param shape   the shape getting the animation.
   * @param animate the animation being given to the shape.
   * @throws IllegalArgumentException if the given shape is not in the list of shapes.
   */

  public void addAnimation(String shape, Animation animate);


  /**
   * Gets the animation as a string.
   *
   * @return the full animation as a string.
   */
  String getAnimation();


  /**
   * Updates the shapes based on the tick number of the animation over all.
   *
   * @param tick the time tick of the animation
   */
  void updateShapes(int tick);

  /**
   * Gets the shapes of the animation.
   *
   * @return ArrayList of Shapes which includes the shapes in the animation
   */
  ArrayList<Shapes> getShapes();

  /**
   * Adds shapes to the arrayList of shapes.
   *
   * @param s shape being added to the arraylist.
   */
  void addShapesToArray(Shapes s);


  /**
   * removes a shape from the animation.
   *
   * @param name the name of the shape to be removed.
   */
  void removeShape(String name);

  /**
   * Gets the length of the animation.
   *
   * @return length of the animation
   */
  int getLength();

  /**
   * Edits the keyFrame.
   *
   * @param name  name of the keyframe
   * @param key   frame of the animation model
   * @param frame keyframe being edited
   */
  void editKeyFrame(String name, int key, KeyFrame frame);

  /**
   * Adds the keyFrame to the animation model.
   *
   * @param name  name of the keyframe
   * @param key   frame of the animation model
   * @param frame keyframe being edited
   */
  void addKeyFrame(String name, int key, KeyFrame frame);


  /**
   * Removes the keyFrame.
   *
   * @param name name of the keyframe
   * @param key  frame of the animation model
   */
  void removeKeyFrame(String name, int key);

  /**
   * Gets height of the animation model.
   *
   * @return height of the animation model
   */
  int getHeight();

  /**
   * Gets width of the animation model.
   *
   * @return width of the animation model
   */
  int getWidth();

  /**
   * Gets x value of the animation model.
   *
   * @return x value of the animation model
   */
  int getX();

  /**
   * Gets y value of the animation model.
   *
   * @return y value of the animation model
   */
  int getY();

  /**
   * Returns the hashmap of Shapes
   * @return the hashmap of shapes.
   */
  LinkedHashMap<String, Shapes> getHash();



}