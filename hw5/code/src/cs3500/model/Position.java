package cs3500.model;

public class Position{
   int x;
   int y;

  public Position(int x, int y){
    if (x < 0){
      throw new IllegalArgumentException("X cannot be negative");
    }
    if (y < 0){
      throw new IllegalArgumentException("Y cannot be negative");
    }
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public String toString(){
    return  String.format("%-1s %-1s", this.x, this.y);
  }
}
