package cs3500.animator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.StringReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.model.AnimationModelImpl;
import cs3500.animator.view.IView;
import cs3500.animator.view.TextView;
import cs3500.animator.view.SVGView;
import cs3500.animator.view.AnimationView;
import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationReader;


public class Excellence {

  public static void main(String[] args) throws IOException {

    Readable r = new StringReader(String.join(" ", args));

    AnimationModelImpl model = null;
    Scanner scan = new Scanner(r);
    String inputfile = "";
    String viewType = "";
    String output = "";
    int speed = -1;

    IView view = null;
    AnimationBuilder controller = null;

    Appendable a = null;

    while (scan.hasNext()) {
      String s = scan.next();

      switch (s) {
        case "-in":
          if (inputfile.equals("") && scan.hasNext()) {
            inputfile = scan.next();
          }
          break;
        case "-view":
          if (viewType.equals("") && scan.hasNext()) {
            viewType = scan.next();
          }
          break;
        case "-out":
          if (output.equals("") && scan.hasNext()) {
            output = scan.next();
          }
          break;
        case "-speed":
          if (speed == -1 && scan.hasNext()) {
            speed = Integer.parseInt(scan.next());
          }
          break;
        default:

          JFrame frame = new JFrame();
          frame.setSize(100, 100);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JOptionPane.showMessageDialog(frame, "Invalid input",
                  "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    if (speed == -1) {
      speed = 1;
    }
    if (output.equals("") || output.equals("out")) {
      output = "System.out";
    }

    switch (viewType) {
      case "text":
        IView t = new TextView(model, 10, 10, 1000, 1000, a);
        ((TextView) t).render();
        break;

      case "visual":

        IView v = new AnimationView(model, 1000, 1000, 1000);
        ((AnimationView) v).Animate();
        break;

      case "svg":

        IView s = new SVGView(1000, model.getShapes().get(speed), a, 1000, 1000, model);
        ((SVGView) s).output();
        break;


      default:
        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, "Invalid view type",
                "Error", JOptionPane.ERROR_MESSAGE);


    }
  }
}


