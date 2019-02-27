package cs3500.model;

public class Color {
  int r;
  int g;
  int b;

  public Color(int r, int g, int b){
    if (r < 0 || r > 255){
      throw new IllegalArgumentException("Invalid color");
    }
    if (g < 0 || g > 255){
      throw new IllegalArgumentException("Invalid color");
    }
    if (b < 0 || b > 255){
      throw new IllegalArgumentException("Invalid color");
    }

    this.r = r;
    this.g = g;
    this.b = b;
  }

  @Override
  public String toString(){
    return String.format("%-1s %-1s %-1s", this.r, this.g, this.b);
  }
}
