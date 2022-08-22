package battle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is the player class it represents various fields of the player. It includes all the
 * details of the player like name, abilities, health, striking power, and avoidance ability.
 */
public class Player {
  private String name;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int health;
  private int strikingPower;
  private int avoidanceAbility;
  private int effectiveHealth;
  private int potentialStrikingDamage;
  private int weaponDamage;
  private List<Gear> equippedGear;
  private List<Weapon> equippedWeapon;
  private ValueGenerator randomNumber;

  /**
   * It constructs the player object. It initializes the field of the player.
   *
   * @param name the name of the player.
   * @throws IllegalStateException if the value of the ability is less than 6 or greater than 18
   * @throws IllegalArgumentException if the name is empty,
   *                                  if the name is NUll,
   *                                  if random is NULL.
   */
  public Player(String name, ValueGenerator randomNumber) throws IllegalStateException,
          IllegalArgumentException {
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (name == null) {
      throw new IllegalArgumentException("The name of player can not be null");
    }
    if (randomNumber == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    this.name = name;
    this.randomNumber = randomNumber;
    this.strength = this.rollDice();
    this.constitution = this.rollDice();
    this.dexterity = this.rollDice();
    this.charisma = this.rollDice();
    this.equippedGear = new ArrayList<>();
    this.equippedWeapon = new ArrayList<>();
    if ((this.strength < 6 || this.strength > 18) || (this.constitution < 6
            || this.constitution > 18) || (this.dexterity < 6 || this.dexterity > 18)
            || (this.charisma < 6 || this.charisma > 18)) {
      throw new IllegalStateException("The values of the ability must be in the range of 6 to 18");
    }
    this.health = strength + constitution + dexterity + charisma;
  }

  /**
   * This method specifies the name of the player.
   *
   * @return the name of the player in string format.
   */
  public String getName() {
    return this.name;
  }

  private int sum(List<Integer> list) {
    int sum = 0;
    for (int i : list) {
      sum = sum + i;
    }
    return sum;
  }

  /**
   * This class returns the random number by rolling four six faced dice and discarding one.
   *
   * @return random integer in the range of six to eighteen.
   */
  private int rollDice() {
    int counter = 0;
    int sum = 0;
    List<Integer> temp = new ArrayList<Integer>();

    while (counter != 4) {
      int value = randomNumber.getRandomNumber(1, 6);
      if (value != 1) {
        counter = counter + 1;
        temp.add(value);
      }
    }
    Collections.sort(temp);

    for (int i = 0; i < 3; i++) {
      sum = sum + temp.get(i);
    }
    return sum;
  }

  /**
   * This method specifies the attack done by the player on the other player and returns the
   * damage caused by the attack.
   *
   * @param obj the object of the another player on which attack is executed.
   * @return the damage caused by the particular attack.
   */
  public int attack(Player obj) {
    Weapon playerWeapon = this.getEquippedWeapon().get(0);
    calculateWeaponDamage();
    this.weaponDamage = getWeaponDamage();
    calculatePotentialStrikingDamage(this.weaponDamage);
    this.potentialStrikingDamage = this.getPotentialStrikingDamage();
    int damage = 0;
    damage = this.potentialStrikingDamage - obj.getEffectiveConstitution();
    return damage;
  }

  /**
   * This method specifies the damage caused by the weapon equip by the player.
   */
  protected void calculateWeaponDamage() {
    /* Here the id of flails is 2 and id of two handed sword is 5. So in this case we have
     * check the strength and dexterity to ensure if they are less than 14 they do half damage. */
    if ((this.equippedWeapon.get(0).getId() == 5) && (this.getEffectiveStrength() <= 14)
            || (this.equippedWeapon.get(0).getId() == 2 && this.getEffectiveDexterity() <= 14)) {
      this.weaponDamage = this.randomNumber.getRandomNumber(equippedWeapon.get(0).getMinDamage(),
              equippedWeapon.get(0).getMaxDamage()) / 2;
    } else {
      this.weaponDamage = this.randomNumber.getRandomNumber(
              this.equippedWeapon.get(0).getMinDamage(), this.equippedWeapon.get(0).getMaxDamage());
    }
  }

  /**
   * This method gets the damage caused by the weapon equip by the player.
   *
   * @return the damage caused by the player.
   */

  public int getWeaponDamage() {
    return this.weaponDamage;
  }

  /**
   * This method calculates the potential striking damage.
   *
   * @param weaponDamage the damage cause by the weapon equipped.
   */
  protected void calculatePotentialStrikingDamage(int weaponDamage) {
    this.potentialStrikingDamage = this.getEffectiveStrength() + weaponDamage;
  }

  /**
   * This method gets the potential striking damage of the player.
   *
   * @return the potential striking damage.
   */
  public int getPotentialStrikingDamage() {
    return potentialStrikingDamage;
  }

  /**
   * This helps to get the strength of the player.
   *
   * @return this specifies the strength of the player.
   */

  public int getStrength() {
    return this.strength;
  }

  /**
   * This helps to get the constitution of the player.
   *
   * @return this specifies the constitution of the player.
   */
  public int getConstitution() {
    return this.constitution;
  }

  /**
   * This helps to get the dexterity of the player.
   *
   * @return this specifies the dexterity of the player.
   */
  public int getDexterity() {
    return this.dexterity;
  }

  /**
   * This helps to get the charisma of the player.
   *
   * @return this specifies the charisma of the player.
   */

  public int getCharisma() {
    return this.charisma;
  }

  /**
   * This helps to get the health of the player.
   *
   * @return this specifies the health of the player.
   */

  public int getHealth() {
    return this.health;
  }

  /**
   * This helps to update the health of the player.
   *
   * @param damage the damage which the other player does.
   */

  public void modifyHealth(int damage) {
    if (damage > 0) {
      this.effectiveHealth = this.effectiveHealth - damage;
    }
  }

  private int calculateEffectiveAbility(Ability obj) {
    int size = equippedGear.size();
    int gearSum = 0;
    /* Now we will add the effect of the gear equipped by the player which affects the ability. */
    for (int i = 0; i < size; i++) {
      Gear gear = this.equippedGear.get(i);
      if (gear.getAbilityAffected() == obj) {
        gearSum = gearSum + gear.getEffect();
      }
    }
    return gearSum;
  }

  /**
   * This method calculates the total striking power of an individual player.
   *
   * @throws IllegalStateException if striking power is called before equipping gear.
   */
  protected void calculateStrikingPower() throws IllegalStateException {
    if (equippedGear.size() == 0) {
      throw new IllegalStateException("The Striking ability can not be calculated before player"
              + "having gear");
    }

    /* Now we will add the random number between 1 and 10 in to the striking power */
    this.strikingPower = this.getEffectiveStrength()
            + randomNumber.getRandomNumber(1, 10);
  }

  /**
   * This method specifies the striking power of the player.
   *
   * @return the striking power of the player.
   * @throws IllegalStateException if the striking power is called before initializing gear.
   */
  public int getStrikingPower() throws IllegalStateException {
    if (equippedGear.size() == 0) {
      throw new IllegalStateException("You can not get striking power before initializing gear");
    }
    return this.strikingPower;
  }

  /**
   * This method calculates the avoidance ability of the player.
   *
   * @throws IllegalStateException if the method is called before initializing the gear.
   */
  protected void calculateAvoidanceAbility() throws IllegalStateException {
    if (equippedGear.size() == 0) {
      throw new IllegalStateException("The Avoidance ability can not be calculated before player"
              + "having gear");
    }
    /* Now we will add the random number between 0 to 6 in to the avoidance ability */
    this.avoidanceAbility = this.getEffectiveDexterity()
            + randomNumber.getRandomNumber(1, 6);
  }

  /**
   * This method specifies the avoidance ability of the player.
   *
   * @return the avoidance ability of the player.
   * @throws IllegalStateException if the avoidance ability is called before initializing gear.
   */

  public int getAvoidanceAbility() throws IllegalStateException {
    if (equippedGear.size() == 0) {
      throw new IllegalStateException("You can not get Avoidance ability before initializing gear");
    }
    return this.avoidanceAbility;
  }


  /**
   * This method is used to get the list of the gear from the bag.
   *
   * @param bag the object of arena class which will provide the list of gears to player.
   */
  protected void equippedGearHelper(Arena bag) {
    int maxHeadGear = 1;
    int maxFootWear = 1;
    int noOfUnits = 0;
    List<Gear> gearsInList = new ArrayList<Gear>();
    gearsInList = bag.getListOfGear();
    int size = gearsInList.size();
    for (int i = 0; i < size; i++) {
      Gear gearObj = gearsInList.get(i);
      if (gearObj.equals(new HeadGear("HeadGear", randomNumber))) {
        if (maxHeadGear == 1) {
          equippedGear.add(gearObj);
          maxHeadGear = 0;
        }
      } else if (gearObj.equals(new FootWear("FootWear", randomNumber))) {
        if (maxFootWear == 1) {
          equippedGear.add(gearObj);
          maxFootWear = 0;
        }
      } else if (gearObj.equals(
              new Belt("Belt", Ability.CHARISMA, BeltSize.LARGE, randomNumber))) {
        if (((Belt) gearObj).getSize() == BeltSize.SMALL && noOfUnits < 10) {
          equippedGear.add(gearObj);
          noOfUnits += 1;
        } else if (((Belt) gearObj).getSize() == BeltSize.MEDIUM && noOfUnits < 9) {
          equippedGear.add(gearObj);
          noOfUnits += 2;
        } else if (((Belt) gearObj).getSize() == BeltSize.LARGE && noOfUnits < 7) {
          equippedGear.add(gearObj);
          noOfUnits += 4;
        }
      } else {
        equippedGear.add(gearObj);
      }
    }
  }


  /**
   * This method provides the player with the list of the weapon.
   *
   * @param bag the object of the Arena class
   */
  protected void equipWeapon(Arena bag) {
    equippedWeapon = bag.getWeapon();

  }

  /**
   * This class specifies the list of the gear equipped by a player.
   *
   * @return the list of equipped gear.
   * @throws IllegalStateException if the equipped gear is called when player has no gear
   */
  public List<Gear> getEquippedGear() throws IllegalStateException {
    if (equippedGear != null) {
      // returning deep copy
      List<Gear> equipped1 = new ArrayList<>();
      equipped1.addAll(this.equippedGear);
      return equipped1;
    }
    throw new IllegalStateException("You can not request the equipped gear without player"
            + "having the gear list");
  }

  /**
   * This class specifies the list of the weapon equipped by a player.
   *
   * @return the list of equipped weapon.
   * @throws IllegalStateException if the get weapon is called when player has no weapon.
   */
  public List<Weapon> getEquippedWeapon() throws IllegalStateException {
    List<Weapon> weapon1 = new ArrayList<>();
    weapon1.addAll(this.equippedWeapon);
    return weapon1;
  }

  public int getEffectiveStrength() {
    return Math.max(this.strength + calculateEffectiveAbility(Ability.STRENGTH), 0);
  }

  public int getEffectiveDexterity() {
    return Math.max(this.dexterity + calculateEffectiveAbility(Ability.DEXTERITY), 0);
  }

  public int getEffectiveConstitution() {
    return Math.max(this.constitution + calculateEffectiveAbility(Ability.CONSTITUTION), 0);
  }

  public int getEffectiveCharisma() {
    return Math.max(this.charisma + calculateEffectiveAbility(Ability.CHARISMA), 0);
  }

  protected void calculateEffectiveHealth() {
    this.effectiveHealth = this.getEffectiveStrength() + this.getEffectiveCharisma()
            + this.getEffectiveConstitution() + this.getEffectiveDexterity();
  }

  /**
   * This method specifies the sorted order of the gear quip by the player. The gears are sort by
   * the prespecified order given to then using double dispatch in compareTo.
   *
   * @return the Sorted array of gear.
   */
  public Gear[] getSortedListOfGears() {
    int size = equippedGear.size();
    Gear[] gArray = new Gear[size];
    for (int i = 0; i < size; i++) {
      gArray[i] = equippedGear.get(i);
    }
    Arrays.sort(gArray);
    return gArray;
  }

  @Override
  public String toString() {
    return String.format("Player "
            + "\nname " + name
            + "\nstrength " + strength
            + "\nconstitution " + constitution
            + "\ndexterity " + dexterity
            + "\ncharisma " + charisma
            + "\nhealth " + health
            + "\nstrikingPower " + strikingPower
            + "\navoidanceAbility " + avoidanceAbility);
  }

  /**
   * This method is used to get the effective health of player.
   *
   * @return the effective health.
   */
  public int getEffectiveHealth() {
    return Math.max(this.effectiveHealth, 0);
  }

  protected void regainHealth(int health) {
    this.effectiveHealth = health;
  }
}
