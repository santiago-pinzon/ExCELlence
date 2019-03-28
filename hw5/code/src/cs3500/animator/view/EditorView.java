
package cs3500.animator.view;

import cs3500.model.ROAnimationModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditorView extends JFrame implements IEditorView {

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JPanel toolPanel;
  private AnimationPanel panel;
  private ROAnimationModel model;
  private JButton play;
  private JToggleButton loop;
  private JButton save;
  private JButton load;
  private JButton add;
  private JButton delete;
  private JButton edit;
  private JButton slowdown;
  private JButton reverse;
  private JButton forward;
  private JButton speedup;
  private JButton restart;



  private Timer timer;

  private int speed;
  private int tick;
  private int direction = 1;
  private int length;

  //state booleans
  private boolean paused = true;
  private boolean looping = false;
  private boolean started = false;
  private int pause = 1;


  public EditorView() {
    super();
    this.direction = 1;
    this.tick = 1;

    this.speed = 64;

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
    save = new JButton(new ImageIcon("save.gif"));
    save.setToolTipText("Save");
    save.setActionCommand("save");
    test.add(save);

    //load
    load = new JButton(new ImageIcon("open.gif"));
    load.setToolTipText("Load");
    load.setActionCommand("load");
    test.add(load);

    //add
    add = new JButton(new ImageIcon("add.gif"));
    add.setToolTipText("Add");
    add.setActionCommand("Add a shape or key");
    test.add(add);

    //delete
    delete = new JButton(new ImageIcon("delete.gif"));
    delete.setToolTipText("Delete");
    delete.setActionCommand("delete");
    test.add(delete);

    //edit
    edit = new JButton(new ImageIcon("edit.gif"));
    edit.setToolTipText("Edit a shape or keyframe");
    test.add(edit);

    //slowdown
    slowdown = new JButton(new ImageIcon("slowdown.gif"));
    slowdown.setToolTipText("Slow Down");
    slowdown.setActionCommand("slowdown");
    test.add(slowdown);

    //reverse
    reverse = new JButton(new ImageIcon("backward.gif"));
    reverse.setToolTipText("Reverse");
    reverse.setActionCommand("reverse");
    test.add(reverse);

    //play
    play = new JButton(new ImageIcon("pause.gif"));
    play.setToolTipText("Play");
    play.setActionCommand("play");
    test.add(play);

    //forward
    forward = new JButton(new ImageIcon("forward.gif"));
    forward.setToolTipText("Forward");
    forward.setActionCommand("forward");
    test.add(forward);

    //speedup
    speedup = new JButton(new ImageIcon("speedup.gif"));
    speedup.setToolTipText("Speed Up");
    speedup.setActionCommand("speedup");
    test.add(speedup);

    //looping
    loop = new JToggleButton(new ImageIcon("loop.gif"));
    loop.setToolTipText("Loop");
    loop.setActionCommand("looping");
    test.add(loop);

    //restart
    restart = new JButton(new ImageIcon("restart.gif"));
    loop.setToolTipText("Restart");
    restart.setActionCommand("restart");
    test.add(restart);

    //EDITORTEST.setFloatable(false);
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


  public void animate() {
    timer = new Timer(this.speed, e -> {
      EditorView.this.model.updateShapes(tick);
      EditorView.this.panel.addShapes(
          EditorView.this.model.getHash());
      EditorView.this.refresh();
      if(this.tick >= 0 && this.tick <= this.length) {
        if (this.looping) {
          tick = (tick + this.direction * this.pause) % this.length;
        } else {
          tick += (this.direction * this.pause);// % by current time for looping animation
        }
      }
      System.out.println(tick);
    });
    this.setVisible();
    timer.start();
  }

  public void setModel(ROAnimationModel in) {
    this.model = in;
    this.length = model.getLength();
    System.out.println("Updated model to have shapes: " + this.model.getHash().values().size());
  }

  public void addActionListener(ActionListener listen) {
    restart.addActionListener(listen);
    loop.addActionListener(listen);
    speedup.addActionListener(listen);
    forward.addActionListener(listen);
    play.addActionListener(listen);
    reverse.addActionListener(listen);
    slowdown.addActionListener(listen);
    delete.addActionListener(listen);
    edit.addActionListener(listen);
    add.addActionListener(listen);
    load.addActionListener(listen);
    save.addActionListener(listen);
  }

  public void slowDown() {
    if(this.speed > 1) {
      this.speed /= 2;
    }
    this.timer.setDelay(1000/speed);
  }

  public void speedUp() {
    if(this.speed < 500) {
      this.speed *= 2;
    }
    this.timer.setDelay (1000/this.speed);
  }

  public void reverse() {
    this.direction = -1;
  }

  public void forward() {
    this.direction = 1;
  }

  public void play() {
    if(this.paused) {
      this.play.setIcon(new ImageIcon("play.gif"));
      this.paused = false;
      this.pause = 0;
      if(this.started) {
        this.animate();
        this.started = true;
      }
    }
    else {
      this.play.setIcon(new ImageIcon("pause.gif"));
      this.paused = true;
      this.pause = 1;
    }
  }

  public void restart() {
    this.tick = 1;
  }

  public void loop() {
    this.looping = this.loop.isSelected();
  }

  public File getFile() {
    File f = null;
    final JFileChooser fchooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Animation files", "txt");
    fchooser.setFileFilter(filter);
    int retvalue = fchooser.showOpenDialog(EditorView.this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      f = fchooser.getSelectedFile();
    }
    return f;
  }

}

