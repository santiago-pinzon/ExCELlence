package cs3500.animator.Controller;

import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.EditorView;
import cs3500.animator.view.TextView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Color;
import cs3500.model.Ellipse;
import cs3500.model.KeyFrame;
import cs3500.model.Position;
import cs3500.model.ROAnimationModel;
import cs3500.model.Rectangle;
import cs3500.model.Shapes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements IController, ActionListener {

  public EditorView view;
  AnimationModelImpl model;

  public Controller(EditorView view, AnimationModelImpl model) {
    this.view = view;
    this.model = model;
    this.view.addActionListener(this);
    this.view.setVisible();
  }

  /**
   * Updates the Hash of shapes stored in the view to show any changes that have been made.
   */
  @Override
  public void updateView() {
    this.view.setModel(new ROAnimationModel(model));
  }

  /**
   * Adds a shape to the model.
   *
   * @param shape the shape to be added.
   */
  @Override
  public void addShape(Shapes shape) {
    this.model.addShape(shape);
  }

  /**
   * Removes a shape from the model.
   *
   * @param shape the shape to be removed.
   */
  @Override
  public void removeShape(String shape) {
    this.model.removeShape(shape);

  }

  @Override
  public void addKeyFrame(int key) {

  }

  @Override
  public void removeKeyFrame() {

  }

  /**
   * Invoked when an action occurs.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();

    switch (action) {
      case "save": {
        File f = this.view.saveFileGetter();
        try {
          Appendable out = new BufferedWriter(new FileWriter(f));
          TextView text = new TextView(this.model, this.model.getX(), this.model.getY(),
              this.model.getHeight(), this.model.getWidth(), out);
          text.render();
          ((BufferedWriter) out).close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        break;
      }
      case "load": {
        File f = this.view.getFile();
        AnimationBuilderImpl build = new AnimationBuilderImpl();
        FileReader read;
        try {
          read = new FileReader(f.getAbsolutePath());
          this.model = (AnimationModelImpl) AnimationReader.parseFile(read, build);
          System.out.println("created model with shapes :" + model.getHash().values().size());
        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        }
        this.view.restart();
        this.updateView();
        this.view.animate();

        break;
      }
      case "add": {
        System.out.println("add");
        String type = this.view.getShapeType();
        int number = this.view.getNumberOfKeyFrames();
        String name = this.view.getShapeNameToBeAdded();
        ArrayList<KeyFrame> frames = new ArrayList<>();
        for (int i = 0; i < number; i++) {
          frames.add(this.view.getKeyFrame());
        }
        KeyFrame initial = frames.get(0);
        if (type.equals("Rectangle")) {
          this.model.addShape(new Rectangle(new Position(initial.getX(), initial.getY()),
              initial.getH(), initial.getW(),
              new Color(initial.getR(), initial.getG(), initial.getB()), name, true));
        } else {
          this.model.addShape(new Ellipse(new Position(initial.getX(), initial.getY()),
              initial.getH(), initial.getW(),
              new Color(initial.getR(), initial.getG(), initial.getB()), name, true));
        }
        for (KeyFrame k: frames) {
          this.model.addKeyFrame(name, k.getKey(), k);
        }
        this.updateView();
        break;
      }
      case "delete": {
        String name = this.view.getShapeName(this);
        this.model.removeShape(name);
        this.updateView();
        break;
      }
      case "edit": {
        String name = this.view.getShapeName(this);
        int key = this.view.getKeyFrameNumber(name);
        KeyFrame frame = this.view.getKeyFrame();
        this.model.editKeyFrame(name, key, frame);
        break;

      }
      case "slowdown": {
        this.view.slowDown();
        break;
      }
      case "reverse": {
        this.view.reverse();
        break;
      }
      case "play": {
        this.view.play();
        break;
      }
      case "forward": {
        this.view.forward();
        break;
      }
      case "speedup": {
        this.view.speedUp();
        break;
      }
      case "looping": {
        this.view.loop();
        break;
      }
      case "restart": {
        this.view.restart();
        break;
      }
      default: {
        break;
      }

    }
  }
}
