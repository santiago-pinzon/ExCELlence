package cs3500.animator.view;

import cs3500.model.Shapes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import javax.swing.JPanel;


/**
 * This class represents the panel on which the animation will be drawn on. This extends the
 * functionality provided in the JPanel to include drawing the requested shapes.
 */
public class AnimationPanel extends JPanel {
  private LinkedHashMap<String, Shapes> listOfShapes = new LinkedHashMap();
  private int x = 0;
  private int y = 0;

  /**
   * This overrides the parent class's paintComponent method to include drawing all the
   * rectangles and ellipses included in the animation.
   * @param g the graphics to be drawn
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    this.setBackground(Color.WHITE);
    Graphics2D g2 = (Graphics2D) g;
    //setLocation(this.x,this.y);
    setPreferredSize(new Dimension(1000, 1000));


    for (Shapes shape : this.listOfShapes.values()) {
      System.out.println(shape.getName());
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

  /**
   * This method updates the Hash of shapes to be drawn to its current state. Rather than pass in
   * the model, a copy of the lists to be drawn is passed in.
   * @param in
   */
  public void addShapes(LinkedHashMap<String, Shapes> in) {
    this.listOfShapes = (LinkedHashMap) in.clone();
  }

  /**
   * Sets the amount to offset each animation by.
   * @param x the offset in the x direction.
   * @param y the offset in the y direction.
   */
  public void setOffset(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
