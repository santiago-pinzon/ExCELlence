package cs3500.animator.view;

import cs3500.animator.model.KeyFrame;
import cs3500.animator.model.Shape;
import java.awt.Dimension;
import java.util.ConcurrentModificationException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;

/**
 * This is the class of the Control Panel, it is a panel that was used to hold all the elements
 * necessary for user interaction with the program.
 */
public class ControlPanel extends JPanel {

  // below buttons are used for the animation displaying functions.
  JButton start;
  JButton restart;
  JButton autoPlayOn;
  JButton pause;
  JButton speedUp;
  JButton speedDown;
  JButton add;
  JButton delete;

  // below labels and text fields were used when the user try to edit the shape or the motion
  JLabel shapeInfo;
  JLabel keyframeInfo;
  JLabel askShapeName;
  JTextField editShapeName;
  JTextField editShapeName1;
  JLabel askType;
  JTextField editType;
  JLabel askTick;
  JTextField editTick;
  JLabel askR;
  JTextField editR;
  JLabel askG;
  JTextField editG;
  JLabel askB;
  JTextField editB;
  JLabel askX;
  JTextField editX;
  JLabel askY;
  JTextField editY;
  JLabel askWidth;
  JTextField editWidth;
  JLabel askHeight;
  JTextField editHeight;


  // below are two JList with their list model to display the current shapes and keyframes to user
  JList shapeList;
  DefaultListModel shapeNames;
  JScrollPane shapeMenuPane;
  JList keyFrameList;
  DefaultListModel keyFrameNames;
  JScrollPane keyFrameMenuPane;
  Animation2DPanel animationPanel;


  // the user inputs that was stored and will be passed into the controller
  String userShapeName1;
  int userTick;
  int userR;
  int userG;
  int userB;
  int userWidth;
  int userHeight;
  int userX;
  int userY;


  ControlPanel(Animation2DPanel aniPanel) {

    this.setPreferredSize(new Dimension(400, 800));
    this.animationPanel = aniPanel;

    start = new JButton("Start");
    start.setActionCommand("start");
    this.add(start);

    pause = new JButton("Pause");

    pause.setActionCommand("pause");
    this.add(pause);

    restart = new JButton("Restart");

    restart.setActionCommand("restart");
    this.add(restart);

    autoPlayOn = new JButton("AutoPlay : Off");

    autoPlayOn.setActionCommand("autoplay");
    this.add(autoPlayOn);

    speedUp = new JButton("Speed +");

    speedUp.setActionCommand("speedup");
    this.add(speedUp);

    speedDown = new JButton("Speed -");

    speedDown.setActionCommand("speeddown");
    this.add(speedDown);

    shapeInfo = new JLabel("Enter a Shape here -> ");

    this.add(shapeInfo);

    askShapeName = new JLabel("Shape name : ");

    this.add(askShapeName);

    editShapeName = new JTextField(6);
    this.add(editShapeName);

    askType = new JLabel("Shape type : ");

    this.add(askType);

    editType = new JTextField(6);
    this.add(editType);

    shapeList = new JList();

    shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    shapeMenuPane = new JScrollPane(shapeList);
    shapeMenuPane.setPreferredSize(new Dimension(400, 100));
    this.updateShapes();
    this.add(shapeMenuPane);

    keyframeInfo = new JLabel("Enter a keyframe here -> ");

    this.add(keyframeInfo);

    JLabel askShapeName1 = new JLabel("Shape name : ");

    this.add(askShapeName1);

    editShapeName1 = new JTextField(10);
    this.add(editShapeName1);

    askTick = new JLabel("Tick : ");
    this.add(askTick);

    editTick = new JTextField(3);
    this.add(editTick);

    askR = new JLabel("R : ");
    this.add(askR);

    editR = new JTextField(3);
    this.add(editR);

    askG = new JLabel("G : ");
    this.add(askG);

    editG = new JTextField(3);
    this.add(editG);

    askB = new JLabel("B : ");
    this.add(askB);

    editB = new JTextField(3);
    this.add(editB);

    askX = new JLabel("X : ");
    this.add(askX);

    editX = new JTextField(3);
    this.add(editX);

    askY = new JLabel("Y : ");
    this.add(askY);

    editY = new JTextField(3);
    this.add(editY);

    askWidth = new JLabel("Width : ");
    this.add(askWidth);

    editWidth = new JTextField(3);
    this.add(editWidth);

    askHeight = new JLabel("Height : ");
    this.add(askHeight);

    editHeight = new JTextField(3);
    this.add(editHeight);

    keyFrameList = new JList();

    keyFrameMenuPane = new JScrollPane(keyFrameList);
    keyFrameMenuPane.setPreferredSize(new Dimension(400, 200));

    this.add(keyFrameMenuPane);

    add = new JButton("Add");
    add.setActionCommand("add");
    this.add(add);

    delete = new JButton("Delete");
    delete.setActionCommand("delete");
    this.add(delete);


  }


  void start() {
    if (animationPanel.curTick >= animationPanel.model.getMotion()
        .get(animationPanel.model.getMotion().size() - 1).getTickEnd()) {
      animationPanel.curTick = 0;
      animationPanel.timer.start();
    } else {
      animationPanel.timer.start();
    }

  }

  void pause() {
    animationPanel.timer.stop();
  }

  void restart() {
    animationPanel.curTick = 0;
    animationPanel.timer.restart();
    animationPanel.timer.start();


  }

  void autoPlayOn() {
    if (!animationPanel.isAuto) {
      animationPanel.isAuto = true;
      this.autoPlayOn.setText("AutoPlay : On");
    } else {
      animationPanel.isAuto = false;
      this.autoPlayOn.setText(("AutoPlay : Off"));
    }

  }

  void speedUp() {
    animationPanel.speed += 2;
    animationPanel.initTimer(animationPanel.speed);
  }


  void speedDown() {
    if (animationPanel.speed > 2) {
      animationPanel.speed -= 2;
      animationPanel.initTimer(animationPanel.speed);
    }

  }


  void updateKeyFrames() {
    keyFrameNames = new DefaultListModel<>();

    for (Shape s : animationPanel.model.getShape()) {
      if (s.getName().equals(shapeList.getSelectedValue())) {
        for (KeyFrame k : s.getKeyFrame()) {
          keyFrameNames.addElement(k.keyFrameView());

        }
      }

    }
    keyFrameList.setModel(keyFrameNames);


  }

  void updateShapes() {
    shapeNames = new DefaultListModel();
    for (Shape s : animationPanel.model.getShape()) {
      shapeNames.addElement(s.getName());
    }
    shapeList.setModel(shapeNames);
  }


  void delete() {
    try {
      if (!shapeList.isSelectionEmpty() && keyFrameList.isSelectionEmpty()) {
        animationPanel.model.deleteShape(shapeList.getSelectedValue().toString());

        JOptionPane.showMessageDialog(ControlPanel.this, "The shape was deleted.", "Message",
            JOptionPane.PLAIN_MESSAGE);

      } else {
        animationPanel.model.deleteKeyFrame(shapeList.getSelectedValue().toString(),
            keyFrameList.getSelectedValue().toString());
        this.updateKeyFrames();
        JOptionPane.showMessageDialog(ControlPanel.this, "The keyframe was deleted.", "Message",
            JOptionPane.PLAIN_MESSAGE);
      }
    } catch (ConcurrentModificationException e) {
      if (!shapeList.isSelectionEmpty() && keyFrameList.isSelectionEmpty()) {
        this.updateShapes();
        JOptionPane.showMessageDialog(ControlPanel.this, "The shape was deleted.", "Message",
            JOptionPane.PLAIN_MESSAGE);

      } else {
        this.updateKeyFrames();
        JOptionPane.showMessageDialog(ControlPanel.this, "The keyframe was deleted.", "Message",
            JOptionPane.PLAIN_MESSAGE);
      }


    }


  }


  void add() {
    if (!editShapeName.getText().equals("") && !editType.getText().equals("")) {
      String userShapeName = editShapeName.getText();
      String userType = editType.getText();
      if (!shapeNames.contains(editShapeName.getText()) && !userShapeName.isEmpty() && !userType
          .isEmpty() && (userType.equals("ellipse") || userType.equals("rectangle"))) {
        animationPanel.model.addShape(userShapeName, userType);
        editShapeName.setText("");
        editType.setText("");
        JOptionPane.showMessageDialog(ControlPanel.this, "The Shape was added.", "Message",
            JOptionPane.PLAIN_MESSAGE);

      }

      this.updateShapes();
    } else {

      userShapeName1 = shapeList.getSelectedValue().toString();
      if (!shapeNames.contains(editShapeName1.getText())) {
        JOptionPane.showMessageDialog(ControlPanel.this, "The Shape should be exist !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editShapeName1.setText("");
        userShapeName1 = null;
      } else {
        editShapeName1.setText("");
      }

      try {

        userTick = Integer.parseInt(editTick.getText());
        if (userTick < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid tick input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editTick.setText("");
          userTick = -1;
        } else {
          editTick.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid tick input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editTick.setText("");
        userTick = -1;

      }

      try {

        userR = Integer.parseInt(editR.getText());
        if (userR > 255 || userR < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid RGB.red input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editR.setText("");
          userR = -1;
        } else {
          editR.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid RGB.red input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editR.setText("");
        userR = -1;
      }

      try {

        userG = Integer.parseInt(editG.getText());
        if (userG > 255 || userG < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid RGB.green input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editG.setText("");
          userG = -1;
        } else {
          editG.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid RGB.green input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editG.setText("");
        userG = -1;
      }

      try {

        userB = Integer.parseInt(editB.getText());
        if (userB > 255 || userB < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid RGB.blue input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editB.setText("");
          userB = -1;
        } else {
          editB.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid RGB.blue input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editB.setText("");
        userB = -1;
      }

      try {

        userX = Integer.parseInt(editX.getText());
        if (userX < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid X input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editX.setText("");
          userX = -1;
        } else {
          editX.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid X input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editX.setText("");
        userX = -1;

      }

      try {

        userY = Integer.parseInt(editY.getText());
        if (userY < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid Y input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editY.setText("");
          userY = -1;
        } else {
          editY.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid Y input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editY.setText("");
        userY = -1;

      }

      try {

        userWidth = Integer.parseInt(editWidth.getText());
        if (userWidth < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid width input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editWidth.setText("");
          userWidth = -1;
        } else {
          editWidth.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid width input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editWidth.setText("");
        userWidth = -1;

      }

      try {

        userHeight = Integer.parseInt(editHeight.getText());
        if (userHeight < 0) {
          JOptionPane.showMessageDialog(ControlPanel.this, "Invalid height input !", "Message",
              JOptionPane.PLAIN_MESSAGE);
          editHeight.setText("");
          userHeight = -1;
        } else {
          editHeight.setText("");
        }


      } catch (Exception e) {
        JOptionPane.showMessageDialog(ControlPanel.this, "Invalid height input !", "Message",
            JOptionPane.PLAIN_MESSAGE);
        editHeight.setText("");
        userHeight = -1;

      }

      try {

        animationPanel.model
            .addKeyFrame(userShapeName1, userTick, userX, userY, userR, userG, userB,
                userWidth, userHeight);
        this.updateKeyFrames();


      } catch (Exception e) {
        // do nothing.
      }
    }


  }


}
