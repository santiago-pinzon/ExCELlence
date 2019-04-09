package cs3500.animator.provider.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Point;
import javax.swing.Timer;

/**
 * The panel of the animation which was taken by the JFrame which implements the view interface.
 */
public class Animation2DPanel extends JPanel {

  // the model to be represented in this panel
  Animation2DModel model;
  // the current tick of the animation
  int curTick;
  // the speed of the animation
  int speed;
  // the timer that handles the animation
  Timer timer;
  // a boolean indicating the auto loop function
  boolean isAuto;


  /**
   * The constructor of the Panel.
   *
   * @param model the model of the animation
   * @param width the width of the animation window
   * @param height the height of the animation window
   * @param corner the topLeft corner of the animation window
   * @param speed the speed of the animation
   */
  public Animation2DPanel(Animation2DModel model, int width, int height, Point corner, int speed) {
    super();
    this.setPreferredSize(new Dimension(width, height));
    this.model = model;
    this.setLocation(corner.x, corner.y);
    this.curTick = 0;
    this.speed = speed;
    this.timer = new Timer(200 / this.speed, (ActionEvent e) -> {
      this.autoPlay();
      this.curTick++;
      this.repaint();
    });


  }

  /**
   * A private helper that initalize the timer with given speed.
   *
   * @param speed the speed
   */
  void initTimer(int speed) {
    this.timer.setDelay(200 / speed);
  }


  @Override
  public void paint(Graphics g) {
    super.paintComponent(g);
    for (Shape shape : model.getShape()) {
      {
        // whether can draw with inter-polation
        if (shape.hasKeyFrame(curTick) && shape.hasNextKeyFrame(curTick)) {
          this.drawShape(shape, g);
        }
      }
    }

  }

  /**
   * A private helper to let the animation run with a loop.
   */
  public void autoPlay() {
    if (model.getShape().size() != 0) {
      if (curTick == model.getMotion().get(model.getMotion().size() - 1).getTickEnd() && isAuto) {
        this.curTick = 0;
        timer.restart();
        timer.start();
      }
    }


  }


  /**
   * Take a shape, calculate the properties on that tick and hand it to draw the shape components.
   *
   * @param shape the shape that takes
   * @param g the graphic component that currently drawing
   */
  public void drawShape(Shape shape, Graphics g) {

    KeyFrame thisKeyFrame = shape.findThisKeyFrame(curTick);
    KeyFrame nextKeyFrame = shape.findNextKeyFrame(curTick);
    int curR = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(),
        thisKeyFrame.getCol().getRed(), nextKeyFrame.getCol().getRed(),
        curTick);
    int curG = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(),
        thisKeyFrame.getCol().getGreen(), nextKeyFrame.getCol().getGreen(),
        curTick);
    int curB = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(),
        thisKeyFrame.getCol().getBlue(), nextKeyFrame.getCol().getBlue(),
        curTick);
    int curX = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(), thisKeyFrame.getPos().x,
        nextKeyFrame.getPos().x, curTick);
    int curY = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(), thisKeyFrame.getPos().y,
        nextKeyFrame.getPos().y, curTick);

    int curWidth = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(), thisKeyFrame.getWidth(),
        nextKeyFrame.getWidth(), curTick);
    int curHeight = lerp(thisKeyFrame.getTick(), nextKeyFrame.getTick(), thisKeyFrame.getHeight(),
        nextKeyFrame.getHeight(), curTick);

    Color curCol = new Color(curR, curG, curB);
    g.setColor(curCol);

    if (shape.getType().equals("Rectangle")) {
      g.fillRect(curX, curY, curWidth, curHeight);
    } else if (shape.getType().equals("Ellipse")) {
      g.fillOval(curX, curY, curWidth, curHeight);
    }


  }

  /**
   * The method that use inter-polation formula to calculate the value between two value at certain
   * tick.
   *
   * @param startTick the start tick
   * @param endTick the end tick
   * @param tick the tick
   * @param v1 the first value
   * @param v2 the second value
   * @return the value between value1 and value2 at the given tick
   */
  public int lerp(int startTick, int endTick, int v1, int v2, int tick) {
    if (v1 == v2) {
      return v1;
    } else {
      return (v1 * (endTick - tick) / (endTick - startTick))
          + (v2 * (tick - startTick) / (endTick - startTick));
    }
  }


}
