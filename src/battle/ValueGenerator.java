package battle;

/**
 * This interface is used to generate the random value for the using it throughout the project.
 */
public interface ValueGenerator {
  /**
   * This method is used to generate the random integer in the given range.
   *
   * @return the generated number in the given range.
   */
  int getRandomNumber(int lower, int upper);
}

