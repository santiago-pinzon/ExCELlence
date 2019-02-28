package cs3500.model;

public interface AnimationModel {

  public void addShape(Shapes shape);

  public void addAnimation(String shape, Animation animate);

  String getAnimation();

}