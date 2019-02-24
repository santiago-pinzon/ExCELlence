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

  @Override
  public String toString(){
    return  this.x + "\t" + this.y;
  }
}
