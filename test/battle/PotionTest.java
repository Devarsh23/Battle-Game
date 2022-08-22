package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is used to test the Potion class.
 */
public class PotionTest {
  private Potion testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * Potion object.
   *
   * @param name            the name of the Potion.
   * @param abilityAffected the ability which the Potion is affecting.
   * @return a new instance of a Potion class object.
   */
  protected Potion testPotion(String name, Ability abilityAffected) {
    return new Potion(name, abilityAffected, new DefinedNumberGenerator());
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testPotion("TestHead", Ability.DEXTERITY);
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
    assertEquals(testDemo.toString(), "battle.Potion : effect=3\n"
            + "name='TestHead\n"
            + "abilityAffected=DEXTERITY\n"
            + "order=2");
  }

  @Test
  public void getOrder() {
    assertEquals(testDemo.getOrder(), 2);
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
    assertEquals(testDemo.equals(new Potion("test", Ability.DEXTERITY,
            new DefinedNumberGenerator())), true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testPotion("", Ability.DEXTERITY);
  }
}