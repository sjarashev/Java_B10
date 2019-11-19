package firstPackage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

  @Test
  public void testPoint1() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(4, 5);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
  }

  @Test
  public void testPoint2() {
    Point p1 = new Point(-1, 2);
    Point p2 = new Point(3, -4);
    Assert.assertEquals(p1.distance(p2), 7.211102550927978);
  }

  @Test
  public void testPoint3() {
    Point p1 = new Point(45, 54);
    Point p2 = new Point(3, -55);
    Assert.assertEquals(p1.distance(p2), 116.81181447096864);
  }

}
