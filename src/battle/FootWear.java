package battle;

/**
 * This class represents the battle.FootWear used by the player in the battle.
 * It specifies the name, ability affected, and order of the battle.Belt.
 */
public class FootWear extends AbstractGear {
  private int order;

  /**
   * This constructs the object of the Footwear class.
   *
   * @param name the name of the Footwear.
   * @throws IllegalArgumentException if name is empty,
   *                                  if name is NULL,
   *                                  if random is NULL.
   */
  public FootWear(String name, ValueGenerator random)
          throws IllegalArgumentException {
    super(name, random.getRandomNumber(1, 10), Ability.DEXTERITY);
    if (name == null) {
      throw new IllegalArgumentException("The name can not be NULL");
    }
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (random == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    this.order = 4;
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
    return String.format("battle.FootWear : effect=" + effect
            + "\nname='" + name
            + "\nabilityAffected=" + abilityAffected
            + "\norder=" + order);
  }

  @Override
  protected int compareToFootwear(FootWear o) {
    return this.name.compareTo(((AbstractGear) o).getName());
  }

  @Override
  protected int getOrder() {
    return this.order;
  }

  @Override
  public int compareTo(Gear o) {
    AbstractGear aGear = (AbstractGear) o;
    return (-1) * aGear.compareToFootwear(this);
  }

  @Override
  protected boolean equalsFootWear(FootWear other) {
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
      return aGear.equalsFootWear(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
