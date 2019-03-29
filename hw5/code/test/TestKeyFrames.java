import cs3500.model.Animation;
import cs3500.model.Rectangle;
import org.junit.Test;

import cs3500.model.KeyFrame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cs3500.model.Color;
import cs3500.model.Ellipse;
import cs3500.model.Position;
import cs3500.model.Shapes;

import static org.junit.Assert.assertEquals;


/**
 * Testing shapes.
 */

public class TestKeyFrames {

  @Test
  public void testKeyFrameConstructor1ToString(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals("1     0     0     10    10    255   0     0    ", k.toString());

  }

  @Test
  public void testKeyFrameConstructor2ToString(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    KeyFrame k2 = new KeyFrame(1, 10, 10, 20, 20, 0, 255, 0);
    KeyFrame k3 = new KeyFrame(k, k2, 4);
    assertEquals("1     40    40    50    50    -765  1020  0    ", k3.toString());
  }

  @Test
  public void testKeyFrameGetKey(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(1, k.getKey());
  }

  @Test
  public void testKeyFrameGetX(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(0, k.getX());
  }

  @Test
  public void testKeyFrameGetY(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(0, k.getY());
  }

  @Test
  public void testKeyFrameGetH(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(10, k.getH());
  }

  @Test
  public void testKeyFrameGetW(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(10, k.getW());
  }

  @Test
  public void testKeyFrameGetR(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(255, k.getR());
  }

  @Test
  public void testKeyFrameGetG(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(0, k.getG());
  }

  @Test
  public void testKeyFrameGetB(){
    KeyFrame k = new KeyFrame(1, 0, 0, 10, 10, 255, 0, 0);
    assertEquals(0, k.getB());
  }
}
