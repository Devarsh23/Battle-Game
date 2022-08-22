package battle;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class is used to test the player class. Here we text the different fields and functionality
 * of the player class and ensures that it runs properly.
 */
public class PlayerTest {
  private Player firstPlayerTest;
  private Player secondPlayerTest;

  @Before
  public void setUp() throws Exception {
    /* For testing purposes I have used the fixed defined value generator which generates the
    value according to my logic so that I can know what must be the expected value of the
    functionality. It is important to nate that this will not give the user any idea of
    internal representation.*/
    firstPlayerTest = testPlayer("Devarsh", new DefinedValueGenerator());
    secondPlayerTest = testPlayer("Patel", new DefinedNumberGenerator());
  }

  /**
   * This method is easy and short way of creating instances of a new
   * Player object.
   *
   * @param name the name of the Player.
   * @param num  the object of the random generator.
   * @return a new instance of a player class object
   */
  protected Player testPlayer(String name, ValueGenerator num) {
    return new Player(name, num);
  }

  @Test
  public void attack() {

    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.calculateStrikingPower();
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    secondPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    secondPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    secondPlayerTest.calculateAvoidanceAbility();
    secondPlayerTest.calculateStrikingPower();

    assertEquals(firstPlayerTest.attack(secondPlayerTest), 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testPlayer("", new RandomValueGenerator());
  }

  @Test
  public void getStrength() {
    assertEquals(firstPlayerTest.getStrength(), 9);
    assertEquals(secondPlayerTest.getStrength(), 6);
  }

  @Test
  public void getConstitution() {
    assertEquals(firstPlayerTest.getConstitution(), 9);
    assertEquals(secondPlayerTest.getConstitution(), 6);
  }

  @Test
  public void getDexterity() {
    assertEquals(firstPlayerTest.getDexterity(), 9);
    assertEquals(secondPlayerTest.getDexterity(), 6);
  }

  @Test
  public void getCharisma() {
    assertEquals(firstPlayerTest.getCharisma(), 9);
    assertEquals(secondPlayerTest.getCharisma(), 6);
  }

  @Test
  public void getHealth() {
    assertEquals(firstPlayerTest.getHealth(), 36);
    assertEquals(secondPlayerTest.getHealth(), 24);
  }

  @Test
  public void modifyHealth() {
    firstPlayerTest.modifyHealth(5);
    assertEquals(firstPlayerTest.getHealth(), 36);
    secondPlayerTest.modifyHealth(21);
    assertEquals(secondPlayerTest.getHealth(), 24);
  }

  @Test
  public void testToString() {
    assertEquals(firstPlayerTest.toString(), "Player \n"
            + "name Devarsh\n"
            + "strength 9\n"
            + "constitution 9\n"
            + "dexterity 9\n"
            + "charisma 9\n"
            + "health 36\n"
            + "strikingPower 0\n"
            + "avoidanceAbility 0");
    assertEquals(secondPlayerTest.toString(), "Player \nname Patel\n"
            + "strength 6\n"
            + "constitution 6\n"
            + "dexterity 6\n"
            + "charisma 6\n"
            + "health 24\n"
            + "strikingPower 0\n"
            + "avoidanceAbility 0");
  }


  @Test
  public void getStrikingPower() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.calculateStrikingPower();
    assertEquals(firstPlayerTest.getStrikingPower(), 14);
    secondPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    secondPlayerTest.calculateStrikingPower();
    assertEquals(secondPlayerTest.getStrikingPower(), 9);
  }


  @Test
  public void getAvoidanceAbility() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.calculateAvoidanceAbility();
    assertEquals(firstPlayerTest.getAvoidanceAbility(), 12);
    secondPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    secondPlayerTest.calculateAvoidanceAbility();
    assertEquals(secondPlayerTest.getAvoidanceAbility(), 8);
  }

  @Test
  public void equippedGearHelper() {

    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    assertTrue(firstPlayerTest.getEquippedGear().size() > 0);
    assertTrue(firstPlayerTest.getEquippedGear().size() <= 20);
    for (int i = 0; i < firstPlayerTest.getEquippedGear().size(); i++) {
      assertTrue(firstPlayerTest.getEquippedGear().get(i) instanceof Gear);
    }
    secondPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    assertTrue(secondPlayerTest.getEquippedGear().size() > 0);
    assertTrue(secondPlayerTest.getEquippedGear().size() <= 20);
    for (int i = 0; i < secondPlayerTest.getEquippedGear().size(); i++) {
      assertTrue(secondPlayerTest.getEquippedGear().get(i) instanceof Gear);
    }
  }

  @Test
  public void equipWeapon() {
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    assertEquals(firstPlayerTest.getEquippedWeapon().get(0).getName(), "Broad");
  }

  @Test
  public void getEquippedGear() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    assertTrue(firstPlayerTest.getEquippedGear().size() > 0);
    assertTrue(firstPlayerTest.getEquippedGear().size() <= 20);
    for (int i = 0; i < firstPlayerTest.getEquippedGear().size(); i++) {
      assertTrue(firstPlayerTest.getEquippedGear().get(i) instanceof Gear);
    }
    secondPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    assertTrue(secondPlayerTest.getEquippedGear().size() > 0);
    assertTrue(secondPlayerTest.getEquippedGear().size() <= 20);
    for (int i = 0; i < secondPlayerTest.getEquippedGear().size(); i++) {
      assertTrue(secondPlayerTest.getEquippedGear().get(i) instanceof Gear);
    }
  }

  @Test
  public void getEquippedWeapon() {
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    assertTrue(firstPlayerTest.getEquippedWeapon().size() >= 1
            && firstPlayerTest.getEquippedWeapon().size() <= 2);
    assertEquals(firstPlayerTest.getEquippedWeapon().get(0).getName(), "Broad");
  }

  @Test
  public void getEffectiveStrength() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    assertEquals(firstPlayerTest.getEffectiveStrength(), 9);
    secondPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    assertEquals(secondPlayerTest.getEffectiveStrength(), 6);
  }

  @Test
  public void getEffectiveDexterity() {
    assertEquals(firstPlayerTest.getEffectiveDexterity(), 9);
    assertEquals(secondPlayerTest.getEffectiveDexterity(), 6);
  }

  @Test
  public void getEffectiveConstitution() {
    assertEquals(firstPlayerTest.getEffectiveConstitution(), 9);
    assertEquals(secondPlayerTest.getEffectiveConstitution(), 6);
  }

  @Test
  public void getEffectiveCharisma() {
    assertEquals(firstPlayerTest.getEffectiveCharisma(), 9);
    assertEquals(secondPlayerTest.getEffectiveCharisma(), 6);
  }

  @Test
  public void testGearOrder() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    int size = firstPlayerTest.getEquippedGear().size();
    Gear[] gExpected = new Gear[size];
    for (int i = 0; i < size; i++) {
      gExpected[i] = firstPlayerTest.getEquippedGear().get(i);
    }
    Arrays.sort(gExpected);
    /* So now as we have expected array we can call the sorted array and compare that our array
     * is properly sorted or not.*/
    assertArrayEquals(firstPlayerTest.getSortedListOfGears(), gExpected);
  }

  @Test
  public void testWeaponDamageInRange() {
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.calculateWeaponDamage();
    int minRange = firstPlayerTest.getEquippedWeapon().get(0).getMinDamage();
    int maxRange = firstPlayerTest.getEquippedWeapon().get(0).getMaxDamage();
    assertTrue(firstPlayerTest.getWeaponDamage() >= minRange
            && firstPlayerTest.getWeaponDamage() <= maxRange);
  }

  @Test
  public void testGetPotentialStrikingDamage() {
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.calculateWeaponDamage();
    firstPlayerTest.calculatePotentialStrikingDamage(firstPlayerTest.getWeaponDamage());
    int actual = firstPlayerTest.getPotentialStrikingDamage();
    assertEquals(actual, 17);
  }

  @Test
  public void testGetWeaponDamage() {
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.calculateWeaponDamage();
    assertEquals(firstPlayerTest.getWeaponDamage(), 8);
  }

  @Test
  public void testIfOnlyZeroOrOneHeadGear() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    int count = 0;
    int size = firstPlayerTest.getEquippedGear().size();
    for (int i = 0; i < size; i++) {
      if (firstPlayerTest.getEquippedGear().get(i).equals(
              new HeadGear("test", new DefinedNumberGenerator()))) {
        count++;
      }
    }
    /*This test ensures that the in every case the count can not be greater than one.
    It can be either zero or one. So, player can wear one or Zero head gear but not more than one
    gear. */
    assertTrue(count <= 1 && count >= 0);
  }

  @Test
  public void testIfOnlyZeroOrOneFootWear() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedNumberGenerator()));
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    int count = 0;
    int size = firstPlayerTest.getEquippedGear().size();
    for (int i = 0; i < size; i++) {
      if (firstPlayerTest.getEquippedGear().get(i).equals(
              new FootWear("test", new DefinedNumberGenerator()))) {
        count++;
      }
    }
    /*This test ensures that the in every case the count can not be greater than one.
    It can be either zero or one. So, player can wear one or zero Foot wear but not more than one
    Foot wear. */
    assertTrue(count <= 1 && count >= 0);
  }

  @Test
  public void testIfTenBeltUnit() {
    firstPlayerTest.equippedGearHelper(new Arena(new DefinedValueGenerator()));
    firstPlayerTest.equipWeapon(new Arena(new DefinedNumberGenerator()));
    int unit = 0;
    List<Gear> test = firstPlayerTest.getEquippedGear();
    for (int i = 0; i < firstPlayerTest.getEquippedGear().size(); i++) {
      if (test.get(i).equals(
              new Belt("test", Ability.DEXTERITY, BeltSize.MEDIUM,
                      new DefinedNumberGenerator()))) {
        if (((Belt) test.get(i)).getSize() == BeltSize.SMALL) {
          unit += 1;
        } else if (((Belt) firstPlayerTest.getEquippedGear().get(i)).getSize() == BeltSize.MEDIUM) {
          unit += 2;
        } else {
          unit += 4;
        }
      }
    }
    /*This ensures that there is only Ten Belts equip by player and he/She can not equip more than
    10 units of belt */
    assertEquals(unit, 10);
  }

}