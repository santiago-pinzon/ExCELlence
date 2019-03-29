package cs3500.model;

/**
 * Class to represent a Position.
 */

public class Position {
  int x;
  int y;

  /**
   * Constructs a position with a given x and y value.
   *
   * @param x the x coordinate
   * @param y the y coordinate
   */

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets the x value of the position.
   *
   * @return the x value
   */

  int getX() {
    return this.x;
  }

  /**
   * Gets the y value of the position.
   *
   * @return the y value
   */

  int getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return String.format("%-5s %-5s", this.x, this.y);
  }
}
