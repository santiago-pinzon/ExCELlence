package cs3500.model;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The implementation of the animation model. An animationModelImpl effectively holds and manages
 * the list of shapes included in the animation. The animationModel is capable of adding and
 * removing shapes, as well as adding animations to shapes. The shapes are stored in a LinkedHashMap
 * with the shape's name as the key.
 */

public class AnimationModelImpl implements AnimationModel {

  private ArrayList<Shapes> shapes;
  private LinkedHashMap<String, Shapes> listOfShapes;
  private int height;
  private int width;
  private int x;
  private int y;

  /**
   * Constructs the animation model using a hashMap to take care of the list of shapes.
   */

  public AnimationModelImpl() {
    this.listOfShapes = new LinkedHashMap<>();
    this.shapes = new ArrayList<Shapes>();
  }


  /**
   * Generates a new AnimationModelImpl based on a pre-established list of shapes
   *
   * @param in the list of shapes to be used in the animation.
   */
  public AnimationModelImpl(LinkedHashMap<String, Shapes> in, int height, int width, int x, int y) {
    this.listOfShapes = in;
    this.height = height;
    this.width = width;
    this.x = x;
    this.y = y;
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
    for (Shapes s : this.listOfShapes.values()) {
      s.getTweener(tick);
    }
  }
@Override
  public void addShapesToArray(Shapes s){
    if (listOfShapes.containsKey(s.getName())){
      shapes.add(s);
    }
    else {
      throw new IllegalArgumentException("There already exists a shape with this name");
    }
  }

@Override
  public ArrayList<Shapes> getShapes() {
    ArrayList<Shapes> copies = new ArrayList<Shapes>();
    for (Shapes s : this.shapes) {
      copies.add(s);
    }
    return copies;

  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public void removeShape(String name) {
    this.listOfShapes.remove(name);
  }
}




