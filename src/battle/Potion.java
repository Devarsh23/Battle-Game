package battle;

/**
 * This class represents the battle.Potion used by the player in the battle. It specifies the name,
 * ability affected, and order of the battle.Potion.
 */
public class Potion extends AbstractGear {
  private int order;

  /**
   * This constructs the object of the potion class.
   *
   * @param name            the name of the battle.Potion.
   * @param abilityAffected the particular ability of the player affected by the battle.Potion.
   * @throws IllegalArgumentException if the name is empty,
   *                                  if the name is NULL,
   *                                  if the random is NULl
   */

  public Potion(String name, Ability abilityAffected, ValueGenerator random)
          throws IllegalArgumentException {
    super(name, random.getRandomNumber(1, 10), abilityAffected);
    if (name == null) {
      throw new IllegalArgumentException("The name can not be NULL");
    }
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (random == null) {
      throw new IllegalArgumentException("The random object can not be null");
    }
    this.order = 2;
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
    return String.format("battle.Potion : effect=" + effect
            + "\nname='" + name
            + "\nabilityAffected=" + abilityAffected
            + "\norder=" + order);
  }

  @Override
  protected int compareToPotion(Potion o) {
    return this.name.compareTo(((AbstractGear) o).getName());
  }

  @Override
  protected int getOrder() {
    return this.order;
  }

  @Override
  public int compareTo(Gear o) {
    AbstractGear aGear = (AbstractGear) o;
    return (-1) * aGear.compareToPotion(this);
  }

  @Override
  protected boolean equalsPotion(Potion other) {
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
      return aGear.equalsPotion(this);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
