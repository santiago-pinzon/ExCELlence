package cs3500.animator.view;


import java.io.IOException;
import java.util.ArrayList;

import cs3500.model.Animation;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Shapes;


/**
 * This is an implementation of the SVGView interface that uses an XML-based format that can be used
 * to describe images and animations.
 */

public class SVGView implements ISVGView {

  private int speed;
  private Appendable a;
  private int width;
  private int height;
  private AnimationModelImpl m;

  /**
   * Constructs an SVGView.
   *
   * @param speed  The speed of the animation.
   * @param s      The List of Shapes in the animation.
   * @param a      The output of the SVGView
   * @param width  The width of the canvas size.
   * @param height The height of the canvas size.
   * @param m      The AnimationModelImpl of the Animation
   * @throws IllegalArgumentException if s is null or a is null
   */
  public SVGView(int speed, ArrayList<Shapes> s, Appendable a, int width,
                 int height, AnimationModelImpl m) {

    if (s == null || a == null) {
      throw new IllegalArgumentException("Cannot be null");
    }
    this.speed = speed;
    ArrayList<Shapes> s1 = s;
    this.a = a;
    this.width = width;
    this.height = height;
    this.m = m;
  }


  @Override
  public void output() {
    this.appendHelp("<svg width=\"" + this.width + "\" height=\"" + this.height + "\" "
            + "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n");
    for (Shapes s : m.getShapes()) {
      this.appendHelp("<" + getSVGType(s) + " id=\"" + s.getName() + "\" "
              + getSVGDesc(s) + ">\n\n");

      for (ArrayList<Animation> an : s.getAnimations()) {
        for (Animation ann : an) {

          String movements;

          int startX = s.getX();
          int startY = s.getY();
          int startW = s.getWidth();
          int startH = s.getHeight();
          int startR = s.getRed();
          int startG = s.getGreen();
          int startB = s.getBlue();
          boolean isVisibleStart = s.isVisible();

          ann.apply(s);

          int endX = s.getX();
          int endY = s.getY();
          int endW = s.getWidth();
          int endH = s.getHeight();
          int endR = s.getRed();
          int endG = s.getGreen();
          int endB = s.getBlue();
          boolean isVisibleEnd = s.isVisible();

          movements = checkSVGCommands(startX, startY, startW, startH, startR, startG, startB, endX,
                  endY,
                  endW, endH, endR, endG, endB, s, ann);

          this.appendHelp(movements);
        }
      }

      this.appendHelp("\n</" + getSVGType(s) + ">");
    }
    this.appendHelp("\n\n</svg>");


  }

  /**
   * Produces a String that checks the SVG Commands for all of its inputs.
   *
   * @param startX The starting X position.
   * @param startY The starting Y position.
   * @param startW The starting Width.
   * @param startH The starting height.
   * @param startR The starting Red value.
   * @param startG The starting Green value.
   * @param startB The starting Blue value.
   * @param endX   The ending X position.
   * @param endY   The ending Y position.
   * @param endW   The ending Width.
   * @param endH   The ending Height.
   * @param endR   The ending Red value.
   * @param endG   The ending Green value.
   * @param endB   The ending Blue value.
   * @param shape  The shape being described.
   * @param an     The animation being described.
   * @return String with all of the inputs in SVG format.
   */

  private String checkSVGCommands(int startX, int startY, int startW, int startH,
                                  int startR, int startG, int startB, int endX, int endY,
                                  int endW, int endH, int endR, int endG, int endB, Shapes shape,
                                  Animation an) {
    String result = "";

    if (startX != endX) {
      result += locationCommand(shape, an, startX, endX);
    }
    if (startY != endY) {
      result += locationCommandY(shape, an, startY, endY);
    }
    if (startW != endW) {
      result += sizeCommand(shape, an, startW, endW);
    }
    if (startH != endH) {
      result += sizeCommandH(shape, an, startH, endH);
    }
    if (startR != endR || startG != endG || startB != endB) {
      result += colorCommand(an, startR, endR, startG, endG, startB, endB);
    }

    return result;
  }

  /**
   * Produces a String turning the X Position into SVG format.
   *
   * @param shape    The shape being described.
   * @param an       The animation being described.
   * @param startval The starting X position.
   * @param endval   The ending X position.
   * @return String with the Xvalues in SVG format.
   */
  private String locationCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "\t<animate attributeType=\"xml\" begin=\""
            + an.getStartTime() * speed
            + "ms\" dur=\""
            + (an.getEndTime() - an.getStartTime()) * speed
            + "ms\" attributeName=\"";

    if (shape.getDesc().equals("Ellipse")) {
      start += "cx";

    } else {
      start += "x";
    }

    start += "\" from=\""
            + startval
            + "\" to=\"";
    start += endval
            + "\" fill=\"freeze\" />\n";

    return start;
  }

  /**
   * Produces a String turning the Y Position into SVG format.
   *
   * @param shape    The shape being described.
   * @param an       The animation being described.
   * @param startval The starting Y position.
   * @param endval   The ending Y position.
   * @return String with the Yvalues in SVG format.
   */

  private String locationCommandY(Shapes shape, Animation an, int startval, int endval) {

    String start = "\t<animate attributeType=\"xml\" begin=\""
            + an.getStartTime() * speed
            + "ms\" dur=\""
            + (an.getEndTime() - an.getStartTime()) * speed
            + "ms\" attributeName=\"";

    if (shape.getDesc().equals("Ellipse")) {
      start += "cy";

    } else {
      start += "y";
    }

    start += "\" from=\""
            + startval
            + "\" to=\"";
    start += endval
            + "\" fill=\"freeze\" />\n";

    return start;
  }

  /**
   * Produces a String turning the Width into SVG format.
   *
   * @param shape    The shape being described.
   * @param an       The animation being described.
   * @param startval The starting Width.
   * @param endval   The ending Width.
   * @return String with the Width in SVG format.
   */

  private String sizeCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "\t<animate attributeType=\"xml\" begin=\""
            + an.getStartTime() * speed
            + "ms\" dur=\""
            + (an.getEndTime() - an.getStartTime()) * speed
            + "ms\" attributeName=\"";

    if (shape.getDesc().equals("Ellipse")) {
      start += "rx";
    } else {
      start += "width";
    }

    start += "\" from=\""
            + startval
            + "\" to=\"";
    start += endval
            + "\" fill=\"freeze\" />\n";

    return start;
  }

  /**
   * Produces a String turning the Height into SVG format.
   *
   * @param shape    The shape being described.
   * @param an       The animation being described.
   * @param startval The starting Height.
   * @param endval   The ending Height.
   * @return String with the Height in SVG format.
   */

  private String sizeCommandH(Shapes shape, Animation an, int startval, int endval) {

    String start = "\t<animate attributeType=\"xml\" begin=\""
            + an.getStartTime() * speed
            + "ms\" dur=\""
            + (an.getEndTime() - an.getStartTime()) * speed
            + "ms\" attributeName=\"";

    if (shape.getDesc().equals("Ellipse")) {
      start += "ry";
    } else {
      start += "height";
    }

    start += "\" from=\""
            + startval
            + "\" to=\"";
    start += endval
            + "\" fill=\"freeze\" />\n";

    return start;
  }

  /**
   * Produces a String turning the Color into SVG format.
   *
   * @param an     The animation being described.
   * @param startR The starting Red value.
   * @param endR   The ending Red value.
   * @param startG The starting Green value.
   * @param endG   The ending Green value.
   * @param startB The starting Blue value.
   * @param endB   The ending Blue value.
   * @return String with the Color in SVG format.
   */

  private String colorCommand(Animation an, int startR, int endR,
                              int startG, int endG, int startB, int endB) {

    String start = "\t<animate attributeName = \"fill\" "
            + "attributeType=\"xml\" begin=\""
            + an.getStartTime() * speed
            + "ms\" dur=\""
            + (an.getEndTime() - an.getStartTime()) * speed
            + "ms\"";

    start += " from=\""
            + "rgb("
            + startR
            + ","
            + startG
            + ","
            + startB
            + ")\" to=\"";
    start += "rgb("
            + endR
            + ","
            + endG
            + ","
            + endB
            + ")\" fill=\"freeze\" />\n";

    return start;
  }

  /**
   * Helper method that appends the given String to the appendable.
   *
   * @param s String in SVG format
   * @throws IllegalArgumentException if the appendable can't append the String.
   */

  private void appendHelp(String s) throws IllegalArgumentException {
    try {
      a.append(s);
    } catch (IOException e) {
      throw new IllegalArgumentException("appendable not working");
    }
  }

  /**
   * Gets the Shape in SVG format.
   *
   * @param s The Shape being described.
   * @return a String of the shape in SVG format.
   */

  private String getSVGType(Shapes s) {
    if (s.getDesc().equals("Rectangle")) {
      return "rect";
    } else if (s.getDesc().equals("Ellipse")) {
      return "ellipse";
    } else {
      throw new IllegalArgumentException("Shape is not valid");
    }
  }

  /**
   * Gets the Description of the Shape in SVG format.
   *
   * @param s The Shape being described.
   * @return a String of the description of the shape in SVG format.
   */

  private String getSVGDesc(Shapes s) {
    String result = "";
    if (s.getDesc().equals("Rectangle")) {
      result = "x=\"" + s.getX()
              + "\" y=\"" + s.getY()
              + "\" width=\"" + s.getWidth()
              + "\" height=\"" + s.getHeight()
              + "\" fill=\"rgb(" + s.getRed()
              + "," + s.getGreen()
              + "," + s.getBlue() + ")\""
              + " visibility=";

      if (s.isVisible()) {
        result = result + "\"visible\"";
      } else {
        result = result + "\"hidden\"";
      }


    } else if (s.getDesc().equals("Ellipse")) {
      result = "cx=\"" + s.getX()
              + "\" cy=\"" + s.getY()
              + "\" rx=\"" + s.getWidth()
              + "\" ry=\"" + s.getHeight()
              + "\" fill=\"rgb(" + s.getRed()
              + "," + s.getGreen()
              + "," + s.getBlue() + ")\""
              + " visibility=";

      if (s.isVisible()) {
        result = result + "\"visible\"";
      } else {
        result = result + "\"hidden\"";
      }

      return result;
    }
    return result;
  }


  @Override
  public void showErrorMessage(String error) {
    this.appendHelp(error);
  }
}
