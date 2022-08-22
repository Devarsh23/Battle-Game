package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class is used to test the broad sword class.
 */
public class BroadSwordsTest {
  private BroadSwords testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * BroadSword object.
   *
   * @param name the name of the broad sword.
   * @return a new instance of a broad Sword class object
   */
  protected BroadSwords testBroadSword(String name) {
    return new BroadSwords(name);
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testBroadSword("TestBroad");
  }

  @Test
  public void getMinDamage() {
    assertEquals(testDemo.getMinDamage(), 6);
  }

  @Test
  public void getMaxDamage() {
    assertEquals(testDemo.getMaxDamage(), 10);
  }

  @Test
  public void getId() {
    assertEquals(testDemo.getId(), 3);
  }

  @Test
  public void testEquals() {
    assertEquals(testDemo.equals(new BroadSwords("test1")), true);
    assertEquals(testDemo.equals(new Katanas("Katana")), false);
  }

  @Test
  public void testToString() {
    assertEquals(testDemo.toString(), "BroadSwords \n"
            + "name TestBroad\n"
            + "minDamage 6\n"
            + "maxDamage 10\n"
            + "id=3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testBroadSword("");
  }
}