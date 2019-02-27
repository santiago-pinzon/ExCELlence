package cs3500.model;

public interface Animation {

  int getStartTime();

  int getEndTime();

  void apply(Shapes shape);

}
