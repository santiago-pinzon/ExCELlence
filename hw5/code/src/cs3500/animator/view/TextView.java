package cs3500.animator.view;

import java.io.IOException;

import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.model.AnimationModelImpl;

/**
 * A TextView object represents one instance of a textual view of the animation. The textView is
 * capable of outputting to any appendable, be it the console or a .txt file.
 */
public class TextView implements ITextView {
  private AnimationModelImpl animation;
  private int x;
  private int y;
  private int width;
  private int height;
  private Appendable out;


  /**
   * Represents an instance of a text view. It prints out, shape by shape, the shape and its
   * animations.
   *
   * @param animation the model upon which the text view will be based.
   * @param x         the offset in the x direction.
   * @param y         the offset in the y direction.
   * @param height    the height of the canvas.
   * @param width     the width of the canvas.
   * @param out       the appendable to output to, cannot be null.
   */
  public TextView(AnimationModelImpl animation, int x, int y, int height, int width,
                  Appendable out) {
    this.animation = animation;
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
    this.out = out;

    if (out == null) {
      throw new IllegalArgumentException("Appendable cannot be null");
    }
  }


  /**
   * Generates the output for the textView. Appends the output to the desired appendable.
   *
   * @throws IllegalArgumentException if unable to append to the appendable.
   */
  @Override
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
  public void showErrorMessage(String error) throws IllegalArgumentException {
    try {
      out.append(error);
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to append to Appendable");
    }
  }


}
