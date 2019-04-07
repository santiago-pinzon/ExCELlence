package cs3500.animator.provider.view;

import cs3500.animator.model.Animation2DModel;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionListener;


/**
 * The view interface of the animation that supports different type of views using the model
 * provided.
 */
public interface IView {

  /**
   * Render the model in view and show it by the given way.
   *
   * @param model the model of the animation
   */
  void show(Animation2DModel model);

  /**
   * Start the animation in the user edit view.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void start() throws UnsupportedOperationException;

  /**
   * Pause the animation in the user edit view.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void pause() throws UnsupportedOperationException;

  /**
   * Restart the animation in the user edit view.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void restart() throws UnsupportedOperationException;

  /**
   * Enable the auto play for animation in user edit view.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void autoPlay() throws UnsupportedOperationException;

  /**
   * Make the speed of the animation faster in user edit view.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void speedUp() throws UnsupportedOperationException;

  /**
   * Make the speed of the animation slower in user edit view.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void speedDown() throws UnsupportedOperationException;

  /**
   * Pass in all the listeners required for user.
   *
   * @param c the action listeners for buttons
   * @param l the list selection listerns for lists
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void setListeners(ActionListener c, ListSelectionListener l)
      throws UnsupportedOperationException;

  /**
   * The method that shows the keyframes when the user choose a shape.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void showKeyFrameSelected() throws UnsupportedOperationException;


  /**
   * The method for deleting a shape or a keyframe of the shape.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void delete() throws UnsupportedOperationException;

  /**
   * The method for deleting a shape or a keyframe of the shape.
   *
   * @throws UnsupportedOperationException for the type of view that doesn't need this
   */
  void add() throws UnsupportedOperationException;


}
