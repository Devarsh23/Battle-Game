package battle;

/**
 * This class specifies the special type of sword named as TwoHandedSword.
 * It is a heavy sword and can damage up to its full capacity if the strength of the player is
 * greater than 14.
 */
public class TwoHandedSwords extends Sword {
  /**
   * This constructs the object of the TwoHandedSword.
   *
   * @param name the name of the sword.
   * @throws IllegalArgumentException if name is empty,
   *                                  if the name is NULL.
   */
  public TwoHandedSwords(String name) throws IllegalArgumentException {
    super(name, 8, 12, 5);
    if (name == null) {
      throw new IllegalArgumentException("The name can not be NULL");
    }
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
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
  protected boolean equalsTwoHandedSwords(TwoHandedSwords other) {
    return true;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Sword) {
      Sword sword = (Sword) other;
      return sword.equalsTwoHandedSwords(this);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("TwoHandedSwords "
            + "\nname " + name
            + "\nminDamage " + minDamage
            + "\nmaxDamage " + maxDamage
            + "\nid " + id);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
