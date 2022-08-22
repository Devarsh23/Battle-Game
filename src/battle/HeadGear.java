package battle;

/**
 * This class represents the battle.HeadGear used by the player in the battle.
 * It specifies the name, ability affected, and order of the battle.HeadGear
 */
public class HeadGear extends AbstractGear {
  private int order;

  /**
   * This constructs the object of the battle.HeadGear class.
   *
   * @param name the name of the battle.HeadGear.
   * @throws IllegalArgumentException if the name is empty,
   *                                  if the name is NULL,
   *                                  if the random is nULL
   */

  public HeadGear(String name, ValueGenerator random)
          throws IllegalArgumentException {
    super(name, random.getRandomNumber(1, 10), Ability.CONSTITUTION);
    if (name == null) {
      throw new IllegalArgumentException("The name can not be NULL");
    }
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (random == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    this.order = 1;
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
    return String.format("HeadGear : effect=" + effect
            + "\nname " + name
            + "\nabilityAffected " + abilityAffected
            + "\norder " + order);
  }

  @Override
  protected int compareToHeadGear(HeadGear o) {
    return this.name.compareTo((o).getName());
  }

  @Override
  protected int getOrder() {
    return this.order;
  }

  @Override
  public int compareTo(Gear o) {
    AbstractGear aGear = (AbstractGear) o;
    return (-1) * aGear.compareToHeadGear(this);
  }

  @Override
  protected boolean equalsHeadGear(HeadGear other) {
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
      return aGear.equalsHeadGear(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }


}


