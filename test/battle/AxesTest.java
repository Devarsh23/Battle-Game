package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class is used to test the axes class.
 */
public class AxesTest {
  private Axes testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * Axes object.
   *
   * @param name the name of the Axes.
   * @return a new instance of a Axes class object
   */
  protected Axes testAxes(String name) {
    return new Axes(name);
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testAxes("AxesTest");

  }

  @Test
  public void getMinDamage() {
    assertEquals(testDemo.getMinDamage(), 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testAxes("");
  }

  @Test
  public void getMaxDamage() {
    assertEquals(testDemo.getMaxDamage(), 10);
  }

  @Test
  public void getName() {
    assertEquals(testDemo.getName(), "AxesTest");
  }

  @Test
  public void getId() {
    assertEquals(testDemo.getId(), 1);
  }

  @Test
  public void testToString() {
    assertEquals(testDemo.toString(), "Axes\n"
            + "name AxesTest\n"
            + "minDamage 6\n"
            + "maxDamage 10\n"
            + "id 1");
  }

}
