package battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This class is used to test the Katanas class.
 */
public class KatanasTest {
  private Katanas testDemo;

  /**
   * This method is easy and short way of creating instances of a new
   * Katanas object.
   *
   * @param name the name of the Katanas.
   * @return a new instance of a Katana class object
   */
  protected Katanas testKatanas(String name) {
    return new Katanas(name);
  }

  @Before
  public void setUp() throws Exception {
    testDemo = new Katanas("test");
  }

  @Test
  public void getMinDamage() {
    assertEquals(testDemo.getMinDamage(), 4);
  }

  @Test
  public void getMaxDamage() {
    assertEquals(testDemo.getMaxDamage(), 6);
  }

  @Test
  public void getName() {
    assertEquals(testDemo.getName(), "test");
  }

  @Test
  public void getId() {
    assertEquals(testDemo.getId(), 4);
  }

  @Test
  public void testEquals() {
    assertEquals(testDemo.equals(new Katanas("demo")), true);
  }

  @Test
  public void testToString() {
    assertEquals(testDemo.toString(), "Katanas \n"
            + "name test\n"
            + "minDamage 4\n"
            + "maxDamage 6\n"
            + "id 4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfEmptyName() {
    testKatanas("");
  }
}