package cs3500.model;

import java.awt.Component;

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

  public Rectangle(Position center, int height, int width, Color color, String name) {
    super(center, height, width, color, name);
    this.desc = "Rectangle";
  }

<<<<<<< HEAD
=======

>>>>>>> 5d896be15ca16b7e9caeb413827e0f182beeea17
}
