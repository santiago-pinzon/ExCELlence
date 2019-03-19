package cs3500.animator.view;

import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.animator.util.AnimationReader;
import cs3500.model.AnimationModel;
import cs3500.model.AnimationModelImpl;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class visualTest {

  public static void main(String[] args) throws FileNotFoundException {

    FileReader read = new FileReader(
        "C:\\Users\\pnzni\\Documents\\OOD\\ExCELlence\\hw5\\code\\test\\toh-12.txt");

    AnimationBuilder<AnimationModel> builder = new AnimationBuilderImpl();

    AnimationModelImpl model = (AnimationModelImpl) AnimationReader.parseFile(read, builder);

    AnimationView animate = new AnimationView(model, 10);

    animate.Animate();
  }

}
