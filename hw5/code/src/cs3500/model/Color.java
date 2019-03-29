package cs3500.model;

/**
 * Class that represents colors.
 */

public class Color {

  private int r;
  private int g;
  private int b;

  /**
   * Constructs a Color by having values for r, g, b.
   *
   * @param r represents the value for red
   * @param g represents the value for green
   * @param b represents the value for blue
   * @throws IllegalArgumentException if r < 0 or r > 255 because that is an invalid number for a
   *        color
   * @throws IllegalArgumentException if g < 0 or g > 255 because that is an invalid number for a
   *        color
   * @throws IllegalArgumentException if b < 0 or b > 255 because that is an invalid number for a
   *        color
   */
  public Color(int r, int g, int b) {
    if (r < 0 || r > 255) {
      throw new IllegalArgumentException("Invalid color r = " + r);
    }
    if (g < 0 || g > 255) {
      throw new IllegalArgumentException("Invalid color g = " + g);
    }
    if (b < 0 || b > 255) {
      throw new IllegalArgumentException("Invalid color b = " + b);
    }

    this.r = r;
    this.g = g;
    this.b = b;
  }

  @Override
  public String toString() {
    return String.format("%-5s %-5s %-5s", this.r, this.g, this.b);
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }

}
