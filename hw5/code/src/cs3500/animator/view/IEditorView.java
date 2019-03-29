
package cs3500.animator.view;

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
}


