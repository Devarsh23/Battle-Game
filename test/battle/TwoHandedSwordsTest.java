package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This Class is used to test the two handed swords class.
 */
public class TwoHandedSwordsTest {
  private TwoHandedSwords testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * Twohanded Swords object.
   *
   * @param name the name of the TwohandedSwords.
   * @return a new instance of a TwoHandedSwords class object
   */
  protected TwoHandedSwords testTwoHandedSwords(String name) {
    return new TwoHandedSwords(name);
  }

  @Before
  public void setUp() throws Exception {
    testDemo = testTwoHandedSwords("test");
  }

  @Test
  public void getMinDamage() {
    assertEquals(testDemo.getMinDamage(), 8);
  }

  @Test
  public void getMaxDamage() {
    assertEquals(testDemo.getMaxDamage(), 12);
  }

  @Test
  public void getName() {
    assertEquals(testDemo.getName(), "test");
  }

  @Test
  public void getId() {
    assertEquals(testDemo.getId(), 5);
  }

  @Test
  public void testEquals() {
    assertEquals(testDemo.equals(new TwoHandedSwords("demo")), true);
  }

  @Test
  public void testToString() {
    assertEquals(testDemo.toString(), "TwoHandedSwords \n"
            + "name test\n"
            + "minDamage 8\n"
            + "maxDamage 12\n"
            + "id 5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testTwoHandedSwords("");
  }
}