package cs3500.animator.view;

/**
 * Interface for SVGView that will use an XML-based format that
 * can be used to describe images and animations.
 */


public interface ISVGView extends IView {

  /**
   * Method that creates the output of the animations in an SVG format.
   */

  void output();

}
