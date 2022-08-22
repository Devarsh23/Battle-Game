import battle.AbstractGear;
import battle.Battle;
import battle.Gear;
import battle.Player;
import battle.RandomValueGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The Driver class is in charge of implementing the entire program. This is the place where all the
 * action is.
 */
public class Driver {
  /**
   * This the entry point of the program.
   *
   * @param args optional arguments to be passed.
   */
  public static void main(String[] args) {
    System.out.println("Greetings to all, and welcome to the Arena! Two players are pitted against"
            + " one another in a match that will change their lives.");
    Scanner input = new Scanner(System.in);
    Battle battle = new Battle(new RandomValueGenerator());
    Player player1 = battle.requestPlayers().get(0);
    Player player2 = battle.requestPlayers().get(1);
    String nameOfPlayer1 = player1.getName();
    String nameOfPlayer2 = player2.getName();
    System.out.println("\nPlayer 1 arrives!");
    System.out.println("\nHis name is " + nameOfPlayer1 + ".\nHis abilities are:"
            + "\nStrength: " + player1.getStrength() + "\nConstitution: "
            + player1.getConstitution() + "\nDexterity: " + player1.getDexterity()
            + "\nCharisma: " + player1.getCharisma() + "\nHealth: " + player1.getHealth());

    System.out.println("\nPlayer 2 arrives!");
    System.out.println("\nHis name is " + nameOfPlayer2 + ".\nHis abilities are:"
            + "\nStrength: " + player2.getStrength() + "\nConstitution: "
            + player2.getConstitution() + "\nDexterity: " + player2.getDexterity()
            + "\nCharisma: " + player2.getCharisma() + "\nHealth: " + player2.getHealth());

    System.out.println("\n" + nameOfPlayer1 + " will now equip gears.");
    player1 = battle.equipPlayer(player1);

    Gear[] gearPlayer1 = new Gear[player1.getEquippedGear().size()];
    for (int i = 0; i < player1.getEquippedGear().size(); i++) {
      gearPlayer1[i] = player1.getEquippedGear().get(i);
    }
    System.out.println("\nGears for player 1 in sorted order are: ");
    Arrays.sort(gearPlayer1);
    for (int i = 0; i < gearPlayer1.length; i++) {
      System.out.println("Gear: " + ((AbstractGear) gearPlayer1[i]).getName()
              + " Affected Ability: " + gearPlayer1[i].getAbilityAffected()
              + " Effect: " + gearPlayer1[i].getEffect());
    }

    System.out.println("\n" + nameOfPlayer2 + " will now equip gears.");
    player2 = battle.equipPlayer(player2);

    Gear[] gearPlayer2 = new Gear[player2.getEquippedGear().size()];
    for (int i = 0; i < player2.getEquippedGear().size(); i++) {
      gearPlayer2[i] = player2.getEquippedGear().get(i);
    }
    System.out.println("\nGears for player 2 in sorted order are: ");
    Arrays.sort(gearPlayer2);
    for (int i = 0; i < gearPlayer2.length; i++) {
      System.out.println("Gear: " + ((AbstractGear) gearPlayer2[i]).getName()
              + " Affected Ability: " + gearPlayer2[i].getAbilityAffected()
              + " Effect: " + gearPlayer2[i].getEffect());
    }

    System.out.println("\n" + nameOfPlayer1 + " requests a weapon from armory");
    System.out.println("He gets a " + player1.getEquippedWeapon().get(0).getName()
            + " having a damage range of " + player1.getEquippedWeapon().get(0).getMinDamage()
            + "-" + player1.getEquippedWeapon().get(0).getMaxDamage());

    System.out.println("\n" + nameOfPlayer2 + " is requesting for a weapon from the armory");
    System.out.println("He gets a " + player2.getEquippedWeapon().get(0).getName()
            + " having a damage range of " + player2.getEquippedWeapon().get(0).getMinDamage()
            + "-" + player2.getEquippedWeapon().get(0).getMaxDamage());

    System.out.println("\nPlayer values after equipping gears: ");
    System.out.println("\nName: " + nameOfPlayer1 + "\nEffective Strength: "
            + player1.getEffectiveStrength() + "\nEffective Constitution: "
            + player1.getEffectiveConstitution() + "\nEffective Dexterity: "
            + player1.getEffectiveDexterity() + "\nEffective Charisma: "
            + player1.getEffectiveCharisma() + "\nEffective Health: "
            + player1.getEffectiveHealth());

    System.out.println("\nName: " + player2.getName() + "\nEffective Strength: "
            + player2.getEffectiveStrength() + "\nEffective Constitution: "
            + player2.getEffectiveConstitution()
            + "\nEffective Dexterity: " + player2.getEffectiveDexterity()
            + "\nEffective Charisma: " + player2.getEffectiveCharisma() + "\nEffective Health: "
            + player2.getEffectiveHealth());
    int player1Health = player1.getEffectiveHealth();
    int player2Health = player2.getEffectiveHealth();
    String replay = "";
    do {
      if (replay.equals("y")) {
        List<Player> regainPlayerList = battle.reMatch(
                player1, player2, player1Health, player2Health);
        player1 = regainPlayerList.get(0);
        player2 = regainPlayerList.get(1);
        System.out.println("\nThe players have regained their health and are ready for reMatch.");
      }
      Integer[] damages;
      System.out.println("The battle begins!");
      int roundCounter = 0;
      List<Player> order1;
      order1 = battle.manageOrder(player1, player2);
      player1 = order1.get(0);
      player2 = order1.get(1);
      int healthPlayer1 = player1.getEffectiveHealth();
      int healthPlayer2 = player2.getEffectiveHealth();
      System.out.println("\n" + player1.getName() + " dazzles " + player2.getName()
              + " because of his high Charisma. So he is the first to " + "attack."
              + " He attacks with " + player1.getEquippedWeapon().get(0).getName());


      //replay = input.next();
      while (player1.getEffectiveHealth() > 0 && player2.getEffectiveHealth() > 0) {
        roundCounter += 1;
        damages = battle.fight(player1, player2);
        System.out.println("\nRound " + roundCounter);
        System.out.println("\n" + nameOfPlayer1 + ": \nDamage Taken: " + damages[1]
                + "\nUpdated Health: " + player1.getEffectiveHealth() + "\n" + nameOfPlayer2
                + ": \nDamage Taken: " + damages[0]
                + "\nUpdated Health: " + player2.getEffectiveHealth());
        if (player1.getEffectiveHealth() <= 0) {
          System.out.println("The winner is: " + nameOfPlayer2);
          System.out.println("Press Y for replay or press any other key to quit.");
          replay = input.next();
        } else if (player2.getEffectiveHealth() <= 0) {
          System.out.println("The winner is: " + nameOfPlayer1);
          System.out.println("Press Y for replay or press any other key to quit.");
          replay = input.next();
        }
        if (roundCounter == 30 && healthPlayer1 == player1.getEffectiveHealth()
                && healthPlayer2 == player2.getEffectiveHealth()) {
          System.out.println("The Game is tied as none of the players can hit each other till "
                  + "30 rounds");
          System.out.println("Press Y for replay or press any other key to quit.");
          replay = input.next();
          break;
        }
      }
    }
    while (replay.equals("y"));
  }
}
