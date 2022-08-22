package battle;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is used to test the battle object.
 */
public class BattleTest {
  private Battle battleTest;
  private Player player1;
  private Player player2;

  /**
   * This method is easy and short way of creating instances of a new
   * Battle object.
   *
   * @param num the object of the random generator.
   * @return a new instance of a battle class object
   */
  protected Battle testBattle(ValueGenerator num) {
    return new Battle(new DefinedNumberGenerator());
  }


  @Before
  public void setUp() throws Exception {
    battleTest = testBattle(new DefinedValueGenerator());
    player1 = new Player("Devarsh", new DefinedValueGenerator());
    player2 = new Player("Patel", new DefinedNumberGenerator());
  }

  @Test
  public void requestPlayers() {
    List<Player> playerList;
    assertTrue(battleTest.requestPlayers().get(0) instanceof Player);
    assertTrue(battleTest.requestPlayers().get(1) instanceof Player);
    assertEquals(battleTest.requestPlayers().get(0).getName(), "Devarsh");
    assertEquals(battleTest.requestPlayers().get(1).getName(), "Patel");
  }

  @Test
  public void equipPlayer() {
    battleTest.equipPlayer(player1);
    /* when the player is equipped we calculate striking power, avoidance ability, and effective
    health in  this fuctinon so we would compare all those to check this functions correctly
    or not.*/
    assertEquals(player1.getStrikingPower(), 14);
    assertEquals(player1.getAvoidanceAbility(), 12);
    assertEquals(player1.getEffectiveHealth(), 39);

    /* Now we will test that the player is equipped with correct gears and weapon or not. */
    // to test gears
    assertTrue(player1.getEquippedGear().size() > 0);
    assertTrue(player1.getEquippedGear().size() <= 20);
    for (int i = 0; i < player1.getEquippedGear().size(); i++) {
      assertTrue(player1.getEquippedGear().get(i) instanceof Gear);
    }
    // to test weapons
    assertEquals(player1.getEquippedWeapon().get(0).getName(), "Broad");
  }

  @Test
  public void manageOrder() {
    List<Player> playerList = new ArrayList<>();
    playerList.add(player1);
    playerList.add(player2);
    /* We have created the above list in which the player one is at zeroth index and player 2 is at
     * first index this shows that the player 1 takes the first turn. We will compare this with
     * our model output because there also the player one has the higher charisma. Hence we could
     * ensure that the order of the game is preserved according to charisma. */
    assertEquals(battleTest.manageOrder(player1, player2), playerList);
  }

  @Test
  public void fight() {
    battleTest.equipPlayer(player1);
    battleTest.equipPlayer(player2);
    Integer[] test = {8, 0};
    assertArrayEquals(battleTest.fight(player1, player2), test);
  }

  @Test
  public void testIfPlayerEntryValid() {
    /* Here we check that the player does not have any weapon and gear when entering the arena.
     * by calling the request player and ensuring the player enters with bare hands*/
    assertEquals(battleTest.requestPlayers().get(0).getEquippedGear().size(), 0);
    assertEquals(battleTest.requestPlayers().get(1).getEquippedGear().size(), 0);
    assertEquals(battleTest.requestPlayers().get(0).getEquippedWeapon().size(), 0);
    assertEquals(battleTest.requestPlayers().get(1).getEquippedWeapon().size(), 0);
  }

  @Test
  public void testRandomness() {
    /* This loop ensures that the random values generated during the project are in a given
     stipulated range according to the description. For this we check by generating the random
     values 1000 times*/
    for (int i = 0; i < 1000; i++) {
      Player player1 = new Player("Devarsh", new RandomValueGenerator());
      Player player2 = new Player("Patel", new RandomValueGenerator());
      // this ensures that the strength initialised by the player is in given range.
      assertTrue(player1.getStrength() >= 6 && player1.getStrength() <= 18);
      // this ensures that the Constitution initialised by the player is in given range.
      assertTrue(player1.getConstitution() >= 6 && player1.getConstitution() <= 18);
      // this ensures that the Dexterity initialised by the player is in given range.
      assertTrue(player1.getDexterity() >= 6 && player1.getDexterity() <= 18);
      // this ensures that the Charisma initialised by the player is in given range.
      assertTrue(player1.getCharisma() >= 6 && player1.getCharisma() <= 18);
      //// this ensures that the health of the player is in given range.
      assertTrue(player1.getHealth() >= 24 && player1.getHealth() <= 72);
      player1.equippedGearHelper(new Arena(new RandomValueGenerator()));
      player2.equippedGearHelper(new Arena(new RandomValueGenerator()));
      player1.equipWeapon(new Arena(new RandomValueGenerator()));
      player2.equipWeapon(new Arena(new RandomValueGenerator()));
      List<Gear> listOfGear = new ArrayList<>();
      int size = listOfGear.size();
      for (int j = 0; j < size; j++) {
        // This ensures that the effect value of the gear equipped by the player is in given range.
        assertTrue(listOfGear.get(i).getEffect() > 0
                && listOfGear.get(i).getEffect() <= 10);
      }
      player1.calculateStrikingPower();
      player2.calculateStrikingPower();
      // This ensures that the striking power of the player is with in range.
      assertTrue(player1.getStrikingPower() >= 0 && player1.getStrikingPower() <= 128);
      player1.calculateAvoidanceAbility();
      player2.calculateAvoidanceAbility();
      // This ensures that the avoidance ability of the player is with in range.
      assertTrue(player1.getAvoidanceAbility() >= 0
              && player1.getAvoidanceAbility() <= 148);
      player1.calculateEffectiveHealth();
      player2.calculateEffectiveHealth();
      assertTrue(player1.getEffectiveHealth() >= 0 && player1.getEffectiveHealth() <= 300);
      assertTrue(player1.attack(player2) >= 0 && player1.attack(player2) <= 150);
    }
  }
}