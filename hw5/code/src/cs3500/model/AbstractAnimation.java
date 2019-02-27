package cs3500.model;

public abstract class AbstractAnimation implements Animation{

  protected int startTime;
  protected int endTime;



  public AbstractAnimation(int startTime, int endTime){
    if (endTime <= startTime){
      throw new IllegalArgumentException("end time cannot be less than or the same as the start time");
    }
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public void renderAnimation(){
    // don't know how to render the animation yet
  }

  @Override
  public int getStartTime() {
    return startTime;
  }


  @Override
  public int getEndTime() {
    return endTime;
  }

  public abstract void apply(Shapes shape);


}
