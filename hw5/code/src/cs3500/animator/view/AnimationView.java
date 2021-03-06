package cs3500.animator.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.model.AnimationModelImpl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 * This is an implementation of the IAnimationView interface that uses Java Swing to draw the
 * animation in a window. We use an extended JPanel placed inside of a ScrollPane to draw the
 * animation. Every tick the panel refreshes and updates the animation.
 */
public class AnimationView implements IAnimationView {

  private AnimationPanel animationPanel;
  private AnimationModelImpl animation;
  private int tick; // keeps track of the current frame.
  private int speed;
  private JFrame frame;

  /**
   * An AnimationView object represents an instance of a visual view for an animation. Each
   * animation starts at tick 1, and loops every {@code speed} ms. Every time the loop occurs, the
   * model refreshes all its shapes to the next tick.
   *
   * @param animation the model to be drawn.
   * @param speed     the amount of time in between each tick in ms.
   */
  public AnimationView(AnimationModelImpl animation, int speed) {
    this.frame = new JFrame();
    this.tick = 1;
    this.speed = speed;

    this.animation = animation;

    frame.setTitle("ExceLlence");
    frame.setPreferredSize(new Dimension(animation.getWidth(), animation.getHeight()));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLayout(new BorderLayout());
    animationPanel = new AnimationPanel();
    animationPanel.setOffset(animation.getX(), animation.getY());
    JScrollPane scrollPane = new JScrollPane(animationPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setPreferredSize(new Dimension(animation.getWidth(), animation.getHeight()));
    scrollPane.setEnabled(true);
    frame.getContentPane().add(scrollPane);

    frame.pack();
    this.refresh();


  }

  /**
   * Sets the animation to be visible.
   */
  void makeVisible() {
    this.frame.setVisible(true);
  }

  /**
   * This method represents the "loop" of the animation. It utilizes a timer, which is set to loop
   * every {@code speed} ms, and updates the shapes as necessary.
   */
  public void animate() {
    Timer timer = new Timer(this.speed, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        AnimationView.this.animation.updateShapes(tick);
        AnimationView.this.animationPanel.addShapes(
                AnimationView.this.animation.getHash());
        AnimationView.this.refresh();
        tick++; // % by current time for looping animation
      }
    });
    this.makeVisible();
    timer.start();
  }


  @Override
  public void refresh() {
    this.frame.repaint();
  }


  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this.frame, error, "Error", JOptionPane.ERROR_MESSAGE);

  }

}
