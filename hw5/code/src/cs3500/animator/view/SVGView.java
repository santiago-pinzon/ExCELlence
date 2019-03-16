package cs3500.animator.view;


import java.io.IOException;


import cs3500.model.AShape;
import cs3500.model.Shapes;
import cs3500.model.AnimationModelImpl;
import cs3500.model.Animation;


public class SVGView implements ISVGView  {
  private int speed;
  private Shapes s;
  private Appendable a;
  private int width;
  private int height;
  private AnimationModelImpl m;




  public SVGView(int speed, Shapes s, Appendable a, int width, int height, AnimationModelImpl m){

    if (s == null || a == null){
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

  }

  @Override
  public void showErrorMessage(String error) {
    this.appendHelp("<svg width=\"" + this.width + "\" height=\"" + this.height + "\" " +
            "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">");
    for (Shapes s : m.getShapes()) {
      this.appendHelp("<" + getSVGType(s) + " id=\"" + s.getName() + "\" "
              + getSVGDesc(s) + " >\n");

      for (Animation an : s.getAnimations()) {

        String movements;

        int startX = s.getX();
        int startY = s.getY();
        int startW = s.getWidth();
        int startH = s.getHeight();
        int startR = s.getRed();
        int startG = s.getGreen();
        int startB = s.getBlue();

        an.apply(s);

        int endX = s.getX();
        int endY = s.getY();
        int endW = s.getWidth();
        int endH = s.getHeight();
        int endR = s.getRed();
        int endG = s.getGreen();
        int endB = s.getBlue();


        movements = checkSVGCommands(startX, startY, startW, startH, startR, startG, startB, endX, endY,
                endW, endH, endR, endG, endB, s, an);



        this.appendHelp(movements);
      }


      this.appendHelp("\n\n</" + getSVGType(s) + ">");
    }
    this.appendHelp("\n\n</svg>");


  }



  private String checkSVGCommands(int startX, int startY, int startW, int startH,
                                  int startR, int startG, int startB, int endX, int endY,
                                  int endW, int endH, int endR, int endG, int endB, Shapes shape,
                                  Animation an) {
    String result = "";

    if (startX != endX) {
      result += locationCommand(shape, an, startX, endX);
    }
    if (startY != endY) {
      result += locationCommand(shape, an, startY, endY);
    }
    if (startW != endW) {
      result += sizeCommand(shape, an, startW, endW);
    }
    if (startH != endH) {
      result += sizeCommand(shape, an, startH, endH);
    }
    if (startR != endR || startG != endG || startB != endB) {
      result += colorCommand(an, startR, endR, startG, endG, startB, endB);
    }

    return result;
  }

  private String locationCommand(Shapes shape, Animation an, int startval, int endval) {

    String start = "<animate attributeType=\"xml\" begin=\"" +
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

  private String sizeCommand(Shapes shape, Animation an, int startval, int endval) {

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


  private String getSVGType(Shapes s){
    if (s.getDesc().equals("Rectangle")){
      return "rect";
    }
    else if (s.getDesc().equals("Ellipse")){
      return "ellipse";
    }
    else {
      throw new IllegalArgumentException("Shape is not valid");
    }
  }

  private String getSVGDesc(Shapes s){
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


    } else if (s.getDesc().equals("Ellipse")) {
      result = "cx=\"" + s.getX()
              + "\" cy=\"" + s.getY()
              + "\" rx=\"" + s.getWidth()
              + "\" ry=\"" + s.getHeight()
              + "\" fill=\"rgb(" + s.getRed()
              + "," + s.getBlue()
              + "," + s.getGreen() + ")\""
              + " visibility=\"";
    }

    return result;
  }


}
