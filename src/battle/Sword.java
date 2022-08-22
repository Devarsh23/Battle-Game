package battle;

/**
 * This is the sword abstract class. It specifies the detail about the sword fields like name,
 * minimum damage, and maximum damage.
 */
public abstract class Sword implements Weapon {
  protected String name;
  protected int minDamage;
  protected int maxDamage;
  protected int id;

  /**
   * This the constructor of the abstract class it helps to initialize the objects which are common
   * in the subclasses.
   * @param name the name of the sword
   * @param minDamage the minDamage the sword can do.
   * @param maxDamage the maxDamage the sword can do.
   * @throws IllegalArgumentException if the name is NULL,
   *                                  if the name is empty,
   *                                  if min damage is negative or zero,
   *                                  if max damage is negative or zero,
   *                                  if id is negative or zero.
   */
  protected Sword(String name, int minDamage, int maxDamage, int id) {
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (name == null) {
      throw new IllegalArgumentException("The name can not be NULL");
    }
    if (minDamage <= 0) {
      throw new IllegalArgumentException("The minimum value can not be zero or negative");
    }
    if (maxDamage <= 0) {
      throw new IllegalArgumentException("The minimum value can not be zero or negative");
    }
    if (id <= 0) {
      throw new IllegalArgumentException("The id can not be zero or negative");
    }
    this.name = name;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    this.id = id;
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of Katanas type or not.
   * @param o Object of the Katanas class.
   * @return false
   */
  protected boolean equalsKatanas(Katanas o) {
    return false;
  }
  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of TwoHandedSword type or not.
   * @param o Object of the Katanas class.
   * @return false
   */

  protected boolean equalsTwoHandedSwords(TwoHandedSwords o) {
    return false;
  }

  /**
   * This method helps to use the dynamic dispatch method in Java. It is used to calculate
   * whether both the instances are of BroadSwords type or not.
   * @param o Object of the BroadSwords class.
   * @return false
   */
  protected boolean equalsBroadSwords(BroadSwords o) {
    return false;
  }
}
