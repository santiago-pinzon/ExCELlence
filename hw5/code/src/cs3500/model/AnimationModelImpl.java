package cs3500.model;


import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The implementation of the animation model. An animationModelImpl effectively holds and manages
 * the list of shapes included in the animation. The animationModel is capable of adding and
 * removing shapes, as well as adding animations to shapes. The shapes are stored in a LinkedHashMap
 * with the shape's name as the key.
 */

public class AnimationModelImpl implements AnimationModel {

  private ArrayList<Shapes> shapes;

  LinkedHashMap<Integer, LinkedHashMap<String, Shapes>> listOfShapes;
  LinkedHashMap<String, Integer> layers;

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
   * Generates a new AnimationModelImpl based on a pre-established list of shapes.
   *
   * @param in the list of shapes to be used in the animation.
   */
  public AnimationModelImpl(LinkedHashMap<Integer, LinkedHashMap<String, Shapes>> in, int height,
      int width, int x, int y, LinkedHashMap<String, Integer> layers) {
    this.listOfShapes = in;
    this.height = height;
    this.width = width;
    this.x = x;
    this.y = y;
    this.layers = layers;
  }

  @Override
  public void addShape(Shapes shape) throws IllegalArgumentException {
    if (this.listOfShapes.containsKey(shape.getName())) {
      throw new IllegalArgumentException("There already exists a shape with this name");
    }
    if (this.listOfShapes.get(0) == null) {
      this.listOfShapes.put(0, new LinkedHashMap<>());
    }
    this.layers.put(shape.getName(), 0);
    this.listOfShapes.get(0).put(shape.getName(), shape);
  }

  @Override
  public void addAnimation(String shape, Animation animate) throws IllegalArgumentException {
    if (!this.listOfShapes.containsKey(shape)) {
      throw new IllegalArgumentException("This shape does not exist");
    }
    Integer layer = this.layers.get(shape);
    this.listOfShapes.get(layer).get(shape).addAction(animate);
  }

  public LinkedHashMap<Integer, LinkedHashMap<String, Shapes>> getHash() {
    return listOfShapes;
  }

  @Override
  public int getLayer(String name) {
    return layers.get(name);
  }

  @Override
  public void addLayer(int layer) {
    if (this.listOfShapes.get(layer) != null) {
      this.listOfShapes.put(layer, new LinkedHashMap<>());
    }
  }


  @Override
  public void moveShape(String shape, int layer) {
    int num = layers.get(shape);
    Shapes temp = listOfShapes.get(num).get(shape);
    listOfShapes.get(num).remove(shape);
    if (listOfShapes.get(layer) == null) {
      listOfShapes.put(layer, new LinkedHashMap<>());
    }
    listOfShapes.get(layer).put(shape, temp);
    layers.put(shape, layer);
  }

  @Override
  public void removeLayer(int layer) {
    this.listOfShapes.remove(layer);
  }

  @Override
  public void reorder(ArrayList<Integer> swaps) {
    for (int i = 0; i < swaps.size() - 1; i += 2) {
      LinkedHashMap<String, Shapes> temp =
          this.listOfShapes.get(swaps.get(i));
      this.listOfShapes.put(swaps.get(0), this.listOfShapes.get(swaps.get(i + 1)));
      this.listOfShapes.put(swaps.get(i + 1), temp);
    }
  }

  @Override
  public String getAnimation() {
    String output = "";
    for (Integer num : this.listOfShapes.keySet()) {
      for (String key : this.listOfShapes.get(num).keySet()) {
        output += this.listOfShapes.get(num).get(key).getFullDescription();
        output += "\n";
      }
    }
    return output;
  }

  @Override
  public void updateShapes(int tick) {
    for (Integer num : this.listOfShapes.keySet()) {
      for (Shapes s : this.listOfShapes.get(num).values()) {
        s.getTweener(tick);
      }
    }
  }

  @Override
  public void addShapesToArray(Shapes s) {
    if (listOfShapes.containsKey(s.getName())) {
      shapes.add(s);
    } else {
      throw new IllegalArgumentException("There already exists a shape with this name");
    }
  }

  @Override
  public ArrayList<Shapes> getShapes() {
    ArrayList<Shapes> copies = new ArrayList<>();
    for (Integer num : this.listOfShapes.keySet()) {
      copies.addAll(this.listOfShapes.get(num).values());
    }
    return copies;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public void removeShape(String name) {
    this.listOfShapes.remove(name);
  }

  @Override
  public int getLength() {
    int max = 0;
    for (Integer num : this.listOfShapes.keySet()) {
      for (Shapes shape : this.listOfShapes.get(num).values()) {
        max = Math.max(max, shape.getEnd());
      }
    }
    return max;
  }

  @Override
  public void editKeyFrame(String name, int key, KeyFrame frame) {
    Integer layer = this.layers.get(name);
    this.listOfShapes.get(layer).get(name).removeKeyFrame(key);
    this.listOfShapes.get(layer).get(name).addKeyFrame(key, frame);
  }

  @Override
  public void addKeyFrame(String name, int key, KeyFrame frame) {
    Integer layer = this.layers.get(name);
    this.listOfShapes.get(layer).get(name).addKeyFrame(key, frame);
  }

  @Override
  public void removeKeyFrame(String name, int key) {
    Integer layer = this.layers.get(name);
    this.listOfShapes.get(layer).get(name).removeKeyFrame(key);
  }


}





