package cs3500.animator.view;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.*;

import cs3500.model.AShape;
import cs3500.model.Shapes;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Animation;


public class SVGView implements ISVGView {

  private int speed;
  private ArrayList<Shapes> s;
  private Appendable a;
  private int width;
  private int height;
  private AnimationModelImpl m;


  public SVGView(int speed, ArrayList<Shapes> s, Appendable a, int width, int height, AnimationModelImpl m) {

    if (s == null || a == null) {
      throw new IllegalArgumentException("Cannot be null");
    }
    this.speed = speed;
    this.s = s;
    this.a = a;
    this.width = width;
    this.height = height;
    this.m = m;
  }



  @Override
  public void output() {
    this.appendHelp("<svg width=\"" + this.width + "\" height=\"" + this.height + "\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n\n");
    for (Shapes s : m.getShapes()) {
      this.appendHelp("<" + getSVGType(s) + " id=\"" + s.getName() + "\" "
          + getSVGDesc(s) +">\n\n");

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


  private String checkSVGCommands(int startX, int startY, int startW, int startH,
      int startR, int startG, int startB, int endX, int endY,
      int endW, int endH, int endR, int endG, int endB, Shapes shape,
      Animation an) {
    String result = "";

    if (startX != endX) {
      result += xCommand(shape, an, startX, endX);
    }
    if (startY != endY) {
      result += yCommand(shape, an, startY, endY);
    }
    if (startW != endW) {
      result += widthCommand(shape, an, startW, endW);
    }
    if (startH != endH) {
      result += heightCommand(shape, an, startH, endH);
    }
    if (startR != endR || startG != endG || startB != endB) {
      result += colorCommand(an, startR, endR, startG, endG, startB, endB);
    }

    return result;
  }

  private String xCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "\t<animate attributeType=\"xml\" begin=\"" +
        +an.getStartTime() * speed
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

  private String yCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "\t<animate attributeType=\"xml\" begin=\"" +
            +an.getStartTime() * speed
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

  private String widthCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "<animate attributeType=\"xml\" begin=\"" +
        +an.getStartTime() * speed
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

  private String heightCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "<animate attributeType=\"xml\" begin=\"" +
            +an.getStartTime() * speed
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

  private String colorCommand(Animation an, int startR, int endR,
      int startG, int endG, int startB, int endB) {

    String start = "<animate attributeName = \"fill\" "
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


  private void appendHelp(String s) throws IllegalArgumentException {
    try {
      a.append(s);
    } catch (IOException e) {
      throw new IllegalArgumentException("appendable not working");
    }
  }


  private String getSVGType(Shapes s) {
    if (s.getDesc().equals("Rectangle")) {
      return "rect";
    } else if (s.getDesc().equals("Ellipse")) {
      return "ellipse";
    } else {
      throw new IllegalArgumentException("Shape is not valid");
    }
  }

  private String getSVGDesc(Shapes s) {
    String result = "";
    if (s.getDesc().equals("Rectangle")) {
      result = "x=\"" + s.getX()
              + "\" y=\"" + s.getY()
              + "\" width=\"" + s.getWidth()
              + "\" height=\"" + s.getHeight()
              + "\" fill=\"rgb(" + s.getRed()
              + "," + s.getBlue()
              + "," + s.getGreen() + ")\""
              + " visibility=";

      if (s.isVisible()) {
        result = result +"\"visible\"";
      } else {
        result = result +"\"hidden\"";
      }


    } else if (s.getDesc().equals("Ellipse")) {
      result = "cx=\"" + s.getX()
              + "\" cy=\"" + s.getY()
              + "\" rx=\"" + s.getWidth()
              + "\" ry=\"" + s.getHeight()
              + "\" fill=\"rgb(" + s.getRed()
              + "," + s.getBlue()
              + "," + s.getGreen() + ")\""
              + " visibility=";

      if (s.isVisible()) {
        result = result +"\"visible\"";
      } else {
        result = result +"\"hidden\"";
      }

      return result;
    }
    return result;
  }


  /**
   * Transmit an error message to the view, in case the command could not be processed correctly
   */
  @Override
  public void showErrorMessage(String error) {
    return;
  }
}
