package battle;

import java.util.Random;

/**
 * This class generates the value in the complete random manner. It is used in our project
 * to get the random value when it is needed.
 */
public class RandomValueGenerator implements ValueGenerator {

  @Override
  public int getRandomNumber(int lower, int upper) {
    Random rand = new Random();
    return rand.nextInt(upper - lower) + lower;
  }
}
