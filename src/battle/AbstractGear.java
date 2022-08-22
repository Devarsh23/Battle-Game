package battle;

/**
 * This is the abstract class gear which implements the gear interface. It includes the fields
 * commonly shared between each gear and different compareTo and equals method to support
 * double dispatch concept.
 */
public abstract class AbstractGear implements Gear {
  protected String name;
  protected Ability abilityAffected;
  protected int effect;

  /**
   * This method constructs the object of the battle.AbstractGear class. By initializing its fields
   *
   * @param name            the name of the gear.
   * @param effect          the effect of the gear on the player's ability.
   * @param abilityAffected the ability of the player affected by the gear.
   * @throws IllegalArgumentException if the name is empty,
   *                                  if name is null,
   *                                  effect is out of range.
   */
  protected AbstractGear(String name, int effect, Ability abilityAffected)
          throws IllegalArgumentException {
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (name == null) {
      throw new IllegalArgumentException("The name can not be null");
    }
    if (effect > 10 || effect < 0 ) {
      throw new IllegalArgumentException("The effect is in range of 0 to 10");
    }
    this.name = name;
    this.effect = effect;
    this.abilityAffected = abilityAffected;
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to compare
   * the object with battle.HeadGear object.
   *
   * @param o Object of the battle.HeadGear class.
   * @return the difference of the order of the calling object and the parameter object.
   */
  protected int compareToHeadGear(HeadGear o) {
    return this.getOrder() - ((AbstractGear) o).getOrder();
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to compare
   * the object with battle.Potion object.
   *
   * @param o Object of the battle.Potion class.
   * @return the difference of the order of the calling object and the parameter object.
   */

  protected int compareToPotion(Potion o) {
    return this.getOrder() - ((AbstractGear) o).getOrder();
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to compare
   * the object with battle.Belt object.
   *
   * @param o Object of the battle.Belt class.
   * @return the difference of the order of the calling object and the parameter object.
   */

  protected int compareToBelt(Belt o) {
    return this.getOrder() - ((AbstractGear) o).getOrder();
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to compare
   * the object with footwear object.
   *
   * @param o Object of the Footwear class.
   * @return the difference of the order of the calling object and the parameter object.
   */

  protected int compareToFootwear(FootWear o) {
    return this.getOrder() - ((AbstractGear) o).getOrder();
  }

  /**
   * This method specifies the order in which the object of the abstract gear interface should
   * arrange while sorting them. 1 is the top priority order.
   *
   * @return the order of the object of battle.AbstractGear type which has called it.
   */
  protected abstract int getOrder();

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of battle.HeadGear type or not.
   *
   * @param o Object of the battle.HeadGear class.
   * @return false
   */

  protected boolean equalsHeadGear(HeadGear o) {
    return false;
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of battle.Potion type or not.
   *
   * @param o Object of the battle.Potion class.
   * @return false
   */

  protected boolean equalsPotion(Potion o) {
    return false;
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of battle.Belt type or not.
   *
   * @param o Object of the battle.Belt class.
   * @return false
   */

  protected boolean equalsBelt(Belt o) {
    return false;
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of footwear type or not.
   *
   * @param o Object of the Footwear class.
   * @return false
   */

  protected boolean equalsFootWear(FootWear o) {
    return false;
  }

  /**
   * This is the getter method of the name of the gear.
   *
   * @return the name of the gear
   */
  public String getName() {
    return this.name;
  }

}