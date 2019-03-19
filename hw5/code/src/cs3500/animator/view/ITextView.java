package cs3500.animator.view;

/**
 * This is the interface for the textual view.  It extends the IView interface so that all three
 * views are effectively interchangeable.
 */
public interface ITextView extends IView {

  /**
   * Generates the output for the textView. Appends the output to the desired appendable.
   * @throws IllegalArgumentException if unable to append to the appendable.
   */
  void render() throws IllegalArgumentException;


}