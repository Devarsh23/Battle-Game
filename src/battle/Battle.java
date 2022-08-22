package battle;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class where the main battle takes place. Here the two players are initialized
 * they equip gears from list and, also request weapons from list.
 * After that, a turn taking game starts.
 */
public class Battle {
  private Arena arena;
  ValueGenerator randomNumber;
  private Player player1;
  private Player player2;

  /**
   * This constructs the object of the battle class. It takes the object of the random generator
   * as the argument.
   *
   * @param randomNumber the object of the ValueGenerator class.
   * @throws IllegalArgumentException if randomNumber is NULL.
   */
  public Battle(ValueGenerator randomNumber) throws IllegalArgumentException {
    if (randomNumber == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    this.randomNumber = randomNumber;
    arena = new Arena(this.randomNumber);
    this.player1 = new Player("Devarsh", randomNumber);
    this.player2 = new Player("Patel", randomNumber);
  }

  /**
   * This method specifies the players for the battle.
   *
   * @return the list of players in the battle
   * @throws IllegalStateException if the player enters arena without bare hands and basic ability.
   */
  public List<Player> requestPlayers() throws IllegalStateException {
    /* Here we check that the player entering the battle that is the arena does not possess any
    weapons and gear he/she enters the battle with only bare hands.
     */
    if ((player1.getEquippedWeapon().size() == 0 && player1.getEquippedGear().size() == 0)
            && (player2.getEquippedWeapon().size() == 0 && player2.getEquippedGear().size() == 0)) {
      List<Player> listOfPlayer = new ArrayList<>();
      listOfPlayer.add(player1);
      listOfPlayer.add(player2);
      List<Player> listOfPlayer1 = new ArrayList<>();
      listOfPlayer1.addAll(listOfPlayer);
      return listOfPlayer1;
    }
    throw new IllegalStateException(
            "The player can enter battle with only bare hands and basic abilities");
  }

  /**
   * In this method the player is equipped with the gears and weapons.
   */
  public Player equipPlayer(Player player) {
    player.equippedGearHelper(arena);
    player.equipWeapon(arena);
    player.calculateStrikingPower();
    player.calculateAvoidanceAbility();
    player.calculateEffectiveHealth();
    return player;
  }


  /**
   * This method specifies the player who possess higher charisma and selects the order of the
   * player. Here the charisma of both the player is calculated and the player are added in to the
   * list in the order of their charisma. This ensures that the player entering first in the order
   * always take first round followed by the other. The turn based battle is executed with the
   * help of this method.
   *
   * @param player1 the object of player 1.
   * @param player2 the object of player 2.
   * @return the order of the player in which they take turn.
   */
  public List<Player> manageOrder(Player player1, Player player2) {
    List<Player> order = new ArrayList<Player>();
    if (player1.getEffectiveCharisma() >= player2.getEffectiveCharisma()) {
      order.add(player1);
      order.add(player2);
    } else {
      order.add(player2);
      order.add(player1);
    }
    List<Player> order1 = new ArrayList<>();
    order1.addAll(order);
    return order1;
  }

  /**
   * The fight method refers to how the entire fight is carried out. If a player's striking
   * power exceeds the opponent's avoidance ability, the opponent takes damage and his health is
   * updated correspondingly. Then it's time for the opponent to do the same. This is one of them.
   * This is the first round of the battle.
   *
   * @param player1 Object of Player 1
   * @param player2 Object of Player 2
   * @return an array containing the damage values of the round.
   */
  public Integer[] fight(Player player1, Player player2) {
    Integer[] arr = new Integer[2];
    if (player1.getStrikingPower() > player2.getAvoidanceAbility()) {
      arr[0] = player1.attack(player2);
      player2.modifyHealth(arr[0]);
    } else {
      arr[0] = 0;
    }
    if (player2.getStrikingPower() > player1.getAvoidanceAbility()) {
      arr[1] = player2.attack(player1);
      player1.modifyHealth(arr[1]);
    } else {
      arr[1] = 0;
    }
    return arr;
  }

  /**
   * This method provides the functionality of the Rematch. The player's health are made full again
   * and all of their abilities are restored to the initial.
   *
   * @return List of the player with their initial abililty and restored health.
   */
  public List<Player> reMatch(
          Player player1, Player player2, int player1Health, int player2health) {
    List<Player> list = new ArrayList<>();
    player1.regainHealth(player1Health);
    player2.regainHealth(player2health);
    list.add(player1);
    list.add(player2);
    List<Player> list1 = new ArrayList<>();
    list1.addAll(list);
    return list1;
  }

}
