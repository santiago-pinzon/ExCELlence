package cs3500.animator.view;

import cs3500.model.Shapes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import javax.swing.JPanel;


public class AnimationPanel extends JPanel {
  private LinkedHashMap<String, Shapes> listOfShapes = new LinkedHashMap();
  private int x = 0;
  private int y = 0;

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
     //g2.translate(0 - this.x, 0 - this.y);
    }

  }

  public void addShapes(LinkedHashMap<String, Shapes> in) {
    this.listOfShapes = (LinkedHashMap) in.clone();
  }

  public void setOffset(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
