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
public class AnimationView implements IView {

  private AnimationPanel animationPanel;
  private JScrollPane scrollPane;
  private AnimationModelImpl animation;
  private int tick; // keeps track of the current frame.
  private int speed;
  private JFrame frame;

  public AnimationView(AnimationModelImpl animation, int height, int width, int speed) {
    this.frame = new JFrame();

    this.tick = 1;
    this.speed = speed;

    this.animation = animation;

    frame.setTitle("ExceLlence");
    frame.setPreferredSize(new Dimension(width, height));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    frame.setLayout(new BorderLayout());
    animationPanel = new AnimationPanel();
    //animationPanel.setPreferredSize(new Dimension(width, height));
    scrollPane = new JScrollPane(animationPanel);

    frame.getContentPane().add(scrollPane);


    frame.pack();
    this.refresh();
    

  }

  public void makeVisible() {
    this.frame.setVisible(true);
  }

  public void Animate() {
    Timer timer = new Timer(this.speed, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        AnimationView.this.animation.updateShapes(tick);
        AnimationView.this.animationPanel.addShapes(
            AnimationView.this.animation.getHash());
        tick++; // % by current time for looping animation
      }
    });
    this.makeVisible();
    timer.start();
  }


  public void refresh() {
    this.frame.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this.frame, error, "Error", JOptionPane.ERROR_MESSAGE);

  }

}
