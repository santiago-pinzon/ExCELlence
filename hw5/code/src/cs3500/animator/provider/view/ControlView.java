package cs3500.animator.view;

import cs3500.animator.model.Animation2DModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

/**
 * The JFrame that was used for edit view of the animation, it holds two panels in it and apply the
 * layout and customization for it.
 */
public class ControlView extends JFrame implements IView {

  // the copy of the model
  Animation2DModel model;
  // the control panel
  ControlPanel controlPanel;
  // the animation panel
  Animation2DPanel animationPanel;


  /**
   * The constructor of the control view.
   *
   * @param model the model passed in
   */
  public ControlView(Animation2DModel model) {

    this.model = model;
    animationPanel = new Animation2DPanel(model, model.getWidth(), model.getHeight(),
        new Point(0, 0), 20);
    this.controlPanel = new ControlPanel(animationPanel);
    JScrollPane scroll = new JScrollPane(animationPanel);
    scroll.setPreferredSize(new Dimension(800, 800));
    this.setSize(new Dimension(1300, 900));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.add(scroll);
    this.add(controlPanel);
    this.setLayout(new FlowLayout());

  }


  @Override
  public void show(Animation2DModel model) {
    this.setVisible(true);
  }

  @Override
  public void start() {
    this.controlPanel.start();
  }

  @Override
  public void pause() {
    this.controlPanel.pause();
  }

  @Override
  public void restart() throws UnsupportedOperationException {
    this.controlPanel.restart();
  }

  @Override
  public void autoPlay() throws UnsupportedOperationException {
    this.controlPanel.autoPlayOn();
  }

  @Override
  public void speedUp() throws UnsupportedOperationException {
    this.controlPanel.speedUp();
  }

  @Override
  public void speedDown() throws UnsupportedOperationException {
    this.controlPanel.speedDown();
  }

  @Override
  public void setListeners(ActionListener c, ListSelectionListener l
  ) {

    this.controlPanel.start.addActionListener(c);
    this.controlPanel.pause.addActionListener(c);
    this.controlPanel.restart.addActionListener(c);
    this.controlPanel.autoPlayOn.addActionListener(c);
    this.controlPanel.speedUp.addActionListener(c);
    this.controlPanel.speedDown.addActionListener(c);
    this.controlPanel.delete.addActionListener(c);
    this.controlPanel.add.addActionListener(c);
    this.controlPanel.shapeList.addListSelectionListener(l);

  }

  @Override
  public void showKeyFrameSelected() throws UnsupportedOperationException {

    this.controlPanel.updateKeyFrames();
  }


  @Override
  public void delete() throws UnsupportedOperationException {

    this.controlPanel.delete();

  }

  @Override
  public void add() throws UnsupportedOperationException {
    this.controlPanel.add();
  }


}
