package cs3500.animator;

import cs3500.animator.view.SVGView;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
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
import cs3500.animator.view.AnimationView;
import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationReader;


/**
 * Excellence represents the main class of the animation program. Running the main function
 * requires that the proper command line arguments be supplied. The main program then parses said
 * arguments and initializes a model to match with the proper view and output. 
 */
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
    AnimationBuilder controller = new AnimationBuilderImpl();
    FileReader read;

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
          frame.setPreferredSize(new Dimension(100, 100));
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JOptionPane.showMessageDialog(frame, "Invalid input",
                  "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    if (speed == -1) {
      speed = 1;
    }
    if (output.equals("") || output.equals("out")) {
      a = System.out;
    }
    else {
      a = new BufferedWriter(new FileWriter(output));
    }

    if(!inputfile.equals("")) {
      read = new FileReader(inputfile);
      model = (AnimationModelImpl) AnimationReader.parseFile(read, controller);
    }


    switch (viewType) {
      case "text":
        IView t = new TextView(model, model.getX(), model.getY(), model.getHeight(), model.getWidth(), a);
        ((TextView) t).render();
        ((Closeable) a).close();
        break;

      case "visual":

        IView v = new AnimationView(model,speed);
        ((AnimationView) v).Animate();
        break;


      case "svg":

        IView s = new SVGView(speed, model.getShapes(), a , model.getWidth(), model.getHeight(), model);
        ((SVGView) s).output();
        ((Closeable) a).close();
        break;


      default:
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(100, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, "Invalid view type",
                "Error", JOptionPane.ERROR_MESSAGE);


    }
  }
}


