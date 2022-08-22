package battle;

/**
 * This class specifies the special type of sword named as battle.Katanas.
 * It is a light weight curved sword and comes in pair with individual attacking capacity.
 */
public class Katanas extends Sword {
  /**
   * This constructs the object of the battle.Katanas sword.
   *
   * @param name the name of the katana's sword.
   * @throws IllegalArgumentException if the name is NULL,
   *                                  if the name is emoty.
   */
  public Katanas(String name) throws IllegalArgumentException {
    super(name, 4, 6, 4);
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
    return id;
  }

  @Override
  protected boolean equalsKatanas(Katanas other) {
    return true;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Sword) {
      Sword sword = (Sword) other;
      return sword.equalsKatanas(this);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("Katanas "
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
