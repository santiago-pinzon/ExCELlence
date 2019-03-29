package cs3500.model;

public class KeyFrame {

  private int key;
  private int x;
  private int y;
  private int w;
  private int h;
  private int r;
  private int g;
  private int b;

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

  public KeyFrame(KeyFrame key, KeyFrame key2, double ratio) {
    this.key = key.getKey();
    this.x += (int) Math.round((key2.getX() - key.getX()) * ratio);
    this.y += (int) Math.round((key2.getY() - key.getY()) * ratio);
    this.w += (int) Math.round((key2.getW() - key.getW()) * ratio);
    this.h += (int) Math.round((key2.getH() - key.getH()) * ratio);
    this.r += (int) Math.round((key2.getR() - key.getR()) * ratio);
    this.g += (int) Math.round((key2.getG() - key.getG()) * ratio);
    this.b += (int) Math.round((key2.getB() - key.getB()) * ratio);


  }

  public String toString() {
    return String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", key, this.x, this.y, this.h,
        this.w, this.r, this.g, this.b);
  }

  public int getKey() {
    return key;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getH() {
    return h;
  }

  public int getW() {
    return w;
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
