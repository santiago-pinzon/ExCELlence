package cs3500.animator.view;

/**
 * This is the interface for the visual view. It extends the IView interface so that all three
 * views are effectively interchangeable.
 */
public interface IAnimationView extends IView {

  /**
   * This method repaints the animation and updates the image displayed.
   */
  public void refresh();


}

