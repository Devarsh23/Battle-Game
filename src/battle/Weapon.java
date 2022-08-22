package battle;

/**
 * This interface represents the weapons used in the battle game.
 */
public interface Weapon {
  /**
   * This is the getter method of the weapons which specifies the minimum damage the weapon can
   * do.
   *
   * @return the minimum damage the weapon object can provide.
   */
  public int getMinDamage();

  /**
   * This is the getter method of the weapon which specifies the maximum damage the battle.
   * Weapon can do.
   *
   * @return the maximum damage the weapon object can provide.
   */

  int getMaxDamage();

  /**
   * This is the getter method of the weapons. It specifies the name of the particular weapon.
   *
   * @return the name of the weapon
   */
  String getName();

  /**
   * This is used to get the id of the weapon.
   */
  int getId();
}
