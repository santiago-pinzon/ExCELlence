package cs3500.animator.provider.view;

import java.util.Comparator;
import cs3500.animator.provider.view.Motion;

/**
 * The class of comparator for comparing the motion's start tick.
 */
public class TimeComparator implements Comparator<Motion> {

  // the comparator used to sort the motion from the smallest start tick to the biggest.
  @Override
  public int compare(Motion m1, Motion m2) {
    if (m1.getTickStart() < m2.getTickStart()) {
      return 0;
    } else {
      return 1;
    }
  }
}
