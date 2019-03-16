package cs3500.model;

import java.util.List;

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

  void updateShapes(int tick);



}