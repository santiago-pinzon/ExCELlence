package cs3500.model;

/**
 * Represents an ellipse shape.
 */

public class Ellipse extends AShape {

  /**
   * Constructs an Ellipse with a given position, height, width, color, name.
   *
   * @param center the center position of the ellipse
   * @param height the height of the ellipse
   * @param width  the width of the ellipse
   * @param color  the color of the ellipse
   * @param name   the name of the ellipse
   */

  public Ellipse(Position center, int height, int width, Color color, String name) {
    super(center, height, width, color, name);
    this.desc = "Ellipse";
  }



}
