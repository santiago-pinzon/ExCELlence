package cs3500.animator.view;

import java.io.File;
import java.io.FileNotFoundException;

public class visualTest {

  public static void main(String[] args) throws FileNotFoundException {
    /*
    FileReader read = new FileReader(
        "C:\\Users\\pnzni\\Documents\\OOD\\ExCELlence\\hw5\\code\\test\\toh-12.txt");

    AnimationBuilder<AnimationModel> builder = new AnimationBuilderImpl();

    AnimationModelImpl model = (AnimationModelImpl) AnimationReader.parseFile(read, builder);

    AnimationView animate = new AnimationView(model, 10);

    animate.Animate();
    */
    File f = new File("smalldemo.txt");
    System.out.println(f.getAbsoluteFile());
  }

}
