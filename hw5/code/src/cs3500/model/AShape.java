package cs3500.model;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AShape implements Shapes{
  protected Position center;
  protected int height;
  protected int width;
  protected Color color;
  protected String name;
  public HashMap<Integer, ArrayList<Animation>> actions;
  public ArrayList<Integer> keyPoints;
  protected String desc;

  public AShape(Position center, int height, int width, Color color, String name) {
    if (height <= 0) {
      throw new IllegalArgumentException("Height cannot be negative");
    }
    if (width <= 0) {
      throw new IllegalArgumentException("Width cannot be negative");
    }
    this.center = center;
    this.height = height;
    this.width = width;
    this.color = color;
    this.name = name;
    this.actions = new HashMap<>();
    this.keyPoints = new ArrayList<>();
  }


  @Override
  public void changeSize(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public void changePosition(Position p) {
    this.center = p;
  }

  @Override
  public void changeColor(Color c) {
    this.color = c;
  }

  @Override
  public String getFullDescription() {
    String output = "shape " + this.name + " " + this.desc + "\n\n";
    for(int key : keyPoints) {
      output += this.getDescription(key);
    }

    return output;
  }

  @Override
  public String getDescription(int key) {
    String out = "motion\t" + this.name +  "\t";
    out += String.format("%-1s %s %-1s %-1s %s", key, this.center.toString(), this.height,
        this.width, this.color.toString()) + "\t\t";
    this.performActions(key);
    out += String.format("%-1s %s %-1s %-1s %s", actions.get(key).get(0).getEndTime() ,
        this.center.toString(), this.height,
        this.width, this.color.toString()) + "\n";

    return out;
  }


  public String getName(){
    return this.name;
  }

  @Override
  public void getImage(){
    //this method is empty because we don't know how to render the images yet
  }

  @Override
  public void addAction(Animation animate) throws IllegalArgumentException{
    int key = animate.getStartTime();

    if(!keyPoints.contains(key)) {
      keyPoints.add(key);
    }

    if(!actions.containsKey(key)) {
      actions.put(key, new ArrayList<Animation>());
    }

    actions.get(key).add(animate);
  }

  public void performActions(int key) {
    for(Animation a: actions.get(key)) {
      a.apply(this);
    }
  }




}


