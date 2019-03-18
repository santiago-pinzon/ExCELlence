package cs3500.animator.view;

import cs3500.model.Shapes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import javax.swing.JPanel;


public class AnimationPanel extends JPanel {
  LinkedHashMap<String, Shapes> listOfShapes = new LinkedHashMap();

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    setLocation(0, 0);
    setSize(1000, 1000);

    for (Shapes shape : this.listOfShapes.values()) {
      //System.out.println(shape.getName());
      switch (shape.getDesc()) {
        case "Rectangle":
          g2.setColor(shape.getActualColor());
          g2.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
          break;
        case "Ellipse":
          g2.setColor(shape.getActualColor());
          g2.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
          break;

        default:
          throw new IllegalArgumentException("Shape does not exist: " + shape.getDesc());
      }

    }
  }

  public void addShapes(LinkedHashMap<String, Shapes> in) {
    this.listOfShapes = (LinkedHashMap) in.clone();
  }

}




