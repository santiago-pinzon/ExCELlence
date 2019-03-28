package cs3500.model;

import java.util.ArrayList;

/**
 * Interface for the Animation Model.
 */

public interface AnimationModel {

  /**
   * Adds the given shape to the list of shapes.
   *
   * @param shape the shape being added to the list of shapes.
   * @throws IllegalArgumentException if a shape is already in the list of shapes with that shapes
   *        name.
   */

  public void addShape(Shapes shape);

  /**
   * Adds an animation to the given shape.
   *
   * @param shape the shape getting the animation.
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

  ArrayList<Shapes> getShapes();

  void addShapesToArray(Shapes s);


  /**
   * removes a shape from the animation.
   *
   * @param name the name of the shape to be removed.
   */
  void removeShape(String name);

}