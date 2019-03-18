package cs3500.animator.view;

import cs3500.model.Shapes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel {
  ArrayList<Shapes> listOfShapes = new ArrayList<>();
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    setLocation(0,0);
    setSize(2000, 2000);

    for (Shapes shape : this.listOfShapes) {
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

  public void addShapes(Collection<Shapes> in) {
    this.listOfShapes.clear();
    this.listOfShapes.addAll(in);
  }

}

