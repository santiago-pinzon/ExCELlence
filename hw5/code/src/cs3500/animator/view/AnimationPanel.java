package cs3500.animator.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import cs3500.model.Shapes;
import javax.swing.JPanel;


/**
 * This class represents the panel on which the animation will be drawn on. This extends the
 * functionality provided in the JPanel to include drawing the requested shapes.
 */
public class AnimationPanel extends JPanel {

  private LinkedHashMap<Integer,LinkedHashMap<String, Shapes>> listOfShapes = new LinkedHashMap();
  private int x = 0;
  private int y = 0;

  /**
   * This overrides the parent class's paintComponent method to include drawing all the rectangles
   * and ellipses included in the animation.
   *
   * @param g the graphics to be drawn
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    this.setBackground(Color.WHITE);
    Graphics2D g2 = (Graphics2D) g;
    setPreferredSize(new Dimension(1000, 1000));

    ArrayList<Integer> layers = new ArrayList<>(listOfShapes.keySet());
    Collections.sort(layers);

    for(Integer num : layers) {
      for (Shapes shape : this.listOfShapes.get(num).values()) {
        //if (shape.isVisible()) {
        switch (shape.getDesc()) {
          case "Rectangle":
            g2.setColor(shape.getActualColor());
            g2.fillRect(shape.getX() - this.x, shape.getY() - this.y, shape.getWidth(),
                shape.getHeight());
            break;
          case "Ellipse":
            g2.setColor(shape.getActualColor());
            g2.fillOval(shape.getX() - this.x, shape.getY() - this.y, shape.getWidth(),
                shape.getHeight());
            break;

          default:
            throw new IllegalArgumentException("Shape does not exist: " + shape.getDesc());
        }
      }
    }
    //}

  }

  /**
   * This method updates the Hash of shapes to be drawn to its current state. Rather than pass in
   * the model, a copy of the lists to be drawn is passed in.
   *
   * @param in the map of shapes to be added.
   */
  void addShapes(LinkedHashMap<Integer, LinkedHashMap<String, Shapes>> in) {
    this.listOfShapes = (LinkedHashMap) in.clone();
  }

  /**
   * Sets the amount to offset each animation by.
   *
   * @param x the offset in the x direction.
   * @param y the offset in the y direction.
   */
  void setOffset(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
