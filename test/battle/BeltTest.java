package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is used to test the belt class.
 */
public class BeltTest {
  private Belt testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * Belt object.
   *
   * @param name            the name of the Belt.
   * @param abilityAffected the ability affected by the Belt.
   * @param size            the size of the belt.
   * @return a new instance of a Belt class object
   */
  protected Belt testBelt(String name, Ability abilityAffected, BeltSize size) {
    return new Belt(name, abilityAffected, size, new DefinedNumberGenerator());
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testBelt("BeltTest", Ability.DEXTERITY, BeltSize.MEDIUM);
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
    assertEquals(testDemo.toString(), "Belt \n"
            + "name BeltTest\n"
            + "abilityAffected DEXTERITY\n"
            + "effect 3\n"
            + "order 3\n"
            + "size MEDIUM");
  }

  @Test
  public void getOrder() {
    assertEquals(testDemo.getOrder(), 3);
  }

  @Test
  public void getEffect() {
    assertEquals(testDemo.getEffect(), 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testBelt("", Ability.DEXTERITY, BeltSize.MEDIUM);
  }

  @Test
  public void testEquals() {
    assertEquals(testDemo.equals(new Belt("test", Ability.DEXTERITY, BeltSize.MEDIUM,
            new RandomValueGenerator())), true);
    assertEquals(testDemo.equals(new HeadGear("Htesy", new RandomValueGenerator())),
            false);
  }

  @Test
  public void getSize() {
    assertEquals(testDemo.getSize(), BeltSize.MEDIUM);
  }

  @Test
  public void getAbilityAffected() {
    assertEquals(testDemo.getAbilityAffected(), Ability.DEXTERITY);
  }


}