package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is used to test the FootWear class.
 */
public class FootWearTest {
  private FootWear testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * FootWear object.
   *
   * @param name the name of the Footwear.
   * @return a new instance of a footwear class object
   */
  protected FootWear testFootWear(String name) {
    return new FootWear(name, new DefinedNumberGenerator());
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testFootWear("BeltTest");
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
    assertEquals(testDemo.toString(), "battle.FootWear : effect=3\n"
            + "name='BeltTest\n"
            + "abilityAffected=DEXTERITY\n"
            + "order=4");
  }

  @Test
  public void getOrder() {
    assertEquals(testDemo.getOrder(), 4);
  }

  @Test
  public void getAbilityAffected() {
    assertEquals(testDemo.getAbilityAffected(), Ability.DEXTERITY);
  }

  @Test
  public void getEffect() {
    assertEquals(testDemo.getEffect(), 3);
  }

  @Test
  public void testEquals() {
    assertEquals(testDemo.equals(new FootWear("test", new DefinedNumberGenerator())),
            true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testFootWear("");
  }
}