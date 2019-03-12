package cs3500.animator.view;

import cs3500.model.AnimationModelImpl;
import java.io.IOException;
import java.util.function.Consumer;

public class TextView implements IView {
  private AnimationModelImpl animation;
  private int x;
  private int y;
  private int width;
  private int height;

  Appendable out;


  public TextView(AnimationModelImpl animation, int x, int y, int height, int width,
      Appendable out) {
    this.animation = animation;
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
    this.out = out;

    if(out == null) {
      throw new IllegalArgumentException("Appendable cannot be null");
    }
  }

  public void render() throws IllegalArgumentException {
    try {
      out.append(String.format("canvas %-3s %-3s %-3s %-3s\n", this.x, this.y, this.height,
          this.width));
      for (String key : this.animation.getHash().keySet()) {
        out.append(this.animation.getHash().get(key).getFullDescription());
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to append to Appendable");
    }
  }



  /**
   * Transmit an error message to the view, in case the command could not be processed correctly
   */
  @Override
  public void showErrorMessage(String error) throws IllegalArgumentException{
    try {
      out.append(error);
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to append to Appendable");
    }
  }


}
