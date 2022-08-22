package battle;

/**
 * This class specifies the special type of sword named as battle.BroadSwords. It is a medium type
 * weapon and can do 6 to 10 point damage when they hit.
 */
public class BroadSwords extends Sword {
  /**
   * This constructs the object of BroadSword class.
   *
   * @param name the name of the sword.
   * @throws IllegalArgumentException if the name is empty,
   *                                  if the name is NULL.
   */
  public BroadSwords(String name) throws IllegalArgumentException {
    super(name, 6, 10, 3);
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (name == null) {
      throw new IllegalArgumentException("The name can not be NULL");
    }
  }

  @Override
  public int getMinDamage() {
    return this.minDamage;
  }

  @Override
  public int getMaxDamage() {
    return this.maxDamage;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  protected boolean equalsBroadSwords(BroadSwords other) {
    return true;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Sword) {
      Sword sword = (Sword) other;
      return sword.equalsBroadSwords(this);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("BroadSwords "
            + "\nname " + name
            + "\nminDamage " + minDamage
            + "\nmaxDamage " + maxDamage
            + "\nid=" + id);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
