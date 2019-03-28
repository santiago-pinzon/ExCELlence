package cs3500.animator.view;

import cs3500.animator.Controller.Controller;
import cs3500.model.AnimationModelImpl;

public class EDITORTEST {

  public static void main(String[] args) {
    Controller controller = new Controller(new EditorView(), new AnimationModelImpl());


  }

}
