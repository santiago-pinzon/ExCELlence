package cs3500.model;

<<<<<<< HEAD
import java.util.Collection;
import java.util.HashMap;
=======
import java.util.LinkedHashMap;
>>>>>>> aa5bca907ae520425661636a43b016abd782625f
import java.util.List;
import java.util.ArrayList;

/**
 * The implementation of the animation model.
 */

public class AnimationModelImpl implements AnimationModel {
  private List<Shapes > shapes;
  private LinkedHashMap<String, Shapes> listOfShapes;

  /**
   * Constructs the animation model using a hashMap to take care of the list of shapes.
   */

  public AnimationModelImpl() {
    this.listOfShapes = new LinkedHashMap<>();
  }


  /**
   * Generates a new AnimationModelImpl based on a pre-established list of shapes
   * @param in the list of shapes to be used in the animation.
   */
  public AnimationModelImpl(LinkedHashMap<String, Shapes> in) {
    this.listOfShapes = in;
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

  public LinkedHashMap<String, Shapes> getHash() {
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
  public Collection<Shapes> getShapes(){
    return this.listOfShapes.values();
=======
  public List<Shapes> getShapes(){
    ArrayList<Shapes> copies = new ArrayList<Shapes>();
    for (Shapes s: this.shapes){
      copies.add(s);
    }
    return copies;
>>>>>>> aa5bca907ae520425661636a43b016abd782625f
  }

}



