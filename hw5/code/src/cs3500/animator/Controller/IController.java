package cs3500.animator.Controller;

import cs3500.model.Shapes;

/**
 * This interface represents a controller, which is the link between the model and the view.
 */
public interface IController {

  /**
   * Updates the Hash of shapes stored in the view to show any changes that have been made.
   */
  void updateView();

  /**
   * Adds a shape to the model.
   *
   * @param shape the shape to be added.
   */
  void addShape(Shapes shape);


  /**
   * Removes a shape from the model.
   *
   * @param shape the shape to be removed.
   */
  void removeShape(String shape);

  /**
   * Adds a keyFrame to the model.
   *
   * @param key value of the keyframe
   */
  void addKeyFrame(int key);

  /**
   * Removes a keyframe from the model.
   */
  void removeKeyFrame();


}
