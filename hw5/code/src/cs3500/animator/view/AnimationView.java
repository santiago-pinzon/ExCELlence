package cs3500.animator.view;

import cs3500.model.AnimationModelImpl;
import java.awt.*;

import java.util.function.Consumer;

import javax.swing.*;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a
 * pop-up dialog box, and shows the turtle position
 * and heading
 */
public class AnimationView extends JFrame implements IView {
  private JPanel animationPanel;
  private JScrollPane scrollPane;
  AnimationModelImpl animation;

  public AnimationView(AnimationModelImpl animation) {
    super();
    this.setTitle("ExceLlence");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    animationPanel = new JPanel();
    animationPanel.setPreferredSize(new Dimension(500, 500));
    scrollPane = new JScrollPane(animationPanel);
    this.add(scrollPane, BorderLayout.CENTER);

    this.pack();


  }

  public void makeVisible() {
    this.setVisible(true);
  }

  public void addShapes() {
    for(String e: animation.getHash().keySet()) {
      this.add(animation.getHash().get(e).getImage()));
    }
  }




  public void refresh() {
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);

  }

}
