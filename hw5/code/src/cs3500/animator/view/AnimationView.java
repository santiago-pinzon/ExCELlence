package cs3500.animator.view;


import cs3500.model.AnimationModelImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This is an implementation of the IView interface that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a pop-up dialog box, and shows the turtle position and
 * heading
 */
public class AnimationView extends JFrame implements IView {

  private AnimationPanel animationPanel;
  private JScrollPane scrollPane;
  AnimationModelImpl animation;
  int tick; // keeps track of the current frame.
  int speed;

  public AnimationView(AnimationModelImpl animation, int height, int width, int speed) {
    super();

    this.tick = 1;
    this.speed = speed;

    this.animation = animation;

    this.setTitle("ExceLlence");
    this.setSize(width, height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    animationPanel = new AnimationPanel();
    animationPanel.setPreferredSize(new Dimension(500, 500));
    scrollPane = new JScrollPane(animationPanel);
    this.add(scrollPane, BorderLayout.CENTER);

    this.pack();

  }

  public void makeVisible() {
    this.setVisible(true);
  }

  public void addShapes() {
    this.animationPanel.addShapes(this.animation.getHash().values());
  }

  public void Animate() {
    Timer timer = new Timer(this.speed, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        AnimationView.this.animation.updateShapes(tick);
        AnimationView.this.animationPanel.addShapes(
            AnimationView.this.animation.getHash().values());
        tick++; // % by current time for looping animation
      }
    });
    this.makeVisible();
    timer.start();
  }


  public void refresh() {
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);

  }

}
