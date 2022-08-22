package battle;

/**
 * This class generates the value in the previously defined manner. It is used in our project
 * to test the functionality.
 */
public class DefinedNumberGenerator implements ValueGenerator {
  @Override
  public int getRandomNumber(int lower, int upper) {
    return (lower + upper) / 3;
  }
}
