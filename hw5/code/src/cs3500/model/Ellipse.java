package cs3500.model;

public class Ellipse extends AShape {


  public Ellipse(Position center, int height, int width, Color color, String name){
    super(center, height, width, color, name);
    this.desc = "Ellipse";
  }



  @Override
  public void getImage() {

  }
}
