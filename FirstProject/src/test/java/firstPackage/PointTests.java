package firstPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPoint() {
    Point p = new Point(3, 10);
    Assert.assertEquals(p.calculateDistance(), 7.0);
  }
  @Test
  public void testPoint2() {
    Point d = new Point(10, 1);
    Assert.assertEquals(d.calculateDistance(), -9.0);
  }
  @Test
  public void testPoint3() {
    Point f = new Point(5, 5);
    assert f.calculateDistance() == 0.0;
  }
}
