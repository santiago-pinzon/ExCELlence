package cs3500.model;

/**
 *
 */
public interface Shapes {
  /**
   * makes the shape shrink by the given amount
   * @param height the amount the shape will shrink by if negative amount, the shape will shrink, if positive amount the shape will grow
   */
  void changeSize(int height, int width);

  void changePosition(Position p);

  void changeColor(Color c);

  String getDescription();

  String getName();

  void getImage();

}
