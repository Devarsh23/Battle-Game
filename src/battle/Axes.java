package battle;

/**
 * This class specifies the battle.Axes weapon. It implements the weapon interface.
 * It includes the fields like name of weapon, min and max damage it can make.
 */
public class Axes implements Weapon {
  private String name;
  private int minDamage;
  private int maxDamage;
  private int id;


  /**
   * This constructs the object of the battle.Axes weapon.
   * @param name the name of the axes weapon.
   * @throws IllegalArgumentException if the name is empty,
   *                                  if the name is null.
   */
  public Axes(String name) throws IllegalArgumentException {
    if (name.equals("")) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (name == null) {
      throw new IllegalArgumentException("The name can not be null");
    }
    this.name = name;
    this.minDamage = 6;
    this.maxDamage = 10;
    this.id = 1;
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
  public String toString() {
    return String.format("Axes"
            + "\nname " + name
            + "\nminDamage " + minDamage
            + "\nmaxDamage " + maxDamage
            + "\nid " + id);
  }
}
