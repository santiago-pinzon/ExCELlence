package cs3500.model;

/**
 * Class to represent critical points of motions, known as keyFrames.
 */
public class KeyFrame {

  private int key;
  private int x;
  private int y;
  private int w;
  private int h;
  private int r;
  private int g;
  private int b;

  /**
   * Constructs a keyFrame with a given key value, x value, y value, width, height, red value,
   * green value, blue value.
   * @param key represents a key value
   * @param x represents x value
   * @param y represents y value
   * @param h represents height
   * @param w represents width
   * @param r represents r value
   * @param g represents g value
   * @param b represents b value
   */
  public KeyFrame(int key, int x, int y, int h, int w, int r, int g, int b) {
    this.key = key;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Consstructs a keyFrame that takes two keyFrames and a ratio, it creates a tweener keyframe
   * that represents the intermediate state.
   * @param key first keyframe
   * @param key2 second keyframe
   * @param ratio distance between the two key frames
   */
  public KeyFrame(KeyFrame key, KeyFrame key2, double ratio) {
    this.key = key.getKey();
    this.x = key.getX() + (int) Math.round((key2.getX() - key.getX()) * ratio);
    this.y = key.getY() + (int) Math.round((key2.getY() - key.getY()) * ratio);
    this.w = key.getW() + (int) Math.round((key2.getW() - key.getW()) * ratio);
    this.h = key.getH() + (int) Math.round((key2.getH() - key.getH()) * ratio);
    this.r = key.getR() + (int) Math.round((key2.getR() - key.getR()) * ratio);
    this.g = key.getG() + (int) Math.round((key2.getG() - key.getG()) * ratio);
    this.b = key.getB() + (int) Math.round((key2.getB() - key.getB()) * ratio);


  }

  /**
   * Turns the keyframe into a string.
   * @return the key frame as a string in the correct format
   */
  public String toString() {
    return String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s", key, this.x, this.y, this.h,
        this.w, this.r, this.g, this.b);
  }

  /**
   * Gets the key value of the keyframe.
   * @return key value of the keyframe
   */
  public int getKey() {
    return key;
  }

  /**
   * Gets the x value of the keyframe.
   * @return x value of the keyframe
   */
  public int getX() {
    return x;
  }
  /**
   * Gets the y value of the keyframe.
   * @return y value of the keyframe
   */
  public int getY() {
    return y;
  }
  /**
   * Gets the height of the keyframe.
   * @return height of the keyframe
   */
  public int getH() {
    return h;
  }
  /**
   * Gets the width of the keyframe.
   * @return width of the keyframe
   */
  public int getW() {
    return w;
  }
  /**
   * Gets the red value of the keyframe.
   * @return red value of the keyframe
   */
  public int getR() {
    return r;
  }
  /**
   * Gets the green value of the keyframe.
   * @return green value of the keyframe
   */
  public int getG() {
    return g;
  }
  /**
   * Gets the blue value of the keyframe.
   * @return blue value of the keyframe
   */
  public int getB() {
    return b;
  }


}
