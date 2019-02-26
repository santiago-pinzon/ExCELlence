package cs3500.model;

public abstract class AbstractAnimation implements Animation{
  Shapes shape;
  int startTime;
  int endTime;



  public AbstractAnimation(Shapes shape, int startTime, int endTime){
    if (endTime <= startTime){
      throw new IllegalArgumentException("end time cannot be less than or the same as the start time");
    }
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
  }



@Override
  public String getDescription() {
    String output = "motion\t" + this.shape.getName() + "\t" + this.startTime + "\t" + this.shape.getDescription();
    this.doAction();
    output += "\t\t" + this.endTime + "\t"+ this.shape.getDescription();
    return output;
  }



@Override
  public void doAction() {
  }

  public void renderAnimation(){
    // don't know how to render the animation yet
  }
}
