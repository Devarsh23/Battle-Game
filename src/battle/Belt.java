package battle;

/**
 * This class represents the battle.Belt used by the player in the battle. It specifies the name,
 * ability affected, and order of the battle.Belt.
 */
public class Belt extends AbstractGear {
  private int order;
  private BeltSize size;

  /**
   * This constructs the object of the battle.Belt class.
   *
   * @param name            the name of the belt.
   * @param abilityAffected the particular ability of the player affected by the battle.Belt.
   * @throws IllegalArgumentException if the random object is NULL
   */
  public Belt(String name, Ability abilityAffected, BeltSize size, ValueGenerator random)
        throws IllegalArgumentException {
    super(name, random.getRandomNumber(1, 10), abilityAffected);
    if (random == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    this.size = size;
    this.order = 3;
  }

  @Override
  public void doNegative() {
    this.effect = -1 * this.effect;
  }

  @Override
  public boolean isNegative() {
    return (this.effect < 0 ? true : false);
  }

  @Override
  public String toString() {
    return String.format("Belt "
            + "\nname " + name
            + "\nabilityAffected " + abilityAffected
            + "\neffect " + effect
            + "\norder " + order
            + "\nsize " + size);
  }

  @Override
  protected int compareToBelt(Belt o) {
    return this.name.compareTo(((AbstractGear) o).getName());
  }

  @Override
  protected int getOrder() {
    return this.order;
  }

  @Override
  public int compareTo(Gear o) {
    AbstractGear aGear = (AbstractGear) o;
    return (-1) * aGear.compareToBelt(this);
  }

  @Override
  protected boolean equalsBelt(Belt other) {
    return true;
  }

  @Override
  public Ability getAbilityAffected() {
    return abilityAffected;
  }

  @Override
  public int getEffect() {
    return this.effect;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof AbstractGear) {
      AbstractGear aGear = (AbstractGear) other;
      return aGear.equalsBelt(this);
    }
    return false;
  }

  /**
   * This class specifies the size of a particular belt.
   */

  protected BeltSize getSize() {
    return this.size;
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
