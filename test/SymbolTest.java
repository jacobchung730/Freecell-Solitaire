

import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.Symbol;
import org.junit.Test;

/**
 * tests for the {@code Symbol} class.
 */
public class SymbolTest {

  @Test
  public void testToStringClubs() {
    assertEquals("♣", Symbol.CLUBS.toString());
  }

  @Test
  public void testToStringHearts() {
    assertEquals("♥", Symbol.HEARTS.toString());
  }

  @Test
  public void testToStringSpades() {
    assertEquals("♠", Symbol.SPADES.toString());
  }

  @Test
  public void testToStringDiamonds() {
    assertEquals("♦", Symbol.DIAMONDS.toString());
  }


}