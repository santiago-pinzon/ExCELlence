package cs3500.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ROAnimationModel extends AnimationModelImpl {

  /**
   * Constructs a read-only animation model using a hashMap to take care of the list of shapes.
   * This model is only able to retrieve the list of shapes to be drawn, but is unable to change
   * anything.
   */
  public ROAnimationModel(AnimationModelImpl in) {
    this.listOfShapes = (LinkedHashMap) in.getHash().clone();
  }

  @Override
  public void addShape(Shapes shape) throws IllegalArgumentException {
    throw new UnsupportedOperationException("This method is not allowed");
  }

  @Override
  public void addAnimation(String shape, Animation animate) throws IllegalArgumentException {
    throw new UnsupportedOperationException("This method is not allowed");
  }


  @Override
  public String getAnimation() {
    throw new UnsupportedOperationException("This method is not allowed");
  }

  @Override
  public void addShapesToArray(Shapes s) {
    throw new UnsupportedOperationException("This method is not allowed");
  }

  @Override
  public void removeShape(String name) {
    throw new UnsupportedOperationException("This method is not allowed");
  }

  public void editKeyFrame(String name, int key, KeyFrame frame) {
    throw new UnsupportedOperationException("This method is not allowed");
  }

  public void addKeyFrame(String name, int key, KeyFrame frame) {
    throw new UnsupportedOperationException("This method is not allowed");
  }

  public void removeKeyFrame(String name, int key) {
    throw new UnsupportedOperationException("This method is not allowed");
  }
}
