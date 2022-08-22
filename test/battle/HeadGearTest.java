package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is used to test the HeadGear Class.
 */
public class HeadGearTest {
  private HeadGear testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * HeadGear object.
   *
   * @param name the name of the HeadGear.
   * @return a new instance of a HeadGear class object
   */
  protected HeadGear testHeadGear(String name) {
    return new HeadGear(name, new DefinedNumberGenerator());
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testHeadGear("TestHead");
  }

  @Test
  public void doNegative() {
    testDemo.doNegative();
    assertEquals(testDemo.getEffect(), -3);
  }

  @Test
  public void isNegative() {
    testDemo.doNegative();
    assertTrue(testDemo.isNegative());
  }

  @Test
  public void testToString() {
    assertEquals(testDemo.toString(), "HeadGear : effect=3\n"
            + "name TestHead\n"
            + "abilityAffected CONSTITUTION\n"
            + "order 1");
  }

  @Test
  public void getOrder() {
    assertEquals(testDemo.getOrder(), 1);
  }

  @Test
  public void getAbilityAffected() {
    assertEquals(testDemo.getAbilityAffected(), Ability.CONSTITUTION);
  }

  @Test
  public void getEffect() {
    assertEquals(testDemo.getEffect(), 3);
  }

  @Test
  public void testEquals() {
    assertEquals(testDemo.equals(new HeadGear("test", new DefinedNumberGenerator())),
            true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testHeadGear("");
  }
}