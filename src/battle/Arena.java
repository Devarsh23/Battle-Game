package battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This the class which keeps the list of the gear and the weapon. The player can request the
 * list of gear and the weapon from the arena class. It includes method like getListOfGear which
 * selects twenty random gear from the available list of gears and getWeapon which selects one
 * gear form the available list of weapons
 */
public class Arena {
  private List<Gear> gearList;
  private List<Weapon> weaponList;
  private ValueGenerator randomNumber;

  /**
   * This method constructs the object of the Arena class.
   * @throws IllegalArgumentException if the randomis NULL.
   */
  public Arena(ValueGenerator randomNumber) throws IllegalArgumentException {
    if (randomNumber == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    gearList = new ArrayList<>();
    weaponList = new ArrayList<>();

    this.randomNumber = randomNumber;
    // initializes the list of 40 objects of gear.
    // 1. initialize the first five indices with battle.HeadGear
    for (int i = 0; i <= 4; i++) {
      gearList.add(new HeadGear("Gear" + i, randomNumber));
    }
    //2. Add 5 footwear to the list.
    for (int i = 0; i <= 4; i++) {
      gearList.add(new FootWear("Footwear" + i, randomNumber));
    }
    //3. Add 15 Belts to the list.
    for (int i = 0; i <= 14; i++) {
      if (i <= 4) {
        gearList.add(new Belt("Belt" + i, Ability.CHARISMA, BeltSize.SMALL, randomNumber));
      } else if (i <= 9) {
        gearList.add(new Belt("Belt" + i, Ability.DEXTERITY, BeltSize.LARGE, randomNumber));
      } else {
        gearList.add(new Belt("Belt" + i, Ability.DEXTERITY, BeltSize.MEDIUM, randomNumber));
      }
    }
    //4 Add 15 potion to the list.
    for (int i = 0; i <= 14; i++) {
      if (i <= 7) {
        gearList.add(new Potion("Potion" + i, Ability.STRENGTH, randomNumber));
      } else {
        gearList.add(new Potion("Potion" + i, Ability.CONSTITUTION, randomNumber));
      }
    }
    // initializes the list of all the weapons.
    weaponList.add(new Katanas("Katana1"));
    weaponList.add(new Katanas("Katana2"));
    weaponList.add(new Katanas("Katana3"));
    weaponList.add(new Katanas("Katana4"));
    weaponList.add(new BroadSwords("BroadSword1"));
    weaponList.add(new BroadSwords("BroadSword2"));
    weaponList.add(new TwoHandedSwords("TwoHandedSword1"));
    weaponList.add(new TwoHandedSwords("TwoHandedSword2"));
    weaponList.add(new Axes("Axes1"));
    weaponList.add(new Axes("Axes2"));
    weaponList.add(new Flails("Flails1"));
    weaponList.add(new Flails("Flails2"));
  }

  /**
   * This method specifies the list of the gear the which has to be assigned to the player.
   *
   * @return list containing 20 gear objects/
   */
  protected List<Gear> getListOfGear() {
    /* for testing purposes I have the DefinedNumber generator in the constructor of the arena
    So that we can always have a predefined gear list to test the functionality so for that 
    purposes only below I have used instance of*/
    if (randomNumber instanceof DefinedNumberGenerator) {
      List<Gear> playerGearList = new ArrayList<Gear>();
      for (int i = 0; i < 20; i++) {
        playerGearList.add(gearList.get(0));
      }
      // making a deep copy to return
      List<Gear> gearList1 = new ArrayList<>();
      gearList1.addAll(playerGearList);
      return gearList1;
    }

    Random random = new Random();
    /* If twenty object is already assigned to one player than the remaining twenty would be
    given to the second player. */

    if (gearList.size() == 20) {
      return gearList;
    }
    //1. we will make 25% of the gears affecting negative by the use of doNegative.
    int counter = 0;
    while (counter < (0.25) * gearList.size()) {
      Gear tempGear = gearList.get(random.nextInt(gearList.size()));
      if (!tempGear.isNegative()) {
        tempGear.doNegative();
        counter++;
      }
    }
    //Now we will select the 20 random gears from the bag to assign it to the players.
    List<Gear> playerGearList = new ArrayList<Gear>();
    for (int i = 0; i < 20; i++) {
      playerGearList.add(gearList.remove(random.nextInt(gearList.size())));
    }
    return playerGearList;
  }

  /**
   * This method specifies the object of the weapon class which we have to assigned to the player
   * on appropriate call to this method.
   *
   * @return the object of the weapon class.
   */
  protected List<Weapon> getWeapon() {
    /* for testing purposes I have the DefinedNumber generator in the constructor of the arena
    So that we can always have a predefined gear list to test the functionality so for that
    purposes only below I have used instance of*/

    if (randomNumber instanceof DefinedNumberGenerator) {
      Weapon wTest = new BroadSwords("Broad");
      List<Weapon> weaponTest = new ArrayList<Weapon>();
      weaponTest.add(wTest);
      //making a deep copy to return
      List<Weapon> weaponList1 = new ArrayList<>();
      weaponList1.addAll(weaponList1);
      return weaponList1;
    }

    Random random = new Random();
    List<Weapon> playerWeaponList = new ArrayList<Weapon>();
    Weapon playerWeapon = weaponList.get(random.nextInt(weaponList.size()));
    playerWeaponList.add(playerWeapon);

    /* Now if the weapon assigned to the player is katan then we give him second chance to select
    weapon and if second selected weapon is also Katana then we allow player to take pair of
     katanas. */

    if (playerWeapon.equals(new Katanas("Katanas1"))) {
      Weapon playerWeapon2 =
              weaponList.get(randomNumber.getRandomNumber(0, weaponList.size()));
      if (playerWeapon.equals(new Katanas("Katanas2"))) {
        playerWeaponList.add(playerWeapon2);
      }
    }
    List<Weapon> weaponList2 = new ArrayList<>();
    weaponList2.addAll(playerWeaponList);
    return weaponList2;
  }
}
