package cs3500.animator.view;

import static java.lang.Integer.parseInt;

import cs3500.model.AnimationModel;
import cs3500.model.KeyFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class that represents the editor view where all of the editing takes place.
 */
public class EditorView extends JFrame implements IEditorView {

  private AnimationPanel panel;
  private AnimationModel model;
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
  private JButton tickButton;
  private JComboBox<String> combobox;


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

  /**
   * Constructs an EditorView.
   */
  public EditorView() {
    super();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.direction = 1;
    this.tick = 1;

    this.speed = 64;

    setTitle("Excellence");
    setSize(1000, 1000);

    JPanel mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    JPanel toolPanel = new JPanel();
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
    add.setToolTipText("Add a shape or key");
    add.setActionCommand("add");
    test.add(add);

    //delete
    delete = new JButton(new ImageIcon("delete.gif"));
    delete.setToolTipText("Delete");
    delete.setActionCommand("delete");
    test.add(delete);

    //edit
    edit = new JButton(new ImageIcon("edit.gif"));
    edit.setToolTipText("Edit a shape or keyframe");
    edit.setActionCommand("edit");
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

    //tick
    tickButton = new JButton("Ticks");
    tickButton.setToolTipText("Ticks");
    tickButton.setEnabled(false);
    test.add(tickButton);

    //EDITORTEST.setFloatable(false);
    test.setRollover(true);

    toolPanel.add(test);
    toolPanel.setMaximumSize(new Dimension(1000, 100));
    mainPanel.add(toolPanel);

    this.panel = new AnimationPanel();

    mainPanel.add(panel);


  }

  @Override
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
    JOptionPane pane = new JOptionPane(error);
    pane.setVisible(true);
  }


  /**
   * Runs the animation.
   */
  @Override
  public void animate() {
    timer = new Timer(this.speed, e -> {
      EditorView.this.model.updateShapes(tick);
      EditorView.this.panel.addShapes(
          EditorView.this.model.getHash());
      EditorView.this.refresh();

      if (this.looping) {
        tick = (tick + this.direction * this.pause) % this.length;
        if (this.tick == 1 && this.direction < 0) {
          this.tick = this.length;
        }
      } else {
        tick += (this.direction * this.pause);// % by current time for looping animation
      }

      if (this.tick < 1) {
        this.tick = 1;
      }
      if (this.tick > this.length) {
        this.tick = this.length;
      }
      updateCounter();
    });
    this.setVisible();
    timer.start();
  }


  /**
   * Updates the model stored in the view to be a readOnly copy of the model.
   * @param in the ROAnimationModel being set.
   */
  @Override
  public void setModel(AnimationModel in) {
    this.model = in;
    this.length = model.getLength();
  }


  @Override
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


  @Override
  public void slowDown() {
    if (this.speed > 1) {
      this.speed /= 2;
    }

    this.timer.setDelay(1000 / speed);
  }


  @Override
  public void speedUp() {
    if (this.speed < 500) {
      this.speed *= 2;
    }

    this.timer.setDelay(1000 / this.speed);
  }


  @Override
  public void reverse() {
    this.direction = -1;
  }

  @Override
  public void forward() {
    this.direction = 1;
  }

  @Override
  public void play() {
    if (this.paused) {
      if (this.started = false) {
        this.animate();
        this.started = true;
      }
      this.play.setIcon(new ImageIcon("play.gif"));
      this.paused = false;
      this.pause = 0;
      if (this.started) {
        this.animate();
        this.started = true;
      }
    } else {
      this.play.setIcon(new ImageIcon("pause.gif"));
      this.paused = true;
      this.pause = 1;
    }
  }

  @Override
  public void restart() {
    this.tick = 1;
    this.updateCounter();
  }


  @Override
  public void loop() {
    this.looping = this.loop.isSelected();
  }

  @Override
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

  @Override
  public void updateCounter() {
    this.tickButton.setText("" + this.tick + "/" + this.length);
  }

  @Override
  public String getShapeName(ActionListener in) {
    Object[] possibilities = new Object[this.model.getShapes().size()];
    for (int i = 0; i < this.model.getShapes().size(); i++) {
      possibilities[i] = this.model.getShapes().get(i).getName();
    }

    String s = (String) JOptionPane.showInputDialog(
        this,
        "Please pick a shape",
        "Shape Picker",
        JOptionPane.PLAIN_MESSAGE,
        new ImageIcon(),
        possibilities,
        "");

    return s;

  }

  @Override
  public int getKeyFrameNumber(String name) {
    Object[] possibilities = new Object[this.model.getHash().get(name).getKeyPoints().size()];
    for (int i = 0; i < this.model.getHash().get(name).getKeyPoints().size(); i++) {
      possibilities[i] = this.model.getHash().get(name).getKeyPoints().get(i);
    }

    int s = (int) JOptionPane.showInputDialog(
        this,
        "Please pick a key frame",
        "Key Frame Picker",
        JOptionPane.PLAIN_MESSAGE,
        new ImageIcon(),
        possibilities,
        "");

    return s;

  }

  @Override
  public KeyFrame getKeyFrame() {
    KeyFrame key = new KeyFrame(0, 0, 0, 0, 0, 0, 0, 0);

    JTextField tField = new JTextField(5);
    JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);
    JTextField wField = new JTextField(5);
    JTextField hField = new JTextField(5);
    JSpinner rField = new JSpinner(new SpinnerNumberModel(128, 0, 255, 1));
    JSpinner gField = new JSpinner(new SpinnerNumberModel(128, 0, 255, 1));
    JSpinner bField = new JSpinner(new SpinnerNumberModel(128, 0, 255, 1));

    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("t:"));
    myPanel.add(tField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("x:"));
    myPanel.add(xField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("y:"));
    myPanel.add(yField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("w:"));
    myPanel.add(wField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("h:"));
    myPanel.add(hField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("r:"));
    myPanel.add(rField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("g:"));
    myPanel.add(gField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("g:"));
    myPanel.add(bField);

    int result = JOptionPane.showConfirmDialog(null, myPanel,
        "Please enter the desired values for the keyframe", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
      int t = parseInt(tField.getText());
      int x = parseInt(xField.getText());
      int y = parseInt(yField.getText());
      int w = parseInt(wField.getText());
      int h = parseInt(hField.getText());
      int r = (int) rField.getValue();
      int g = (int) gField.getValue();
      int b = (int) bField.getValue();

      key = new KeyFrame(t, x, y, h, w, r, g, b);
    }
    return key;
  }

  @Override
  public String getShapeType() {
    Object[] possibilities = {"Rectangle", "Ellipse", "KeyFrame"};

    String s = (String) JOptionPane.showInputDialog(
        this,
        "Please choose what type of shape to add",
        "Shape Adder",
        JOptionPane.PLAIN_MESSAGE,
        new ImageIcon(),
        possibilities,
        "");
    return s;
  }

  @Override
  public int getNumberOfKeyFrames() {
    Object[] possibilities = {2, 3, 4, 5};

    int s = (int) JOptionPane.showInputDialog(
        this,
        "Please pick how many Key Frames to add",
        "Number of Key Frames",
        JOptionPane.PLAIN_MESSAGE,
        new ImageIcon(),
        possibilities,
        "");
    return s;
  }

  @Override
  public String getShapeNameToBeAdded() {
    String name = "";

    JTextField nameField = new JTextField(10);
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("Name:"));
    myPanel.add(nameField);

    int result = JOptionPane.showConfirmDialog(null, myPanel,
        "Please enter the desired name for the new shape", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
      name = nameField.getText();
    }
    return name;
  }

  @Override
  public File saveFileGetter() {
    File f = new File("");
    final JFileChooser fchooser = new JFileChooser(".");
    int retvalue = fchooser.showSaveDialog(this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      f = fchooser.getSelectedFile();
    }
    return f;
  }
}
