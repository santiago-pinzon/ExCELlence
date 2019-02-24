package cs3500.model;

public class Motion{
  Shapes shape;
  int startTime;
  int endTime;
  Position to;
  int newHeight;
  int newWidth;
  Color newColor;

  public Motion(Shapes shape, int startTime, int endTime, Position to, int newHeight,
                 int newWidth,  Color newColor){
    if (newHeight <= 0){
      throw new IllegalArgumentException("new height cannot be negative");
    }
    if (newWidth <= 0){
      throw new IllegalArgumentException("new width cannot be negative");
    }
    if (endTime <= startTime){
      throw new IllegalArgumentException("end time cannot be less than or the same as the start time");
    }
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.to = to;
    this.newHeight = newHeight;
    this.newWidth = newWidth;
    this.newColor = newColor;
  }




  public String getDescription() {
    String output = "motion\t" + this.shape.getName() + "\t" + this.startTime + "\t" + this.shape.getDescription();
    this.doAction();
    output += "\t\t" + this.endTime + "\t"+ this.shape.getDescription();
    return output;
  }




  public void doAction() {
    this.shape.changeColor(newColor);
    this.shape.changePosition(to);
    this.shape.changeSize(newHeight, newWidth);
  }

  public void renderAnimation(){
    // don't know how to render the animation yet
  }
}
