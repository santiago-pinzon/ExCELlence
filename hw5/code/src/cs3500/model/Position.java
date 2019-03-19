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
   * @throws IllegalArgumentException if the x value is < 0
   * @throws IllegalArgumentException if the y value if < 0
   */

  public Position(int x, int y) {
    /*if (x < 0) {
      throw new IllegalArgumentException("X cannot be negative");
    }
    if (y < 0) {
      throw new IllegalArgumentException("Y cannot be negative");
    }
    */
    this.x = x;
    this.y = y;
  }

  /**
   * Gets the x value of the position.
   *
   * @return the x value
   */

  public int getX() {
    return this.x;
  }

  /**
   * Gets the y value of the position.
   *
   * @return the y value
   */

  public int getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return String.format("%-5s %-5s", this.x, this.y);
  }
}
