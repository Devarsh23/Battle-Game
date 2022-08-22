package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the Flails class.
 */
public class FlailsTest {
  private Flails testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * Flails object.
   *
   * @param name the name of the Flails sword.
   * @return a new instance of a Flails Sword class object
   */
  protected Flails testFlails(String name) {
    return new Flails(name);
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testFlails("testFlails");
  }

  @Test
  public void getMinDamage() {
    assertEquals(testDemo.getMinDamage(), 8);
  }

  @Test
  public void getMaxDamage() {
    assertEquals(testDemo.getMaxDamage(), 12);
  }

  @Test
  public void getName() {
    assertEquals(testDemo.getName(), "testFlails");
  }

  @Test
  public void getId() {
    assertEquals(testDemo.getId(), 2);
  }

  @Test
  public void testToString() {
    assertEquals(testDemo.toString(), "Flails \n"
            + "name testFlails\n"
            + "minDamage=8\n"
            + "maxDamage=12\n"
            + "id=2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testFlails("");
  }
}