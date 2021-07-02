

import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.Value;
import org.junit.Test;

/**
 * tests for the {@code Value} class.
 */
public class ValueTest {

  @Test
  public void testToStringAce() {
    assertEquals("A", Value.ACE.toString());
  }

  @Test
  public void testToStringTwo() {
    assertEquals("2", Value.TWO.toString());
  }

  @Test
  public void testToStringTen() {
    assertEquals("10", Value.TEN.toString());
  }

  @Test
  public void testToStringQueen() {
    assertEquals("Q", Value.QUEEN.toString());
  }

  @Test
  public void testGetIndexQueen() {
    assertEquals(11, Value.QUEEN.getIndex());
  }

  @Test
  public void testGetIndexAce() {
    assertEquals(0, Value.ACE.getIndex());
  }



}