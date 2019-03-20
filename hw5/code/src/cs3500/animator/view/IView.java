package cs3500.animator.view;


/**
 * The view interface. To motivate the methods here
 * think about all the operations that the controller
 * would need to invoke on the view.
 */
public interface IView {

  /**
   * Transmit an error message to the view, in case the command could not be processed correctly.
   *
   * @param error the message to be displayed
   */
  void showErrorMessage(String error);

}