package cs3500.model;


/**
 * Represents a rectangle shape.
 */

public class Rectangle extends AShape {

  /**
   * Constructs a rectangle with a given position, height, width, color, name.
   *
   * @param center the center position of the rectangle
   * @param height the height of the rectangle
   * @param width  the width of the rectangle
   * @param color  the color of the rectangle
   * @param name   the name of the rectangle
   */

  public Rectangle(Position center, int height, int width, Color color, String name, boolean visible) {
    super(center, height, width, color, name, visible);
    this.desc = "Rectangle";
  }

}
