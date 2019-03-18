package cs3500.animator.view;

import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.animator.util.AnimationReader;
import cs3500.model.AnimationModel;
import cs3500.model.AnimationModelImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class test {


  public static void main(String[] args) throws FileNotFoundException {
    FileReader read = new FileReader(
        "C:\\Users\\pnzni\\Documents\\OOD\\ExCELlence\\hw5\\code\\src\\smalldemo.txt");

    AnimationBuilder<AnimationModel> builder = new AnimationBuilderImpl();

    AnimationModelImpl model = (AnimationModelImpl) AnimationReader.parseFile(read, builder);

    AnimationView view = new AnimationView(model, 1000, 1000, 30);

    view.Animate();

  }
}
