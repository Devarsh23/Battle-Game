package battle;

/**
 * This interface represents the gear used in the battle game. It includes the method that is
 * requires for each type of the gear used in the battle.
 */
public interface Gear extends Comparable<Gear> {
  /**
   * This method makes the effect of the gear on a player's ability negative.
   * We have used this method to specify that the particular gear can affect negatively
   * to the player's ability if this method is called.
   */
  void doNegative();

  /**
   * This method specifies whether the gear is affecting the player's abililty in a negative
   * manner or not.
   */

  boolean isNegative();

  /**
   * This method specifies the ability which is affected by the particular gear. It must affcet in a
   * positive or a negative way.
   */
  Ability getAbilityAffected();

  /**
   * This method specifies the effect of the gear on the player ability.
   */
  int getEffect();
}
