import junit.framework.TestCase;

import org.junit.Test;


import java.util.LinkedHashMap;

import cs3500.animator.view.SVGView;
import cs3500.animator.view.TextView;
import cs3500.animator.view.IView;
import cs3500.model.AnimationModel;
import cs3500.model.AnimationModelImpl;
import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationBuilderImpl;
import cs3500.model.Color;
import cs3500.model.ColorChange;
import cs3500.model.Motion;
import cs3500.model.Size;
import cs3500.model.Position;
import cs3500.model.Rectangle;
import cs3500.model.Ellipse;
import cs3500.model.Shapes;


import static org.junit.Assert.assertEquals;

public class KeyFrameTests {

  @Test
  public void add1(){
    AnimationBuilder animator =
            new AnimationBuilderImpl().declareShape("r", "rectangle")
                    .addMotion("r", 0, 200, 200, 50, 100, 255, 0, 0,
                            10, 10, 200, 50, 100, 255, 0, 0, true)
                    .addMotion("r", 10, 10, 200, 50, 100, 255, 0, 0,
                            20, 300, 300, 50, 100, 255, 0, 0, true)
                    .addMotion("r", 20, 300, 300, 50, 100, 255, 0, 0,
                            45, 300, 300, 50, 100, 255, 0, 0, true)
                    .declareShape("c", "ellipse")
                    .addMotion("c", 0, 440, 70, 60, 120, 0, 0, 255, 10,
                            100, 100, 60, 120, 0, 0, 255, true)
                    .addMotion("c", 20, 200, 100, 60, 120, 0, 0, 255, 45,
                            200, 100, 60, 120, 0, 0, 255, true)
                    .addMotion("c", 46, 100, 100, 60, 120, 0, 0, 255, 50,
                            200, 100, 60, 120, 0, 0, 255, true);

    animator.build();


    animator.addKeyframe("c", 5, 0, 0, 1, 1, 0, 0, 0);

  //  animator.addKeyframe("c", 50, 0, 0, 1, 1, 0, 0, 0);


    animator.addKeyframe("r", 2, 200, 200, 1, 1, 0, 255, 0);



    Appendable a = new StringBuilder();

    TextView view = new TextView((AnimationBuilderImpl) animator, 0, 0, 0, 0, a);
    view.render2();

    assertEquals("canvas 0 0 0 0\n" +
                    "shape r Rectangle\n" +
                    "motion r 0 200 200 50 100 255 0 0   0 200 200 50 100 255 0 0\n" +
                    "motion r 0 200 200 50 100 255 0 0   10 10 200 50 100 255 0 0\n" +
                    "motion r 10 10 200 50 100 255 0 0   20 300 300 50 100 255 0 0\n" +
                    "motion r 20 300 300 50 100 255 0 0   45 300 300 50 100 255 0 0\n" +
                    "motion r 45 300 300 50 100 255 0 0   50 30 20 50 100 255 0 0\n" +
                    "shape c Ellipse\n" +
                    "motion c 0 440 70 60 120 0 255 0   0 440 70 60 120 0 255 0\n" +
                    "motion c 0 440 70 60 120 0 255 0   10 100 100 60 120 0 255 0\n" +
                    "motion c 10 100 100 60 120 0 255 0   20 200 100 60 120 0 255 0\n" +
                    "motion c 20 200 100 60 120 0 255 0   45 200 100 60 120 0 255 0\n",
            a.toString());


  }
}


  }

