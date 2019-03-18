package cs3500.model;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The implementation of the animation model.
 */

public class AnimationModelImpl implements AnimationModel {
  private List<Shapes > shapes;
  private HashMap<String, Shapes> listOfShapes;

  /**
   * Constructs the animation model using a hashMap to take care of the list of shapes.
   */

  public AnimationModelImpl() {
    this.listOfShapes = new HashMap<>();
  }

  @Override
  public void addShape(Shapes shape) throws IllegalArgumentException {
    if (this.listOfShapes.containsKey(shape.getName())) {
      throw new IllegalArgumentException("There already exists a shape with this name");
    }
    this.listOfShapes.put(shape.getName(), shape);
  }

  @Override
  public void addAnimation(String shape, Animation animate) throws IllegalArgumentException {
    if (!this.listOfShapes.containsKey(shape)) {
      throw new IllegalArgumentException("This shape does not exist");
    }
    this.listOfShapes.get(shape).addAction(animate);
  }

  public HashMap<String, Shapes> getHash() {
    return listOfShapes;
  }

  @Override
  public String getAnimation() {
    String output = "";
    for (String key : this.listOfShapes.keySet()) {
      output += this.listOfShapes.get(key).getFullDescription();
      output += "\n";
    }
    return output;
  }

  @Override
  public void updateShapes(int tick) {
    for(Shapes s: this.listOfShapes.values()) {
      s.getTweener(tick);
    }
  }



<<<<<<< HEAD
  public List<Shapes> getShapes(){
    ArrayList<Shapes> copys = new ArrayList<Shapes>();
    for (Shapes s: this.shapes){
      copys.add(s);
    }
    return copys;
  }


=======
>>>>>>> bbaaeefc2b4b02b2e66de6d0208cd54adea13f43
}



