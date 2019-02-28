package cs3500.model;

import java.util.HashMap;

public class AnimationModelImpl implements AnimationModel {
  HashMap<String, Shapes> listOfShapes;

  public AnimationModelImpl() {
    this.listOfShapes = new HashMap<>();
  }

  @Override
  public void addShape(Shapes shape) throws IllegalArgumentException{
    if(this.listOfShapes.containsKey(shape.getName())) {
      throw new IllegalArgumentException("There already exists a shape with this name");
    }
    this.listOfShapes.put(shape.getName(), shape);
  }

  @Override
  public void addAnimation(String shape, Animation animate) throws IllegalArgumentException{
    if(!this.listOfShapes.containsKey(shape)) {
      throw new IllegalArgumentException("This shape does not exist");
    }
    this.listOfShapes.get(shape).addAction(animate);
  }

  @Override
  public String getAnimation() {
    String output = "";
    for(String key: this.listOfShapes.keySet()) {
      output += this.listOfShapes.get(key).getFullDescription();
    }
    return output;
  }
}
