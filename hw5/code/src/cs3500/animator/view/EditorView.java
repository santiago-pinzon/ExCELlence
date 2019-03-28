<<<<<<< HEAD
package cs3500.animator.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

public class EditorView extends JFrame implements IEditorView, ActionListener {

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JPanel toolPanel;


  public EditorView() {
    super();

    setTitle("Swing features");
    setSize(400, 400);

    mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    toolPanel = new JPanel();
    toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //toolbar
    JToolBar test = new JToolBar();

    //save
    JButton save = new JButton(new ImageIcon("save.gif"));
    save.setToolTipText("Save");
    save.setActionCommand("save");
    save.addActionListener(this);
    test.add(save);

    //load
    JButton load = new JButton(new ImageIcon("open.gif"));
    load.setToolTipText("Load");
    load.setActionCommand("load");
    load.addActionListener(this);
    test.add(load);

    //add
    JButton add = new JButton(new ImageIcon("add.gif"));
    add.setToolTipText("Add");
    add.setActionCommand("add");
    add.addActionListener(this);
    test.add(add);

    //delete
    JButton delete = new JButton(new ImageIcon("delete.gif"));
    delete.setToolTipText("Delete");
    delete.setActionCommand("delete");
    delete.addActionListener(this);
    test.add(delete);

    //slowdown
    JButton slowdown = new JButton(new ImageIcon("slowdown.gif"));
    slowdown.setToolTipText("Slow Down");
    slowdown.setActionCommand("slowdown");
    slowdown.addActionListener(this);
    test.add(slowdown);

    //reverse
    JButton reverse = new JButton(new ImageIcon("backward.gif"));
    reverse.setToolTipText("Reverse");
    reverse.setActionCommand("reverse");
    reverse.addActionListener(this);
    test.add(reverse);

    //play
    JButton play = new JButton(new ImageIcon("Play.gif"));
    play.setToolTipText("Play");
    play.setActionCommand("play");
    play.addActionListener(this);
    test.add(play);

    //forward
    JButton forward = new JButton(new ImageIcon("forward.gif"));
    forward.setToolTipText("Forward");
    forward.setActionCommand("forward");
    forward.addActionListener(this);
    test.add(forward);

    //speedup
    JButton speedup = new JButton(new ImageIcon("speedup.gif"));
    speedup.setToolTipText("Speed Up");
    speedup.setActionCommand("speedup");
    speedup.addActionListener(this);
    test.add(speedup);

    //loop
    JButton loop = new JButton(new ImageIcon("loop.gif"));
    loop.setToolTipText("Loop");
    loop.setActionCommand("loop");
    loop.addActionListener(this);
    test.add(loop);

    //restart
    JButton restart = new JButton(new ImageIcon("restart.gif"));
    loop.setToolTipText("Restart");
    restart.setActionCommand("restart");
    restart.addActionListener(this);
    test.add(restart);

    test.setFloatable(false);
    test.setRollover(true);

    toolPanel.add(test);
    toolPanel.setMaximumSize(new Dimension(1000,100));
    this.mainPanel.add(toolPanel);

    AnimationPanel panel = new AnimationPanel();

    this.mainPanel.add(panel);


  }

  public void setVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {

  }

  /**
   * Transmit an error message to the view, in case the command could not be processed correctly.
   *
   * @param error the message to be displayed
   */
  @Override
  public void showErrorMessage(String error) {

  }

  /**
   * Invoked when an action occurs.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();

    switch(action) {
      case "save": {
        System.out.println("save");
        break;
      }
      case "load": {
        System.out.println("load");
        break;
      }
      case "add": {
        System.out.println("add");
        break;
      }
      case "delete": {
        System.out.println("delete");
        break;
      }
      case "slowdown": {
        System.out.println("slow down");
        break;
      }
      case "reverse": {
        System.out.println("reverse");
        break;
      }
      case "play": {
        System.out.println("play");
        break;
      }
      case "forward": {
        System.out.println("forward");
        break;
      }
      case "speedup": {
        System.out.println("speed up");
        break;
      }
      case "loop": {
        System.out.println("loop");
        break;
      }
      case "restart": {
        System.out.println("restart");
        break;
      }
      default : {
        System.out.println("error");
        break;
      }

    }

  }
}
=======
package cs3500.animator.view;

import cs3500.model.AnimationModelImpl;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.Timer;

public class EditorView extends JFrame implements IEditorView, ActionListener {

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JPanel toolPanel;
  private AnimationPanel panel;
  private AnimationModelImpl model;
  private JButton play;
  private JToggleButton loop;
  private Timer timer;

  private int speed;
  private int tick;
  private int direction = 1;
  private int length;

  //state booleans
  private boolean paused = true;
  private boolean looping = false;


  public EditorView() {
    super();

    setTitle("Swing features");
    setSize(400, 400);

    mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    toolPanel = new JPanel();
    toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //toolbar
    JToolBar test = new JToolBar();

    //save
    JButton save = new JButton(new ImageIcon("save.gif"));
    save.setToolTipText("Save");
    save.setActionCommand("save");
    save.addActionListener(this);
    test.add(save);

    //load
    JButton load = new JButton(new ImageIcon("open.gif"));
    load.setToolTipText("Load");
    load.setActionCommand("load");
    load.addActionListener(this);
    test.add(load);

    //add
    JButton add = new JButton(new ImageIcon("add.gif"));
    add.setToolTipText("Add");
    add.setActionCommand("Add a shape or key");
    add.addActionListener(this);
    test.add(add);

    //delete
    JButton delete = new JButton(new ImageIcon("delete.gif"));
    delete.setToolTipText("Delete");
    delete.setActionCommand("delete");
    delete.addActionListener(this);
    test.add(delete);

    //edit
    JButton edit = new JButton(new ImageIcon("edit.gif"));
    edit.setToolTipText("Edit a shape or keyframe");

    //slowdown
    JButton slowdown = new JButton(new ImageIcon("slowdown.gif"));
    slowdown.setToolTipText("Slow Down");
    slowdown.setActionCommand("slowdown");
    slowdown.addActionListener(this);
    test.add(slowdown);

    //reverse
    JButton reverse = new JButton(new ImageIcon("backward.gif"));
    reverse.setToolTipText("Reverse");
    reverse.setActionCommand("reverse");
    reverse.addActionListener(this);
    test.add(reverse);

    //play
    play = new JButton(new ImageIcon("pause.gif"));
    play.setToolTipText("Play");
    play.setActionCommand("play");
    play.addActionListener(this);
    test.add(play);

    //forward
    JButton forward = new JButton(new ImageIcon("forward.gif"));
    forward.setToolTipText("Forward");
    forward.setActionCommand("forward");
    forward.addActionListener(this);
    test.add(forward);

    //speedup
    JButton speedup = new JButton(new ImageIcon("speedup.gif"));
    speedup.setToolTipText("Speed Up");
    speedup.setActionCommand("speedup");
    speedup.addActionListener(this);
    test.add(speedup);

    //looping
    loop = new JToggleButton(new ImageIcon("loop.gif"));
    loop.setToolTipText("Loop");
    loop.setActionCommand("looping");
    loop.addActionListener(this);
    test.add(loop);

    //restart
    JButton restart = new JButton(new ImageIcon("restart.gif"));
    loop.setToolTipText("Restart");
    restart.setActionCommand("restart");
    restart.addActionListener(this);
    test.add(restart);

    //test.setFloatable(false);
    test.setRollover(true);

    toolPanel.add(test);
    toolPanel.setMaximumSize(new Dimension(1000,100));
    this.mainPanel.add(toolPanel);

    this.panel = new AnimationPanel();

    this.mainPanel.add(panel);


  }

  public void setVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  /**
   * Transmit an error message to the view, in case the command could not be processed correctly.
   *
   * @param error the message to be displayed
   */
  @Override
  public void showErrorMessage(String error) {

  }

  /**
   * Invoked when an action occurs.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();

    switch(action) {
      case "save": {
        System.out.println("save");
        break;
      }
      case "load": {
        System.out.println("load");
        break;
      }
      case "add": {
        System.out.println("add");
        break;
      }
      case "delete": {
        System.out.println("delete");
        break;
      }
      case "slowdown": {
        System.out.println("slow down");
        this.speed /= 2;
        this.timer.setDelay(1000/speed);
        break;
      }
      case "reverse": {
        System.out.println("reverse");
        this.direction = -1;
        break;
      }
      case "play": {
        System.out.println("play");
        if(this.paused) {
          this.play.setIcon(new ImageIcon("play.gif"));
          this.paused = false;
          this.timer.start();
        }
        else {
          this.play.setIcon(new ImageIcon("pause.gif"));
          this.paused = true;
          this.timer.stop();
        }
        break;
      }
      case "forward": {
        System.out.println("forward");
        this.direction = 1;
        break;
      }
      case "speedup": {
        System.out.println("speed up");
        this.speed *= 2;
        this.timer.setDelay(1000/this.speed);
        break;
      }
      case "looping": {
        System.out.println("looping");
        this.looping = this.loop.isSelected();
        break;
      }
      case "restart": {
        System.out.println("restart");
        this.tick = 1;
        break;
      }
      default : {
        System.out.println("error");
        break;
      }

    }

  }

  public void animate() {
    timer = new Timer(this.speed, e -> {
      EditorView.this.model.updateShapes(tick);
      EditorView.this.panel.addShapes(
          EditorView.this.model.getHash());
      EditorView.this.refresh();
      if(this.looping) {
        tick = (tick + this.direction) % this.length;
      }
      else {
        tick += this.direction;// % by current time for looping animation
      }
    });
    this.setVisible();
    timer.start();
  }

  public void setModel(AnimationModelImpl in) {
    this.model = in;
  }
}
>>>>>>> 8767b4cd8a89ceff3fc8d2fb8c2c67c90c1dcbb6
