package cs3500.animator.Controller;

import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.EditorView;
import cs3500.model.AnimationModelImpl;
import cs3500.model.ROAnimationModel;
import cs3500.model.Shapes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
        System.out.println("save");
        break;
      }
      case "load": {
        System.out.println("load");
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
        break;
      }
      case "delete": {
        System.out.println("delete");

        break;
      }
      case "edit": {
        System.out.println("edit");
        String name = this.view.getShapeName(this);
        int key = this.view.getKeyFrameNumber(name);
        System.out.println(key);
        //KeyFrame frame = this.view.getKeyFrame();
        //this.model.editKeyFrame(name, key, frame);
        break;

      }
      case "slowdown": {
        System.out.println("slow down");
        this.view.slowDown();
        break;
      }
      case "reverse": {
        System.out.println("reverse");
        this.view.reverse();
        break;
      }
      case "play": {
        System.out.println("play");
        this.view.play();
        break;
      }
      case "forward": {
        System.out.println("forward");
        this.view.forward();
        break;
      }
      case "speedup": {
        System.out.println("speed up");
        this.view.speedUp();
        break;
      }
      case "looping": {
        System.out.println("looping");
        this.view.loop();
        break;
      }
      case "restart": {
        System.out.println("restart");
        this.view.restart();
        break;
      }
      default: {
        System.out.println("error");
        break;
      }

    }
  }
}
