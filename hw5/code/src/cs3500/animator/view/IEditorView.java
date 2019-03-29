
package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.io.File;

import cs3500.model.KeyFrame;
import cs3500.model.ROAnimationModel;

/**
 * Interface for the editor view that allows the user to edit the animation.
 */
public interface IEditorView extends IView {

  /**
   * Refreshes the animation.
   */
  void refresh();

  /**
   * Makes the animation visible.
   */
  void setVisible();

  /**
   * Starts the animation.
   */
  void animate();
  /**
   * Sets the model.
   *
   * @param in the ROAnimationModel being set
   */
  void setModel(ROAnimationModel in);

  /**
   * Adds the action listener to the view.
   *
   * @param listen represents the action listener
   */
  void addActionListener(ActionListener listen);
  /**
   * Slows down the animation.
   */


  void slowDown();
  /**
   * Speeds up the animation.
   */
  void speedUp();
  /**
   * Reverses the animation.
   */
  void reverse();

  /**
   * Moves the animation forward.
   */
  void forward();

  /**
   * Plays the animation.
   */
  void play();

  /**
   * Restarts the animation.
   */
  void restart();
  /**
   * Loops the animation.
   */
  void loop();

  /**
   * Gets the file being selected.
   *
   * @return file
   */
  File getFile();

  /**
   * Updates the counter.
   */
  void updateCounter();

  /**
   * Gets the name of the shape.
   * @param in represents ActionListener
   * @return the name of the shape.
   */
  String getShapeName(ActionListener in);
  /**
   * Gets the number of a key frame.
   *
   * @param name represents the name of the model
   * @return the number of a key frame
   */
  int getKeyFrameNumber(String name);

  /**
   * Gets the KeyFrame.
   * @return Keyframe
   */
  KeyFrame getKeyFrame();

  /**
   * Gets the shape type.
   * @return string of the shape type
   */
  String getShapeType();

  /**
   * Gets the name of the shape to be added.
   * @return the string of the shape name
   */
  String getShapeNameToBeAdded();

  /**
   * Get the selected file.
   * @return the file being selected 
   */
  File saveFileGetter();
}


