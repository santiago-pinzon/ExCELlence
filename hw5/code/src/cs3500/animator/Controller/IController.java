package cs3500.animator.Controller;

import cs3500.model.Shapes;

/**
 * This interface represents a controller, which is the link between the model and the view.
 */
public interface IController {

  /**
   * Updates the Hash of shapes stored in the view to show any changes that have been made.
   */
  public void updateView();

  /**
   * Adds a shape to the model.
   * @param shape the shape to be added.
   */
  public void addShape(Shapes shape);


  /**
   * Removes a shape from the model.
   * @param shape the shape to be removed.
   */
  public void removeShape(String shape);

  public void addKeyFrame(int key);

  public void removeKeyFrame();


}
