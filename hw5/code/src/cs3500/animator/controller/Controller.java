package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Conroller class that allows the user to do what they want to the animation.
 */
public class Controller implements IController, ActionListener {

  public EditorView view;
  AnimationModelImpl model;

  /**
   * Constructs a controller with an EditorView and an AnimationModelImpl.
   *
   * @param view the view being controlled by the user
   * @param model the model being changed when the user has control
   */
  public Controller(EditorView view, AnimationModelImpl model) {
    this.view = view;
    this.model = model;
    this.view.addActionListener(this);
    this.view.setVisible();
  }

  @Override
  public void updateView() {
    this.view.setModel(new ROAnimationModel(model));
  }

  @Override
  public void addShape(Shapes shape) {
    this.model.addShape(shape);
  }


  @Override
  public void removeShape(String shape) {
    this.model.removeShape(shape);
  }


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
        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        }
        this.view.restart();
        this.updateView();
        this.view.animate();

        break;
      }
      case "add": {
        String type = this.view.getShapeType();
        if (type.equals("KeyFrame")) {
          String name = this.view.getShapeName(this);
          int key = this.view.getKeyFrameNumber(name);
          KeyFrame frame = this.view.getKeyFrame();
          this.model.addKeyFrame(name, key, frame);
        } else {
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
          this.model.addKeyFrame(name, initial.getKey() + 1, new KeyFrame(initial.getKey() + 1,
              initial.getX(), initial.getY(), initial.getH(), initial.getW(), initial.getR(),
              initial.getG(), initial.getB()));
          for (KeyFrame k : frames) {
            this.model.addKeyFrame(name, k.getKey(), k);
          }
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
        KeyFrame frame = this.view.getKeyFrame();
        this.model.editKeyFrame(name, frame.getKey(), frame);
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
